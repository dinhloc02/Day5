package entity;

import impl.InfoImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Info implements InfoImpl {

    private String title;
    private int unit;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void inputInfo() {
        System.out.println("Nhập tên môn học:");
        this.setTitle(new Scanner(System.in).nextLine());
        System.out.println("Nhập số đơn vị học trình");
        do {
            try {
                this.setUnit(new Scanner(System.in).nextInt());

                if (this.getUnit() > 0) {
                    break;
                }
                System.out.println("Đơn vị học trình không được nhỏ hơn 0 nhập lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Đơn vị học trình không được là kí tự dạng nhập lại:");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "title='" + title + '\'' +
                ", unit=" + unit +
                '}';
    }
}
