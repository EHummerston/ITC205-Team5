package datamanagement;

public class UnitProxy implements IUnit {
	private String unitCode_;
	private String unitName_;
	
	UnitManager   unitManager;
	
	public UnitProxy( String unitCode, String unitName ) {
	    this.unitCode_ = unitCode;
	    this.unitName_ = unitName;
	    unitManager = UnitManager.UM(); 
	}
	
    public String getUnitCode() { 
        return this.unitCode_;
    }
       
    public String getUnitName() { 
            return this.unitName_;
    }
    
<<<<<<< HEAD
    public void setPsCutoff(float cutoff) {
        unitManager.getUnit(unitCode_).setPsCutoff(cutoff);
=======
    public void setPsCutoff1(float cutoff) {
        unitManager.getUnit(unitCode_).setPsCutoff1(cutoff);
>>>>>>> parent of ee042d1... Fixes for Review 1
	}
    
	public float getPsCutoff() {
		return unitManager.getUnit(unitCode_).getPsCutoff();
	}
	
	public void setCrCutoff(float cutoff) {
		unitManager.getUnit(unitCode_).setCrCutoff(cutoff);
	}
	
	public float getCrCutoff() {
		return unitManager.getUnit(unitCode_).getCrCutoff();
	}
	
	public void setDiCutoff(float cutoff) {
		unitManager.getUnit(unitCode_).setDiCutoff(cutoff);
	}
	    
	public float getDiCuttoff() {
		return unitManager.getUnit(unitCode_).getDiCuttoff();
	}
	
	public void setHdCutoff(float cutoff) {
	    unitManager.getUnit(unitCode_).setHdCutoff(cutoff);
	}
	
	public float getHdCutoff() {
	    return unitManager.getUnit(unitCode_).getHdCutoff();
	}
	
	public void setAeCutoff(float cutoff) {
		unitManager.getUnit(unitCode_).setAeCutoff(cutoff);
	}
	
	public float getAeCutoff() {
		return unitManager.getUnit(unitCode_).getAeCutoff();
	}
	
<<<<<<< HEAD
	public String getGrade(float assignment1Mark, float assignment2Mark, float examMark) {
		return unitManager.getUnit(unitCode_).getGrade(assignment1Mark, assignment2Mark, examMark);
	}
	
	public void addStudentRecord(IStudentUnitRecord studentUnitRecord) { 
		unitManager.getUnit(unitCode_).addStudentRecord(studentUnitRecord);
	}
	
	public IStudentUnitRecord getStudentRecord(int studentRecord) {
		return unitManager.getUnit(unitCode_).getStudentRecord(studentRecord);
=======
	public String getGrade(float asg1, float asg2, float exam) {
		return unitManager.getUnit(unitCode_).getGrade(asg1, asg2, exam);
	}
	
	public void addStudentRecord(IStudentUnitRecord record) { 
		unitManager.getUnit(unitCode_).addStudentRecord(record);
	}
	
	public IStudentUnitRecord getStudentRecord(int s) {
		return unitManager.getUnit(unitCode_).getStudentRecord(s);
>>>>>>> parent of ee042d1... Fixes for Review 1
	}
	
	public StudentUnitRecordList listStudentRecords() {
	    return unitManager.getUnit(unitCode_).listStudentRecords();
	}
	
	public int getAsg1Weight() {
		return unitManager.getUnit(unitCode_).getAsg1Weight();
	}
	
	public int getAsg2Weight() {
		return unitManager.getUnit(unitCode_).getAsg2Weight();
	}
	
	public int getExamWeight() {
		return unitManager.getUnit(unitCode_).getExamWeight();
	}
	
<<<<<<< HEAD
	public void setAssessmentWeights(int assignment1Weight, int assignment2Weight, int examWeight) {
		unitManager.getUnit(unitCode_).setAssessmentWeights(assignment1Weight, assignment2Weight, examWeight);
=======
	public void setAssessmentWeights(int asg1, int asg2, int exam) {
		unitManager.getUnit(unitCode_).setAssessmentWeights(asg1, asg2, exam);
>>>>>>> parent of ee042d1... Fixes for Review 1
	}

}
