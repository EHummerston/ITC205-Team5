package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
<<<<<<< HEAD
	private int studentId_;
	private String unitCode_;
	private float assessment1_, assessment2_, exam_;

	public StudentUnitRecord(int studentId, String unitCode, 
	        float assignment1Mark, float assignmentMark2,
			float examMark) {
		this.studentId_ = studentId;
		this.unitCode_ = unitCode;
		this.setAssignment1Mark(assignment1Mark);
		this.setAssignment2Mark(assignmentMark2);
		this.setExamMark(examMark);
	}

	public int getStudentID() {
=======
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
>>>>>>> parent of ee042d1... Fixes for Review 1
		return studentId_;
	}

	public String getUnitCode() {
		return unitCode_;
	}

<<<<<<< HEAD
	public void setAssignment1Mark(float assignment1Mark) {
		if (assignment1Mark < 0 ||
			assignment1Mark > UnitManager.UM().getUnit(unitCode_).getAsg1Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or "
			        + "greater than assessment weight");
		}
		this.assessment1_ = assignment1Mark;
	}

	public float getAssignment1Mark() {
=======
	public void setAsg1(float asg1) {
		if (asg1 < 0 ||
			asg1 > UnitManager.UM().getUnit(unitCode_).getAsg1Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assessment1_ = asg1;
	}

	public float getAsg1() {
>>>>>>> parent of ee042d1... Fixes for Review 1

		return assessment1_;
	}

<<<<<<< HEAD
	public void setAssignment2Mark(float assignment2Mark) {
		if (assignment2Mark < 0 ||
			assignment2Mark > UnitManager.UM().getUnit(unitCode_).getAsg2Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assessment2_ = assignment2Mark;

	}

	public float getAssignment2Mark() {
		return assessment2_;
	}

	public void setExamMark(float examMark) {
		if (examMark < 0 ||
				examMark > UnitManager.UM().getUnit(unitCode_).getExamWeight()) {
				throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
			}
		this.exam_ = examMark;
	}

	public float getExamMark() {
		return exam_;
	}

	public float getTotalMarks() {
=======
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
>>>>>>> parent of ee042d1... Fixes for Review 1
		return assessment1_ + assessment2_ + exam_;

	}
}
