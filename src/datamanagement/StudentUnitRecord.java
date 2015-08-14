package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
	private Integer studentId_;
	private String unitCode_;
	private float assessment1_, assessment2_, exam_;

	public StudentUnitRecord(Integer id, String code, float asg1, float asg2,
			float exam) {
		this.studentId_ = id;
		this.unitCode_ = code;
		this.setAsg1(asg1);
		this.setAsg2(asg2);
		this.setExam(exam);
	}

	public Integer getStudentID() {
		return studentId_;
	}

	public String getUnitCode() {
		return unitCode_;
	}

	public void setAsg1(float asg1) {
		if (asg1 < 0 ||
			asg1 > UnitManager.UM().getUnit(unitCode_).getAsg1Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assessment1_ = asg1;
	}

	public float getAsg1() {

		return assessment1_;
	}

	public void setAsg2(float asg2) {
		if (asg2 < 0 ||
			asg2 > UnitManager.UM().getUnit(unitCode_).getAsg2Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assessment2_ = asg2;

	}

	public float getAsg2() {
		return assessment2_;
	}

	public void setExam(float exam) {
		if (exam < 0 ||
				exam > UnitManager.UM().getUnit(unitCode_).getExamWeight()) {
				throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
			}
		this.exam_ = exam;
	}

	public float getExam() {
		return exam_;
	}

	public float getTotal() {
		return assessment1_ + assessment2_ + exam_;

	}
}
