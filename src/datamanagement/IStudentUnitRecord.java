package datamanagement;

public interface IStudentUnitRecord {

    public Integer getStudentID();
    public String getUnitCode();

<<<<<<< HEAD
    public void setAssignment1Mark(float mark);
    public float getAssignment1Mark();

    public void setAssignment2Mark(float mark);
    public float getAssignment2Mark();
=======
    public void setAsg1(float mark);
    public float getAsg1();

    public void setAsg2(float mark);
    public float getAsg2();
>>>>>>> parent of ee042d1... Fixes for Review 1

    public void setExamMark(float mark);
    public float getExamMark();

    public float getTotalMarks();
}
