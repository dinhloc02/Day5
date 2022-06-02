package main;

import entity.LearnSubject;
import entity.Student;
import entity.Subject;

public class Main {
    public static Subject[] subjects = new Subject[100];
    public static Student[] students = new Student[100];
    public static LearnSubject[] learnSubjects = new LearnSubject[100];

    public static void main(String[] args) {
        MainLogic.menu();
    }
}
