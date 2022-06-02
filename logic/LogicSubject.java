package logic;

import entity.Subject;
import main.Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LogicSubject {
    public static void addInfo() {
        System.out.println("Nhập số lượng môn học mới muốn thêm:");
        int quantity = 0;
        do {
            try {
                quantity = new Scanner(System.in).nextInt();
                if (quantity > 0) {
                    break;
                }
                System.out.println("Số môn học muốn thêm phải lớn hơn 0 , nhập lại:");
            } catch (InputMismatchException e) {
                System.out.println("Số môn học phải là số nguyên nhập lại :");
            }
        } while (true);
        for (int i = 0; i < quantity; ++i) {
            Subject subject = new Subject();
            subject.inputInfo();
            saveInfo(subject);
            showInfo();

        }
    }

    public static void saveInfo(Subject subject) {
        for (int i = 0; i < Main.subjects.length; ++i) {
            if (Main.subjects[i] == null) {
                Main.subjects[i] = subject;
                break;
            }
        }
    }

    public static void showInfo() {
            try {
                FileWriter fw = new FileWriter("file/data.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i = 0; i < Main.subjects.length; ++i) {
                    if (Main.subjects[i] == null) {
                        continue;
                    }

                    System.out.println(Main.subjects[i]);
                    bw.write(Main.subjects[i].toString());
                }
                bw.close();
                fw.close();
            }catch (Exception e){
                System.out.println(e);
            }


    }


    public static boolean isempty() {
        for (int i = 0; i < Main.subjects.length; ++i) {
            if (Main.subjects[i] != null) {
                return false;
            }
        }
        return true;
    }
}
