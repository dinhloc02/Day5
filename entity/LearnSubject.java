package entity;

import java.io.Serializable;
import java.util.Arrays;

public class LearnSubject implements Serializable {
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

    public void sortTitle() {
        if (LearnSubject.isNullOrEmptyArray(subjectScores)) {
            return;
        }
        for (int i = 0; i < subjectScores.length - 1; ++i) {
            if (subjectScores[i] == null) {
                continue;
            }
            for (int j = i + 1; j < subjectScores.length; ++j) {
                if (subjectScores[j] == null) {
                    continue;
                }
                if (subjectScores[i].getSubject().getTitle().toLowerCase().compareTo(subjectScores[j].getSubject().getTitle().toLowerCase()) > 0) {
                    SubjectScore temp = subjectScores[i];
                    subjectScores[i] = subjectScores[j];
                    subjectScores[j] = temp;
                }
            }
        }
    }

    public boolean compareId(int id) {
        if (LearnSubject.isNullOrEmptyArray(subjectScores)) {
            return false;
        }
        for (int i = 0; i < subjectScores.length; ++i) {
            if (subjectScores[i] == null) {
                continue;
            }
            if(id==subjectScores[i].getSubject().getId()){
                return true;
            }
        }
        return false;
    }
}

