package logic;

import entity.LearnSubject;
import entity.Student;
import entity.Subject;
import entity.SubjectScore;
import main.Main;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LogicLearnSubject {
    public static void showInfo() {
        try {
            FileWriter fileWriter = new FileWriter("file/data.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < Main.learnSubjects.length; ++i) {
                if (Main.learnSubjects[i] == null) {
                    continue;
                }
                fileWriter.write(Main.students[i].toString());
                System.out.println(Main.learnSubjects[i]);
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            throw new RuntimeException();
        }


    }

    public static void saveInfo(LearnSubject learnSubject) {
        for (int i = 0; i < Main.learnSubjects.length; ++i) {
            if (Main.learnSubjects[i] == null) {
                Main.learnSubjects[i] = learnSubject;
                break;
            }
        }
    }

    public static Student inputStudent() {
        System.out.println("Nhập mã sinh viên muốn tìm:");
        int idSt = 0;
        Student student = null;
        do {
            do {
                try {
                    idSt = new Scanner(System.in).nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Mã sinh viên không được là kí tự nhập lại:");
                }
            } while (true);
            for (int i = 0; i < Main.students.length; ++i) {
                if (Main.students[i] != null && Main.students[i].getId() == idSt) {
                    student = Main.students[i];
                }
            }
            if (student != null) {
                break;
            }
            System.out.println("Không có mã sinh viên nhập lại:");
        }
        while (true);
        return student;
    }

    public static SubjectScore[] inputSubject() {
        System.out.println("Nhập số lượng môn học :");

        int quantity = 0;
        do {
            try {
                quantity = new Scanner(System.in).nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Mã môn học phải là số nguyên nhập lại");
            }
        } while (true);
        SubjectScore subjectScore[] = new SubjectScore[quantity];
        for (int i = 0; i < quantity; ++i) {
            System.out.println("Nhập mã môn học muốn thêm:");
            int idSj = 0;
            Subject subject = null;

            do {
                do {
                    try {
                        idSj = new Scanner(System.in).nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Mã môn học phải là số nguyên nhập lại");
                    }
                } while (true);
                boolean check = true;
                boolean checks = true;
                for (int j = 0; j < Main.subjects.length; ++j) {
                    for (int k = 0; k < subjectScore.length; ++k) {
                        if (subjectScore[k] != null && subjectScore[k].getSubject().getId() == idSj) {
                            check = false;
                            break;
                        }
                    }
                    if (!check) {
                        break;
                    }

                    if (Main.subjects[j] != null && Main.subjects[j].getId() == idSj) {
                        subject = Main.subjects[i];
                        break;
                    }
                }

                if (subject != null) {
                    break;
                }
                System.out.println("Không có mã môn học hoặc đã có môn học nhập lại :");
            } while (true);
            System.out.println("Nhập điểm của môn học:");
            double scoreSubject = 0;
            do {
                try {
                    scoreSubject = new Scanner(System.in).nextDouble();
                    if (scoreSubject >= 0 && scoreSubject <= 10) {
                        break;
                    }
                    System.out.println("Điểm môn học phải từ 0-10 nhập lại:");
                } catch (InputMismatchException e) {
                    System.out.println("Mã môn học không được là kí tự nhập lại:");
                }
            } while (true);
            SubjectScore subjectScore1 = new SubjectScore(subject, scoreSubject);
            for (int j = 0; j < subjectScore.length; ++j) {
                if (subjectScore[j] == null) {
                    subjectScore[j] = subjectScore1;
                    break;
                }
            }
        }
        return subjectScore;
    }

    public static void addLearnSubject() {
        if (LogicSubject.isempty() || LogicStudent.isempty()) {
            System.out.println("Nhập sinh viên và môn học trước khi cho học");
            return;
        }
        System.out.println("Nhập số lượng sinh viên muốn nhập điểm: ");
        int quantity = 0;
        do {
            try {
                quantity = new Scanner(System.in).nextInt();
                if (quantity > 0) {
                    break;
                }
                System.out.println("Số lượng sinh viên phải lớn hơn 0 nhập lại:");
            } catch (InputMismatchException e) {
                System.out.println("Số lượng sinh viên không được là kí tự nhập lại:");
            }
        } while (true);
        boolean check = false;
        for (int i = 0; i < quantity; ++i) {
            Student student = inputStudent();
            for (int j = 0; j < Main.learnSubjects.length; ++j) {
                if (Main.learnSubjects[j] != null && student.getId() == Main.learnSubjects[j].getStudent().getId()) {
                    check = true;
                    break;
                }
            }
            if (check) {
                System.out.println("Sinh viên đã có trong danh sách bảng điểm.");
                continue;
            }
            SubjectScore[] subjectScore = inputSubject();

            LearnSubject learnSubject = new LearnSubject(student, subjectScore);
            saveInfo(learnSubject);
        }

    }

    public static void sortAlbName() {
        for (int i = 0; i < Main.learnSubjects.length; ++i) {
            if (Main.learnSubjects[i] == null) {
                continue;
            }
            for (int j = i + 1; j < Main.learnSubjects.length; ++j) {
                if (Main.learnSubjects[j] == null) {
                    continue;
                }
                if (Main.learnSubjects[i].getStudent().getFullName().toLowerCase().equals(Main.learnSubjects[j].getStudent().getFullName().toLowerCase())) {
                    LearnSubject temp = Main.learnSubjects[i];
                    Main.learnSubjects[i] = Main.learnSubjects[j];
                    Main.learnSubjects[j] = temp;
                }
            }
        }
        showInfo();
    }

    //    public static void sortAlbTitle() {
//        for (int i = 0; i < Main.learnSubjects.length; ++i) {
//            if (Main.learnSubjects[i] == null) {
//                continue;
//            }
//            for (int j = i + 1; j < Main.learnSubjects.length; ++j) {
//                if (Main.learnSubjects[j] == null) {
//                    continue;
//                }
//                if (Main.learnSubjects[i].getSubjectScores().g.toLowerCase().equals(Main.learnSubjects[j].getStudent().getFullName().toLowerCase())) {
//                    LearnSubject temp = Main.learnSubjects[i];
//                    Main.learnSubjects[i] = Main.learnSubjects[j];
//                    Main.learnSubjects[j] = temp;
//                }
//            }
//        }
//        showInfo();
//    }
    public static void score() {
        for (int i = 0; i < Main.learnSubjects.length; ++i) {
            if (Main.learnSubjects[i] == null) {
                continue;
            }
            System.out.println("Điểm trung bình của sinh viên " + Main.learnSubjects[i].getStudent().getFullName() + " là: " + Main.learnSubjects[i].getTotalUnit());
        }

    }

}


