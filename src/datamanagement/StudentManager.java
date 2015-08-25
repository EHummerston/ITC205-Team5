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

    public IStudent getStudent(int studentId) {
        IStudent student = studentMap_.get(studentId);
        return student != null ? student : createStudent(studentId);
    }

    private Element getStudentElement(int studentId) {
        for (Element element : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentTable").getChildren("student")) 
            if (studentId.toString().equals(element.getAttributeValue("sid"))) 
                return element;
        return null;
    }

    private IStudent createStudent(int studentId) {
        IStudent student;
        Element element = getStudentElement(studentId);
        if (element != null) {
            StudentUnitRecordList studentUnitRecordList = StudentUnitRecordManager.instance().getRecordsByStudent(studentId);
            student = new Student(new Integer(element.getAttributeValue("sid")),element.getAttributeValue("fname"),element.getAttributeValue("lname"),studentUnitRecordList);
            studentMap_.put(student.getID(), student);
            return student; 
        }
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }

    private IStudent createStudentProxy(int studentId) {
        Element element = getStudentElement(studentId);
        if (element != null) 
            return new StudentProxy(studentId, element.getAttributeValue("fname"), element.getAttributeValue("lname"));
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }

    public StudentMap getStudentsByUnit(String unitCode) {
        StudentMap studentMap = studentHashMap_.get(unitCode);
        if (studentMap != null) {
            return studentMap;
        }

        studentMap = new StudentMap();
        IStudent student;
        StudentUnitRecordList studentUnitRecordList = StudentUnitRecordManager.instance().getRecordsByUnit(unitCode);
        for (IStudentUnitRecord studentUnitRecord : studentUnitRecordList) {
            student = createStudentProxy(new Integer(studentUnitRecord.getStudentID()));
            studentMap.put(student.getID(), student);
        }

        studentHashMap_.put( unitCode, studentMap);
        return studentMap;

    }
}
