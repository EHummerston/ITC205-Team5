package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
	private Integer sid;
	private String uc;
	private float a1, a2, ex;

	public StudentUnitRecord(Integer id, String code, float asg1, float asg2,
			float exam) {
		this.sid = id;
		this.uc = code;
		this.setAssignment1Mark(asg1);
		this.setAssignment2Mark(asg2);
		this.setExamMark(exam);
	}

	public Integer getStudentId() {
		return sid;
	}

	public String getUnitCode() {
		return uc;
	}

	public void setAssignment1Mark(float a1) {
		if (a1 < 0 ||
			a1 > UnitManager.createUnitManager().getUnit(uc).getAsg1Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.a1 = a1;
	}

	public float getAssignment1Mark() {

		return a1;
	}

	public void setAssignment2Mark(float a2) {
		if (a2 < 0 ||
			a2 > UnitManager.createUnitManager().getUnit(uc).getAsg2Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.a2 = a2;

	}

	public float getAssignment2Mark() {
		return a2;
	}

	public void setExamMark(float ex) {
		if (ex < 0 ||
				ex > UnitManager.createUnitManager().getUnit(uc).getExamWeight()) {
				throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
			}
		this.ex = ex;
	}

	public float getExamMark() {
		return ex;
	}

	public float getTotalMarks() {
		return a1 + a2 + ex;

	}
}
