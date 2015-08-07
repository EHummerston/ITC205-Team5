package datamanagement;

public class ListStudentsCTL {
    private StudentManager studentManager;

    public ListStudentsCTL() {
        studentManager = StudentManager.get();
    }

    public void listStudents(IStudentLister studentLister, String unitCode) {
        studentLister.clearStudents();
        StudentMap students = studentManager.getStudentsByUnit(unitCode);
        for (Integer id : students.keySet()) studentLister.addStudent(students.get(id));
    }
}
