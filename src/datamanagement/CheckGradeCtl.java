package datamanagement;

public class CheckGradeCtl {

	cgUI CGUI;
	String cuc = null;
	Integer currentStudentID = null;
	boolean changed = false;

	public CheckGradeCtl() {
	}

	public void execute() {
		CGUI = new cgUI(this);
		CGUI.setState1(false);

		CGUI.setState2(false);
		CGUI.setState3(false);
		CGUI.setState4(false);
		CGUI.setState5(false);
		CGUI.setState6(false);
		CGUI.Refresh3();

		ListUnitsCTL luCTL = new ListUnitsCTL();
		luCTL.listUnits(CGUI);
		CGUI.setVisible(true);
		CGUI.setState1(true);
	}

	public void unitSelected(String code) {

		if (code.equals("NONE"))
			CGUI.setState2(false);
		else {
			ListStudentsCtl lsCTL = new ListStudentsCtl();
			lsCTL.listStudents(CGUI, code);
			cuc = code;
			CGUI.setState2(true);
		}
		CGUI.setState3(false);
	}

	public void studentSelected(Integer id) {
		currentStudentID = id;
		if (currentStudentID.intValue() == 0) {
			CGUI.Refresh3();
			CGUI.setState3(false);
			CGUI.setState4(false);
			CGUI.setState5(false);
			CGUI.setState6(false);
		}

		else {
			IStudent s = StudentManager.get().getStudent(id);

			IStudentUnitRecord r = s.getUnitRecord(cuc);

			CGUI.setRecord(r);
			CGUI.setState3(true);
			CGUI.setState4(true);
			CGUI.setState5(false);
			CGUI.setState6(false);
			changed = false;

		}
	}

	public String checkGrade(float f, float g, float h) {
		IUnit u = UnitManager.initializeUnitManager().getUnit(cuc);
		String s = u.getGrade(f, g, h);
		CGUI.setState4(true);
		CGUI.setState5(false);
		if (changed) {
			CGUI.setState6(true);
		}
		return s;
	}

	public void enableChangeMarks() {
		CGUI.setState4(false);
		CGUI.setState6(false);
		CGUI.setState5(true);
		changed = true;
	}

	public void saveGrade(float asg1, float asg2, float exam) {

		IUnit u = UnitManager.initializeUnitManager().getUnit(cuc);
		IStudent s = StudentManager.get().getStudent(currentStudentID);

		IStudentUnitRecord r = s.getUnitRecord(cuc);
		r.setAssignment1Mark(asg1);
		r.setAssignment2Mark(asg2);
		r.setExamMark(exam);
		StudentUnitRecordManager.instance().saveRecord(r);
		CGUI.setState4(true);
		CGUI.setState5(false);
		CGUI.setState6(false);
	}
}