package entity;

import impl.InfoImpl;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student implements InfoImpl, Serializable {
    private static int autoId = 10000;
    private int id;
    private String fullName;
    private String adress;
    private int phoneNumber;
    private String grade;

    public int getId() {
        return id;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void inputInfo() {
        this.id = Student.autoId++;

        System.out.println("Mã sinh viên:" + this.getId());
        System.out.println("Nhập họ tên sinh viên:");
        this.setFullName(new Scanner(System.in).nextLine());
        System.out.println("Nhập địa chỉ sinh viên:");
        this.setAdress(new Scanner(System.in).nextLine());
        System.out.println("Nhập số điện thoại sinh viên:");

        do {
            try {
                this.setPhoneNumber(new Scanner(System.in).nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Số điện thoại không được là kí tự nhập lại:");
            }
        } while (true);
        System.out.println("Nhập lớp sinh viên:");
        this.setGrade(new Scanner(System.in).nextLine());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
