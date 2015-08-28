package datamanagement;

public interface IStudent {

    Integer getStudentId();

    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    void addUnitRecord(IStudentUnitRecord studentUnitRecord);
    IStudentUnitRecord getUnitRecord(String unitRecord);

    StudentUnitRecordList getUnitRecords();

}
