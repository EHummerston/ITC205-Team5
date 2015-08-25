package datamanagement;

import java.util.List;

import org.jdom.Element;

public class StudentUnitRecordManager {

  private static StudentUnitRecordManager studentUnitRecordManager_ = null;
  private StudentUnitRecordMap studentUnitRecordMap_;
  private java.util.HashMap<String, StudentUnitRecordList> unitRecordCodes_;
  private java.util.HashMap<Integer, StudentUnitRecordList> studentCodes_;

  public static StudentUnitRecordManager instance() {
    if (studentUnitRecordManager_ == null) studentUnitRecordManager_ =
            new StudentUnitRecordManager();
    return studentUnitRecordManager_;
  }

  private StudentUnitRecordManager() {
    studentUnitRecordMap_ = new StudentUnitRecordMap();
    unitRecordCodes_ = new java.util.HashMap<>();
    studentCodes_ = new java.util.HashMap<>();
  }

  /**
   * Used to check if a unit record is initialised,
   * if not one is created and returned
   * @return - A student unit record
   */
  public IStudentUnitRecord getStudentUnitRecord(Integer studentCode,
                                                 String unitCode) {
    IStudentUnitRecord studentUnitRecord = studentUnitRecordMap_.get(
            studentCode.toString() + unitCode);
    return studentUnitRecord != null ? studentUnitRecord :
            createStudentUnitRecord(studentCode, unitCode);
  }

  /**
   * Creates a student Record for the student and subject provided as parameters
   * @param studentCode - the Students Unique ID
   * @param unitCode - The Subjects Unique ID
   * @return - The students unit Record
   */
  private IStudentUnitRecord createStudentUnitRecord(Integer studentCode,
                                                     String unitCode) {
    IStudentUnitRecord studentUnitRecord;
    for (Element el : (List<Element>) XMLManager.getXML().getDocument()
            .getRootElement().getChild("studentUnitRecordTable")
            .getChildren("record")) {
      if (studentCode.toString().equals(el.getAttributeValue("sid")) &&
              unitCode.equals(el.getAttributeValue("uid"))) {
        studentUnitRecord = new StudentUnitRecord(new Integer(
                el.getAttributeValue("sid")), el.getAttributeValue("uid"),
                new Float(el.getAttributeValue("asg1")).floatValue(),
                new Float(el.getAttributeValue("asg2")).floatValue(),
                new Float(el.getAttributeValue("exam")).floatValue());
        studentUnitRecordMap_.put(studentUnitRecord.getStudentId().toString() +
                studentUnitRecord.getUnitCode(), studentUnitRecord);
        return studentUnitRecord;
      }
    }
    throw new RuntimeException(
            "DBMD: createStudent : student unit record not in file");
  }

  /**
   * Creates a List of results for all instances of the specified unit code
   * @param unitCode
   * @return
   */
  public StudentUnitRecordList getRecordsByUnit(String unitCode) {
    StudentUnitRecordList studentUnitRecordList = unitRecordCodes_.get(
            unitCode);
    if (studentUnitRecordList != null){
      return studentUnitRecordList;
    }
    studentUnitRecordList = new StudentUnitRecordList();
    for (Element el : (List<Element>) XMLManager.getXML().getDocument()
            .getRootElement().getChild("studentUnitRecordTable")
            .getChildren("record")) {
      if (unitCode.equals(el.getAttributeValue("uid")))
        studentUnitRecordList.add(new StudentUnitRecordProxy(
                new Integer(el.getAttributeValue("sid")),
                el.getAttributeValue("uid")));
    }
    if (studentUnitRecordList.size() > 0)
      // be careful - this could be empty
      unitRecordCodes_.put(unitCode, studentUnitRecordList);
    return studentUnitRecordList;
  }

  /**
   * Returns a list of all results for the specified student
   * @param studentID
   * @return
   */
  public StudentUnitRecordList getRecordsByStudent(Integer studentID) {
    StudentUnitRecordList studentUnitRecordList = studentCodes_.get(studentID);
    if (studentUnitRecordList != null) return studentUnitRecordList;
    studentUnitRecordList = new StudentUnitRecordList();
    for (Element el : (List<Element>) XMLManager.getXML().getDocument()
            .getRootElement().getChild("studentUnitRecordTable")
            .getChildren("record"))
      if (studentID.toString().equals(el.getAttributeValue("sid")))
        studentUnitRecordList.add(new StudentUnitRecordProxy(new Integer(
                el.getAttributeValue("sid")), el.getAttributeValue("uid")));
    if (studentUnitRecordList.size() > 0)
      // be careful - this could be empty
      studentCodes_.put(studentID, studentUnitRecordList);
    return studentUnitRecordList;
  }

  /**
   * Saves provided record to XML file for permanent storage,
   * the student and unit must exist for the record to be saved
   * @param StudentUnitRecord - the student unit record to be saved
   */
  public void saveRecord(IStudentUnitRecord StudentUnitRecord) {
    for (Element el : (List<Element>) XMLManager.getXML().getDocument()
            .getRootElement().getChild("studentUnitRecordTable")
            .getChildren("record")) {
      if (StudentUnitRecord.getStudentId().toString().equals(
              el.getAttributeValue("sid"))
              && StudentUnitRecord.getUnitCode().equals(
              el.getAttributeValue("uid"))) {
        el.setAttribute("asg1", new Float(
                StudentUnitRecord.getAssignment1Mark()).toString());
        el.setAttribute("asg2", new Float(
                StudentUnitRecord.getAssignment2Mark()).toString());
        el.setAttribute("exam", new Float(
                StudentUnitRecord.getExamMark()).toString());
        //write out the XML file for continuous save
        XMLManager.getXML().saveDocument();
        return;
      }
    }
    throw new RuntimeException(
            "DBMD: saveRecord : no such student record in data");
  }
}
