package datamanagement;
public class StudentUnitRecordProxy implements IStudentUnitRecord {
private Integer studentID;
private String unitCode;
private StudentUnitRecordManager mngr;
public StudentUnitRecordProxy( Integer id, String code ) 
{
this.studentID = id;this.unitCode = code;
this.mngr = StudentUnitRecordManager.instance();}
public Integer getStudentID() { return studentID;}
public String getUnitCode() { return unitCode; 
}
public void setAssignment1Mark(float mark) {
mngr.getStudentUnitRecord( studentID, unitCode ).setAssignment1Mark(mark);}
public float getAssignment1Mark()
{
return mngr.getStudentUnitRecord( studentID, unitCode ).getAssignment1Mark();}
public void setAssignemnt2Marks(float mark) { mngr.getStudentUnitRecord( studentID, unitCode ).setAssignemnt2Marks(mark);}
public float getAssignment2Mark() {return mngr.getStudentUnitRecord( studentID, unitCode ).getAssignment2Mark();
}
public void setExamMark(float mark) {mngr.getStudentUnitRecord( studentID, unitCode ).setExamMark(mark);
}
public float getExamMark()
{
return mngr.getStudentUnitRecord( studentID, unitCode ).getExamMark();}
public float getTotalMarks() {return mngr.getStudentUnitRecord( studentID, unitCode ).getTotalMarks();}}
