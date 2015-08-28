package datamanagement;

/**
 * Lists students
 * @author jtulip
 * @editor Norb C.T.
 *
 */

public interface IStudentLister {

    void clearStudents();
    void addStudent(IStudent student);
    
}
