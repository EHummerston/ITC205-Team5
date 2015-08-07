package datamanagement;

public class Unit implements IUnit {

    private String unitCode_;
    private String unitName_;
    private float passCutOff_;
    private float creditCutOff_;
    private float distinctionCutOff_;
    private float highDistinctionCutOff_;
    private float additionalExamCutOff_;
    private int assignment1Weight_, assignment2Weight_, examWeight_;

    private StudentUnitRecordList studentUnitRecordList_;

    public Unit(String unitCode, String unitName, float passCutOff, float creditCutOff,
                float distinctionCutOff, float highDistinctionCutOff,
                float additionalExamCutOff, int assignment1Weight,
                int assignment2Weight, int examWeight,
                StudentUnitRecordList studentUnitRecordList) {

        this.unitCode_ = unitCode;
        this.unitName_ = unitName;
        this.passCutOff_ = passCutOff;
        this.creditCutOff_ = creditCutOff;
        this.distinctionCutOff_ = distinctionCutOff;
        this.highDistinctionCutOff_ = highDistinctionCutOff;
        this.additionalExamCutOff_ = additionalExamCutOff;
        this.setAssessmentWeights(assignment1Weight, assignment2Weight, examWeight);
        studentUnitRecordList_ = studentUnitRecordList == null ? new StudentUnitRecordList() : studentUnitRecordList;
    }

    public String getUnitCode() {
        return this.unitCode_;
    }

    public String getUnitName() {
        return this.unitName_;
    }

    public void setPsCutoff1(float cutoff) {
        this.passCutOff_ = cutoff;
    }

    public float getPsCutoff() {
        return this.passCutOff_;
    }

    public void setCrCutoff(float cutoff) {
        this.creditCutOff_ = cutoff;
    }

    public float getCrCutoff() {
        return this.creditCutOff_;
    }

    public void setDiCutoff(float cutoff) {
        this.distinctionCutOff_ = cutoff;
    }

    public float getDiCuttoff() {
        return this.distinctionCutOff_;
    }

    public void HDCutoff(float cutoff) {
        this.highDistinctionCutOff_ = cutoff;
    }

    public void setHdCutoff(float cutoff) {
        this.highDistinctionCutOff_ = cutoff;
    }

    public float getHdCutoff() {
        return this.highDistinctionCutOff_;
    }

    public void setAeCutoff(float cutoff) {
        this.additionalExamCutOff_ = cutoff;
    }

    public float getAeCutoff() {
        return this.additionalExamCutOff_;
    }

    public void addStudentRecord(IStudentUnitRecord record) {
        studentUnitRecordList_.add(record);
    }

    public IStudentUnitRecord getStudentRecord(int studentID) {
        for (IStudentUnitRecord r : studentUnitRecordList_) {
            if (r.getStudentId() == studentID)
                return r;
        }
        return null;
    }

    public StudentUnitRecordList listStudentRecords() {
        return studentUnitRecordList_;
    }

    public int getAsg1Weight() {
        return assignment1Weight_;
    }

    public int getAsg2Weight() {
        return assignment2Weight_;
    }

    public int getExamWeight() {
        return examWeight_;
    }

    public void setAssessmentWeights(int assignment1Weight, int assignment2Weight, int examWeight) {
        if (assignment1Weight < 0 || assignment1Weight > 100 ||
                assignment2Weight < 0 || assignment2Weight > 100 ||
                examWeight < 0 || examWeight > 100) {
            throw new RuntimeException("Assessment weights cant be less than zero or greater than 100");
        }

        if (assignment1Weight + assignment2Weight + examWeight != 100) {
            throw new RuntimeException("Assessment weights must add to 100");
        }

        this.assignment1Weight_ = assignment1Weight;
        this.assignment2Weight_ = assignment2Weight;
        this.examWeight_ = examWeight;
    }

    private void setCutoffs(float ps, float cr, float di, float hd, float ae) {
        if (ps < 0 || ps > 100 ||
            cr < 0 || cr > 100 ||
            di < 0 || di > 100 ||
            hd < 0 || hd > 100 ||
            ae < 0 || ae > 100) {
            throw new RuntimeException("Assessment cutoffs cant be less than zero or greater than 100");
        }

        if (ae >= ps) {
            throw new RuntimeException("AE cutoff must be less than PS cutoff");
        }
        if (ps >= cr) {
            throw new RuntimeException("PS cutoff must be less than CR cutoff");
        }
        if (cr >= di) {
            throw new RuntimeException("CR cutoff must be less than DI cutoff");
        }
        if (di >= hd) {
            throw new RuntimeException("DI cutoff must be less than HD cutoff");
        }

    }

    public String getGrade(float assignment1Mark, float assignment2Mark, float examMark) {
        float totalMark = assignment1Mark + assignment2Mark + examMark;

        if (assignment1Mark < 0 || assignment1Mark > assignment1Weight_ ||
                assignment2Mark < 0 || assignment2Mark > assignment2Weight_ ||
                examMark < 0 || examMark > examWeight_) {
            throw new RuntimeException("marks cannot be less than zero or greater than assessment weights");
        }

        if (totalMark < additionalExamCutOff_) {
            return "FL";
        } else if (totalMark < passCutOff_)
            return "AE";
        else if (totalMark < creditCutOff_)
            return "PS";
        else if (totalMark < distinctionCutOff_)
            return "CR";
        else if (totalMark < highDistinctionCutOff_)
            return "DI";
        else
            return "HD";
    }


}