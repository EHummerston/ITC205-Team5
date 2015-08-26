package datamanagement;


public class StudentUnitRecordProxy implements IStudentUnitRecord {
<<<<<<< HEAD
	private int studentID_;
	private String unitCode_;
	private StudentUnitRecordManager studentUnitRecordManager_;
	
	public StudentUnitRecordProxy( int studentId, String unitCode ) 
	{
		this.studentID_ = studentId;
		this.unitCode_ = unitCode;
=======
	private Integer studentID_;
	private String unitCode_;
	private StudentUnitRecordManager studentUnitRecordManager_;
	
	public StudentUnitRecordProxy( Integer id, String code ) 
	{
		this.studentID_ = id;
		this.unitCode_ = code;
>>>>>>> parent of ee042d1... Fixes for Review 1
		this.studentUnitRecordManager_ = StudentUnitRecordManager.instance();
	}
	
	public Integer getStudentID() { 
		return studentID_;
	}
	
	public String getUnitCode() { 
		return unitCode_; 
	}
	
<<<<<<< HEAD
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
=======
	public void setAsg1(float mark) {
		studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).setAsg1(mark);
	}
	
	public float getAsg1() {
		return studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).getAsg1();
	}
	
	public void setAsg2(float mark) { 
		studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).setAsg2(mark);
	}
	
	public float getAsg2() {
		return studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).getAsg2();
	}
	
	public void setExam(float mark) {
		studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).setExam(mark);
	}
	
	public float getExam() {
		return studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).getExam();
	}
	
	public float getTotal() {
		return studentUnitRecordManager_.getStudentUnitRecord( studentID_, unitCode_ ).getTotal();
>>>>>>> parent of ee042d1... Fixes for Review 1
	}
}
