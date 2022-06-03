package main;

import logic.LogicLearnSubject;
import logic.LogicStudent;
import logic.LogicSubject;


import java.util.InputMismatchException;
import java.util.Scanner;

public class MainLogic {
    public static void menu() {
        System.out.println("--------------QUẢN LÝ ĐIỂM SINH VIÊN--------------");
        System.out.println("1. Nhập danh sách sinh viên mới trong trường");
        System.out.println("2. In ra danh sách sinh viên trong trường");
        System.out.println("3. Nhập danh sách môn học mới trong trường");
        System.out.println("4. In ra danh sách môn học trong trường");
        System.out.println("5. Quản lý điểm sinh viên và in ra điểm sinh viên");
        System.out.println("6. Sắp xếp danh sách giảng dạy theo tên sinh viên");
        System.out.println("7. Sắp xếp danh sách giảng dạy theo tên môn học");
        System.out.println("8. Tính điểm tổng kết cho mỗi sinh viên");
        System.out.println("9. Thoát");
        System.out.println("----------------------------------------------");

        boolean check = true;
        int choice = 0;
        do {
            System.out.println("Nhập chức năng:");
            do {
                try {
                    choice = new Scanner(System.in).nextInt();
                    if (choice >= 0 && choice <= 9) {
                        break;
                    }
                    System.out.println("Chức năng phải là từ 1 đến 9 nhập lại:");
                } catch (InputMismatchException e) {
                    System.out.println("Mã môn học không được là kí tự nhập lại:");
                }
            } while (true);
            switch (choice) {
                case 1:
                    LogicStudent.addInfo();
                    break;
                case 2:
                    LogicStudent.showInfo();
                    break;
                case 3:
                    LogicSubject.addInfo();
                    break;
                case 4:
                    LogicSubject.showInfo();
                    break;
                case 5:
                    LogicLearnSubject.addLearnSubject();
                    LogicLearnSubject.showInfo();
                    break;
                case 6:
                    LogicLearnSubject.sortAlbName();
                    break;
                case 7:
                    LogicLearnSubject.sortAlbTitle();
                    LogicLearnSubject.showInfo();
                    break;
                case 8:
                    LogicLearnSubject.score();
                    break;
                case 9:
                    check = false;
            }
        } while (check);
    }
}
