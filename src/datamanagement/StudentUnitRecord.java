package datamanagement;

public class StudentUnitRecord 
implements IStudentUnitRecord {

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

	public StudentUnitRecord(Integer studentId, String unitCode, float assignment1Mark
	        , float assignment2Mark, float examMark) {
		this.studentId_ = studentId;
		this.unitCode_ = unitCode;
		this.setAssignment1Mark(assignment1Mark);
		this.setAssignment2Mark(assignment2Mark);
		this.setExamMark(examMark);
	}

	public Integer getStudentId() {
		return studentId_;
	}

	public String getUnitCode() {
		return unitCode_;
	}
	
	public void setAssignment1Mark(float assignment1Mark) {
		if (assignment1Mark < 0 ||
			assignment1Mark > UnitManager.initializeUnitManager()
							.getUnit(unitCode_).getAsg1Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or "
			        + "greater than assessment weight");
		}
		this.assessment1_ = assignment1Mark;
	}
	
	public float getAssignment1Mark() {
        return assessment1_;
    }

	public void setAssignment2Mark(float assignment2Mark) {
		if (assignment2Mark < 0 ||
			assignment2Mark > UnitManager.initializeUnitManager().getUnit(
              unitCode_).getAsg2Weight()) {
			throw new RuntimeException(
              "Mark cannot be less than zero or greater than assessment weight");
		}
		this.assessment2_ = assignment2Mark;
	}

	public float getAssignment2Mark() {
		return assessment2_;
	}

	public void setExamMark(float examMark) {
		if (examMark < 0 ||
				examMark > UnitManager.initializeUnitManager().getUnit(
                unitCode_).getExamWeight()) {
				throw new RuntimeException(
                "Mark cannot be less than zero or greater than assessment weight");
			}
		this.exam_ = examMark;
	}

	public float getExamMark() {
		return exam_;
	}

	public float getTotalMarks() {
		return assessment1_ + assessment2_ + exam_;
	}
}
