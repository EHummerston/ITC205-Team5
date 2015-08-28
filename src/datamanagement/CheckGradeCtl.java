package datamanagement;

public class CheckGradeCtl
{

  private CheckGradeUi checkGradeUi_;
  private String       currentUnitCode_  = null;
  private Integer      currentStudentId_ = null;
  private boolean      isComputable_     = false;



  public CheckGradeCtl()
  {
  }



  public void execute()
  {
    checkGradeUi_ = new CheckGradeUi(this);
    checkGradeUi_.setState1(false);

    checkGradeUi_.setState2(false);
    checkGradeUi_.setState3(false);
    checkGradeUi_.setState4(false);
    checkGradeUi_.setState5(false);
    checkGradeUi_.setState6(false);
    checkGradeUi_.Refresh3();

    ListUnitsCtl luCTL = new ListUnitsCtl();
    luCTL.listUnits(checkGradeUi_);
    checkGradeUi_.setVisible(true);
    checkGradeUi_.setState1(true);
  }



  public void unitSelected(String code)
  {

    if (code.equals("NONE"))
      checkGradeUi_.setState2(false);
    else {
      ListStudentsCTL lsCTL = new ListStudentsCTL();
      lsCTL.listStudents(checkGradeUi_, code);
      currentUnitCode_ = code;
      checkGradeUi_.setState2(true);
    }
    checkGradeUi_.setState3(false);
  }



  public void studentSelected(Integer id)
  {
    currentStudentId_ = id;
    if (currentStudentId_.intValue() == 0) {
      checkGradeUi_.Refresh3();
      checkGradeUi_.setState3(false);
      checkGradeUi_.setState4(false);
      checkGradeUi_.setState5(false);
      checkGradeUi_.setState6(false);
    }

    else {
      IStudent s = StudentManager.get().getStudent(id);

      IStudentUnitRecord r = s.getUnitRecord(currentUnitCode_);

      checkGradeUi_.setRecord(r);
      checkGradeUi_.setState3(true);
      checkGradeUi_.setState4(true);
      checkGradeUi_.setState5(false);
      checkGradeUi_.setState6(false);
      isComputable_ = false;

    }
  }



  public String checkGrade(float f, float g, float h)
  {
    IUnit u = UnitManager.UM().getUnit(currentUnitCode_);
    String s = u.getGrade(f, g, h);
    checkGradeUi_.setState4(true);
    checkGradeUi_.setState5(false);
    if (isComputable_) {
      checkGradeUi_.setState6(true);
    }
    return s;
  }



  public void enableChangeMarks()
  {
    checkGradeUi_.setState4(false);
    checkGradeUi_.setState6(false);
    checkGradeUi_.setState5(true);
    isComputable_ = true;
  }



  public void saveGrade(float asg1, float asg2, float exam)
  {

    IUnit u = UnitManager.UM().getUnit(currentUnitCode_);
    IStudent s = StudentManager.get().getStudent(currentStudentId_);

    IStudentUnitRecord r = s.getUnitRecord(currentUnitCode_);
    r.setAsg1(asg1);
    r.setAsg2(asg2);
    r.setExam(exam);
    StudentUnitRecordManager.instance().saveRecord(r);
    checkGradeUi_.setState4(true);
    checkGradeUi_.setState5(false);
    checkGradeUi_.setState6(false);
  }
}
