package datamanagement;

public class StudentUnitRecordProxy 
  implements IStudentUnitRecord {
	
  private int studentID_;
	private String unitCode_;
	private StudentUnitRecordManager studentUnitRecordManager_;
	
	public StudentUnitRecordProxy( int studentId, String unitCode ) 
	{
		this.studentID_ = studentId;
		this.unitCode_ = unitCode;
		this.studentUnitRecordManager_ = StudentUnitRecordManager.instance();
	}
	
	public Integer getStudentId() { 
		return studentID_;
	}
	
	public String getUnitCode() { 
		return unitCode_; 
	}
	

	public void setAssignment1Mark(float mark) {
		studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).setAssignment1Mark(mark);
	}
	
	public float getAssignment1Mark() {
		return studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).getAssignment1Mark();
	}
	
	public void setAssignment2Mark(float mark) { 
		studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).setAssignment2Mark(mark);
	}
	
	public float getAssignment2Mark() {
		return studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).getAssignment2Mark();
	}
	
	public void setExamMark(float mark) {
		studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).setExamMark(mark);
	}
	
	public float getExamMark() {
		return studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).getExamMark();
	}
	
	public float getTotalMarks() {
		return studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).getTotalMarks();
	}
}