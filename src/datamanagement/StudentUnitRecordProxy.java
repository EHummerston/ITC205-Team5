package datamanagement;

public class StudentUnitRecordProxy implements IStudentUnitRecord {

    private int studentID_;
    private String unitCode_;
    private StudentUnitRecordManager studentUnitRecordManager_;

    public StudentUnitRecordProxy(Integer id, String code) {
        this.studentID_ = id;
        this.unitCode_ = code;
        this.studentUnitRecordManager_ = StudentUnitRecordManager.instance();
    }

    public Integer getStudentID() {
        return studentID_;
    }

    public String getUnitCode() {
        return unitCode_;
    }

    public void setAssignment1(float mark) {
        studentUnitRecordManager_.getStudentUnitRecord(studentID_, unitCode_)
                .setAssignment1(mark);
    }

    public float getAssignment1() {
        return studentUnitRecordManager_.getStudentUnitRecord(studentID_,
                unitCode_).getAssignment1();
    }

    public void setAssignment2(float mark) {
        studentUnitRecordManager_.getStudentUnitRecord(studentID_, unitCode_)
                .setAssignment2(mark);
    }

    public float getAssignment2() {
        return studentUnitRecordManager_.getStudentUnitRecord(studentID_,
                unitCode_).getAssignment2();
    }

    public void setExam(float mark) {
        studentUnitRecordManager_.getStudentUnitRecord(studentID_, unitCode_)
                .setExam(mark);
    }

    public float getExam() {
        return studentUnitRecordManager_.getStudentUnitRecord(studentID_,
                unitCode_).getExam();
    }

    public float getTotal() {
        return studentUnitRecordManager_.getStudentUnitRecord(studentID_,
                unitCode_).getTotal();
    }
}
