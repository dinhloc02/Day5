package entity;

import impl.InfoImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Subject extends Info {
    public static final String DC = "Đại cương";
    public static final String CSN = "Cơ sở ngành";
    public static final String CN = "Chuyên ngành";
    private static int autoId = 100;
    private int id;
    private String type;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void inputInfo() {
        this.id = autoId++;
        System.out.println("Mã môn học:" + this.getId());
        super.inputInfo();
        System.out.println("Nhập loại môn học");
        System.out.println("1.Đại cương");
        System.out.println("2.Cơ sở ngành");
        System.out.println("3.Chuyên ngành");
        int types = 0;
        do {
            try {
                types = new Scanner(System.in).nextInt();
                if (types > 0 && types < 4) {
                    break;
                }
                System.out.println("Loại môn học phải từ 1 đến 3 nhập lại:");
            } catch (InputMismatchException e) {
                System.out.println("Loại môn học không được là kí tự nhập lại:");
            }
        } while (true);


        switch (types) {
            case 1:
                this.type=Subject.DC;
                break;
            case 2:
                this.type=Subject.CSN;
                break;
            case 3:
                this.type=Subject.CN;
                break;
        }

    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id + super.toString() +
                ", type='" + type + '\'' +
                '}';
    }
}
