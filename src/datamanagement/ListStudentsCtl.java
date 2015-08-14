package datamanagement;

public class ListStudentsCtl {
  private StudentManager studentManager_;

  public ListStudentsCtl() {
    studentManager_ = StudentManager.get();
  }

  public void listStudents(IStudentLister studentLister, String unitCode) {
    studentLister.clearStudents();
    StudentMap students = studentManager_.getStudentsByUnit(unitCode);
    for (Integer id : students.keySet()) studentLister.addStudent(students.get(id));
  }
}
