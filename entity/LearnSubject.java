package entity;

import java.util.Arrays;

public class LearnSubject {
    private Student student;
    private SubjectScore[] subjectScores;

    public LearnSubject(Student student, SubjectScore[] subjectScores) {
        this.student = student;
        this.subjectScores = subjectScores;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SubjectScore[] getSubjectScores() {
        return subjectScores;
    }

    public void setSubjectScores(SubjectScore[] subjectScores) {
        this.subjectScores = subjectScores;
    }


    @Override
    public String toString() {
        return "LearnSubject{" +
                "student=" + student +
                ", subjectScores=" + Arrays.toString(subjectScores) +
                '}';
    }


    public double getTotalUnit() {
        if (LearnSubject.isNullOrEmptyArray(subjectScores)) {
            return 0;
        }
        int medium = 0;
        double sum = 0;
        for (int i = 0; i < subjectScores.length; ++i) {
            int unit = subjectScores[i].getSubject().getUnit();
            sum += subjectScores[i].getScore() * unit;
            medium += unit;
        }
        sum = (double) sum / medium;
        return sum;
    }


    public static boolean isNullOrEmptyArray(Object[] obj) {
        return obj == null && obj.length == 0;
    }
}

