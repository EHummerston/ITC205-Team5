package datamanagement;

public class Student implements IStudent {
  private Integer studentId_;
  private String studentFirstName_;
  private String studentLastName_;
  private StudentUnitRecordList studentRecordList_;

  /**
   * Initializes a student object with all important data being set.
   * @param studentId The unique ID of the student
   * @param firstName The students first name
   * @param lastName The students second name
   * @param studentRecord the student record associate with the individual student
   */
  public Student(Integer studentId, String firstName, String lastName, StudentUnitRecordList studentRecord) {
    this.studentId_ = studentId;
    this.studentFirstName_ = firstName;
    this.studentLastName_ = lastName;
    this.studentRecordList_ =
            studentRecord == null ? new StudentUnitRecordList() : studentRecord;
  }

  public Integer getID() {
    return this.studentId_;
  }

  public String getFirstName() {
    return studentFirstName_;
  }

  public void setFirstName(String firstName) {
    this.studentFirstName_ = firstName;
  }

  public String getLastName() {
    return studentLastName_;
  }

  public void setLastName(String lastName) {
    this.studentLastName_ = lastName;
  }

  public void addUnitRecord(IStudentUnitRecord record) {
    studentRecordList_.add(record);
  }

  public IStudentUnitRecord getUnitRecord(String unitCode) {
    for (IStudentUnitRecord i : studentRecordList_) {
      if (i.getUnitCode().equals(unitCode)) {
        return i;
      }
    }
    return null;
  }

  public StudentUnitRecordList getUnitRecords() {
    return studentRecordList_;
  }
}
