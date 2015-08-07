package datamanagement;

public interface IStudentUnitRecord {

    Integer getStudentId();
    String getUnitCode();

    void setAssignment1Mark(float mark);
    float getAssignment1Mark();

    void setAssignment2Mark(float mark);
    float getAssignment2Mark();

    void setExamMark(float mark);
    float getExamMark();

    float getTotalMarks();
}
