package datamanagement;

public class UnitProxy 
implements IUnit {
	private String unitCode_;
	private String unitName_;
	
	UnitManager   unitManager;
	
	public UnitProxy( String unitCode, String unitName ) {
	    this.unitCode_ = unitCode;
	    this.unitName_ = unitName;
	    unitManager = UnitManager.initializeUnitManager();
	}
	
    public String getUnitCode() { 
        return this.unitCode_;
    }
       
    public String getUnitName() { 
            return this.unitName_;
    }
    
    public void setPassCutoff(float cutoff) {
        um.getUnit(UC).setPassCutoff(cutoff);
}
public float getPassCutoff() {
        return um.getUnit(UC).getPassCutoff();}
    public void setCreditCutoff(float cutoff) {um.getUnit(UC).setCreditCutoff(cutoff);
    }
    public float getCreditCutoff() {
return um.getUnit(UC).getCreditCutoff();
    }

public void setDistinctionCutoff(float cutoff) {um.getUnit(UC).setDistinctionCutoff(cutoff);}
    public float getDistinctionCuttoff() {return um.getUnit(UC).getDistinctionCuttoff();}
public void setHightDistinctionCutoff(float cutoff) {
    um.getUnit(UC).setHightDistinctionCutoff(cutoff);}
    public float getHightDistinctionCutoff() {
	public String getGrade(
					float assignment1Mark, float assignment2Mark, float examMark) {
		return unitManager.getUnit(unitCode_).getGrade(
						assignment1Mark, assignment2Mark, examMark);
	}
	
	public void addStudentRecord(IStudentUnitRecord studentUnitRecord) { 
		unitManager.getUnit(unitCode_).addStudentRecord(studentUnitRecord);
	}
	
	public IStudentUnitRecord getStudentRecord(int studentRecord) {
		return unitManager.getUnit(unitCode_).getStudentRecord(studentRecord);
	}
	
	public StudentUnitRecordList listStudentRecords() {
	    return unitManager.getUnit(unitCode_).listStudentRecords();
	}
	
	
	public void setAssessmentWeights(
					int assignment1Weight, int assignment2Weight, int examWeight) {
		unitManager.getUnit(unitCode_).setAssessmentWeights(
						assignment1Weight, assignment2Weight, examWeight);
	}

}
public int getAssignment1Weight() {
	return um.getUnit(UC).getAssignment1Weight();
}
public int getAssigment2Weight() {
	return um.getUnit(UC).getAssigment2Weight();
}
public int getExamWeight() {
	return um.getUnit(UC).getExamWeight();
}
public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt) {
	um.getUnit(UC).setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);
	
}}
