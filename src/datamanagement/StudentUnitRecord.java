package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
    private int studentId_;
    private String unitCode_;
    private float assessment1_, assessment2_, exam_;

    public StudentUnitRecord(int studentId, String unitCode, float asg1Mark,
            float asg2Mark, float examMark) {
        this.studentId_ = studentId;
        this.unitCode_ = unitCode;
        this.setAssignment1(asg1Mark);
        this.setAssignment2(asg2Mark);
        this.setExam(examMark);
    }

    public Integer getStudentID() {
        return studentId_;
    }

    public String getUnitCode() {
        return unitCode_;
    }

    public void setAssignment1(float asg1Mark) {
        if (asg1Mark < 0
                || asg1Mark > UnitManager.initializeUnitManager()
                        .getUnit(unitCode_).getAsg1Weight()) {
            throw new RuntimeException(
                    "Mark cannot be less than zero or greater than assessment weight");
        }
        this.assessment1_ = asg1Mark;
    }

    public float getAssignment1() {

        return assessment1_;
    }

    public void setAssignment2(float asg2Mark) {
        if (asg2Mark < 0
                || asg2Mark > UnitManager.initializeUnitManager()
                        .getUnit(unitCode_).getAsg2Weight()) {
            throw new RuntimeException(
                    "Mark cannot be less than zero or greater than assessment weight");
        }
        this.assessment2_ = asg2Mark;

    }

    public float getAssignment2() {
        return assessment2_;
    }

    public void setExam(float examMark) {
        if (examMark < 0
                || examMark > UnitManager.initializeUnitManager()
                        .getUnit(unitCode_).getExamWeight()) {
            throw new RuntimeException(
                    "Mark cannot be less than zero or greater than assessment weight");
        }
        this.exam_ = examMark;
    }

    public float getExam() {
        return exam_;
    }

    public float getTotal() {
        return assessment1_ + assessment2_ + exam_;

    }
}
