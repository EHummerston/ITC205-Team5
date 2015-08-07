package datamanagement;

public class StudentProxy implements IStudent {
    private Integer studentId_;
    private String firstName_;
    private String lastName_;
    private StudentManager studentList;


    public StudentProxy(Integer studentId, String firstName, String lastName) {
        this.studentId_ = studentId;
        this.firstName_ = firstName;
        this.lastName_ = lastName;
        this.studentList = StudentManager.get();
    }

    public Integer getID() {
        return studentId_;


    }

    public String getFirstName() {
        return firstName_;
    }

    public String getLastName() {
        return lastName_;
    }

    public void setFirstName(String firstName) {


        studentList.getStudent(studentId_).setFirstName(firstName);
    }

    public void setLastName(String lastName) {


        studentList.getStudent(studentId_).setLastName(lastName);
    }


    public void addUnitRecord(IStudentUnitRecord record) {
        studentList.getStudent(studentId_).addUnitRecord(record);
    }

    public IStudentUnitRecord getUnitRecord(String unitCode) {


        return studentList.getStudent(studentId_).getUnitRecord(unitCode);
    }


    public StudentUnitRecordList getUnitRecords() {
        return studentList.getStudent(studentId_).getUnitRecords();
    }
}
