package datamanagement;

<<<<<<< HEAD
import org.jdom.Element;
=======
import org.jdom.*;
>>>>>>> parent of ee042d1... Fixes for Review 1
import java.util.List;
public class StudentManager {
    private static StudentManager studentManager_ = null;
    private StudentMap studentMap_;
    private java.util.HashMap<String, StudentMap> studentHashMap_;

    public static StudentManager get() {
        if (studentManager_ == null) 
            studentManager_ = new StudentManager(); 
<<<<<<< HEAD

        return studentManager_; 
    }


=======
        
        return studentManager_; 
    }
    
    
>>>>>>> parent of ee042d1... Fixes for Review 1
    private StudentManager() {
        studentMap_ = new StudentMap();
        studentHashMap_ = new java.util.HashMap<>();    
    }
<<<<<<< HEAD

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
=======
    
    public IStudent getStudent(Integer id) {
    	IStudent iStudent = studentMap_.get(id);
    	return iStudent != null ? iStudent : createStudent(id);
    }

	private Element getStudentElement(Integer id) {
	    for (Element element : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentTable").getChildren("student")) 
	    	if (id.toString().equals(element.getAttributeValue("sid"))) 
	    		return element;
	    return null;
	}
	
    private IStudent createStudent(Integer id) {
        IStudent iStudent;
        Element element = getStudentElement(id);
        if (element != null) {
            StudentUnitRecordList unitRecordList = StudentUnitRecordManager.instance().getRecordsByStudent(id);
            iStudent = new Student(new Integer(element.getAttributeValue("sid")),element.getAttributeValue("fname"),element.getAttributeValue("lname"),unitRecordList);
            studentMap_.put(iStudent.getID(), iStudent);
            return iStudent; 
        }
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }
    
    private IStudent createStudentProxy(Integer id) {
        Element element = getStudentElement(id);
        if (element != null) 
        	return new StudentProxy(id, element.getAttributeValue("fname"), element.getAttributeValue("lname"));
>>>>>>> parent of ee042d1... Fixes for Review 1
        throw new RuntimeException("DBMD: createStudent : student not in file");
        }

<<<<<<< HEAD
    public StudentMap getStudentsByUnit(String unitCode) {
        StudentMap studentMap = studentHashMap_.get(unitCode);
=======
        public StudentMap getStudentsByUnit(String uc) {
        StudentMap studentMap = studentHashMap_.get(uc);
>>>>>>> parent of ee042d1... Fixes for Review 1
        if (studentMap != null) {
        	return studentMap;
        }

        studentMap = new StudentMap();
<<<<<<< HEAD
        IStudent student;
        StudentUnitRecordList studentUnitRecordList = StudentUnitRecordManager.instance().getRecordsByUnit(unitCode);
        for (IStudentUnitRecord studentUnitRecord : studentUnitRecordList) {
            student = createStudentProxy(new Integer(studentUnitRecord.getStudentID()));
            studentMap.put(student.getID(), student);
        }

        studentHashMap_.put( unitCode, studentMap);
=======
        IStudent id;
        StudentUnitRecordList sUnitRecordList = StudentUnitRecordManager.instance().getRecordsByUnit(uc);
        for (IStudentUnitRecord sUnitRecord : sUnitRecordList) {
            id = createStudentProxy(new Integer(sUnitRecord.getStudentID()));
            studentMap.put(id.getID(), id);
        }
        
        studentHashMap_.put( uc, studentMap);
>>>>>>> parent of ee042d1... Fixes for Review 1
        return studentMap;

        }
}
