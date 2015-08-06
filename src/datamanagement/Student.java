package datamanagement;

public class Student implements IStudent {
    private Integer studentId_;
    private String studentFirstName_;
    private String studentLastName_;
    private StudentUnitRecordList su;

    public Student(Integer id, String fn, String ln, StudentUnitRecordList su) {
        this.studentId_ = id;
        this.studentFirstName_ = fn;
        this.studentLastName_ = ln;
        this.su =
                su == null ? new StudentUnitRecordList() :
                        su;
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
        su.add(record);
    }

    public IStudentUnitRecord getUnitRecord(String unitCode) {
        for (IStudentUnitRecord r : su)
            if (r.getUnitCode().equals(unitCode))
                return r;

        return null;

    }

    public StudentUnitRecordList getUnitRecords() {
        return su;
    }
}
