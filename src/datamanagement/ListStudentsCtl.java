package datamanagement;

public class ListStudentsCtl {
    private StudentManager studentManager;

    public ListStudentsCtl() {
        studentManager = StudentManager.get();
    }

    public void listStudents(IStudentLister studentLister, String unitCode) {
        studentLister.clearStudents();
        StudentMap students = studentManager.getStudentsByUnit(unitCode);
        for (Integer id : students.keySet()) studentLister.addStudent(students.get(id));
    }
}
