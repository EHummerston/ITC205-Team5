package datamanagement;

import org.jdom.Element;

import java.util.List;

public class StudentManager {
    private static StudentManager studentManager_ = null;
    private StudentMap studentMap_;
    private java.util.HashMap<String, StudentMap> studentHashMap_;

    public static StudentManager get() {
        if (studentManager_ == null)
            studentManager_ = new StudentManager();

        return studentManager_;
    }

    private StudentManager() {
        studentMap_ = new StudentMap();
        studentHashMap_ = new java.util.HashMap<>();
    }

    public IStudent getStudent(Integer id) {
        IStudent student = studentMap_.get(id);
        return student != null ? student : createStudent(id);
    }

    private Element getStudentElement(Integer id) {
        for (Element element : (List<Element>) XMLManager.getXMLManager()
                .getDocument().getRootElement().getChild("studentTable")
                .getChildren("student"))
            if (id.toString().equals(element.getAttributeValue("sid")))
                return element;
        return null;
    }

    private IStudent createStudent(Integer id) {
        IStudent iStudent;
        Element element = getStudentElement(id);
        if (element != null) {
            StudentUnitRecordList unitRecordList = StudentUnitRecordManager
                    .instance().getRecordsByStudent(id);
            iStudent = new Student(
                    new Integer(element.getAttributeValue("sid")),
                    element.getAttributeValue("fname"),
                    element.getAttributeValue("lname"), unitRecordList);
            studentMap_.put(iStudent.getID(), iStudent);
            return iStudent;
        }
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }

    private IStudent createStudentProxy(Integer id) {
        Element element = getStudentElement(id);
        if (element != null)
            return new StudentProxy(id, element.getAttributeValue("fname"),
                    element.getAttributeValue("lname"));
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }

    public StudentMap getStudentsByUnit(String uc) {
        StudentMap studentMap = studentHashMap_.get(uc);
        if (studentMap != null) {
            return studentMap;
        }

        studentMap = new StudentMap();
        IStudent id;
        StudentUnitRecordList sUnitRecordList = StudentUnitRecordManager
                .instance().getRecordsByUnit(uc);
        for (IStudentUnitRecord sUnitRecord : sUnitRecordList) {
            id = createStudentProxy(new Integer(sUnitRecord.getStudentID()));
            studentMap.put(id.getID(), id);
        }

        studentHashMap_.put(uc, studentMap);
        return studentMap;

    }
}
