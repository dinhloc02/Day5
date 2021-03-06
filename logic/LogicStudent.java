package logic;

import entity.Student;
import main.Main;
import util.FileUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LogicStudent {
    public static void addInfo() {
        System.out.println("Nhập số lượng sinh viên mới muốn thêm:");
        int quantity = 0;
        do {
            try {
                quantity = new Scanner(System.in).nextInt();
                if (quantity > 0) {
                    break;
                }
                System.out.println("Số sinh viên muốn thêm phải lớn hơn 0 , nhập lại:");
            } catch (InputMismatchException e) {
                System.out.println("Số sinh viên phải là số nguyên nhập lại :");
            }
        } while (true);

        for (int i = 0; i < quantity; ++i) {
            Student student = new Student();
            student.inputInfo();
            saveInfo(student);
            FileUtil.writeDataToFile(Main.students, "data.txt");
            showInfo();
        }

    }

    public static void saveInfo(Student student) {
        for (int i = 0; i < Main.students.length; ++i) {
            if (Main.students[i] == null) {
                Main.students[i] = student;
                break;
            }
        }
    }

    public static void showInfo() {
        for (int i = 0; i < Main.students.length; ++i) {
            if (Main.students[i] == null) {
                continue;
            }
            System.out.println(Main.students[i]);

        }

    }

    public static boolean isempty() {
        for (int i = 0; i < Main.students.length; ++i) {
            if (Main.students[i] != null) {
                return false;
            }
        }
        return true;
    }
}
