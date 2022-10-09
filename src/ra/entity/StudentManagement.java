package ra.entity;

import com.sun.org.apache.xpath.internal.objects.XString;
import ra.entity.StudentClass;

import java.util.*;

import java.util.List;

import ra.entity.Student;

public class StudentManagement {

    static List<StudentClass> listClass = new ArrayList<>();
    static List<Student> listStudent = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean checkout = true;
        do {
            System.out.println("*************** QUẢN LÝ HỌC VIÊN********************");
            System.out.println("1. quản lý lớp học");
            System.out.println("2: quản lý học sinh");
            System.out.println("3: thhoát");
            System.out.println("lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.getClassManagement(scanner);
                    break;
                case 2:
                    StudentManagement.getStudentManagement(scanner);
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                default:
                    System.err.println("chose from 1 to 3");
            }
        } while (true);
    }

    public static void getClassManagement(Scanner sc) {

        boolean checkout = true;
        do {
            System.out.println("***************QUẢN LÝ LỚP HỌC***************");
            System.out.println("1: Thêm mới lớp học");
            System.out.println("2: Cặp nhập thông tin lớp học");
            System.out.println("3: hiển thị thông tin lớp học");
            System.out.println("4: thống kê các lớp học đang hoạt đôộng");
            System.out.println("5: tìm kiếm lớp học theo tên lớp học");
            System.out.println("6: thoát");
            System.out.println("lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
//                    StudentManagement.addNewStudent(sc);

                    break;
                case 2:
                    StudentManagement.updateClass();
                    break;
                case 3:
                    break;
                case 4:
                    StudentManagement.showClassOn();
                    break;
                case 5:
                    StudentManagement.searchClass();
                case 6:
                    checkout = false;
                    break;
                default:
                    System.out.println("input from 1 to 4");

            }
        } while (checkout);

    }

    public static void getStudentManagement(Scanner sc) {

        boolean StudentExit = true;
        do {
            System.out.println("------------------QUẢN LÝ SINH VIÊN----------------");
            System.out.println("1: Thêm mới sinh viên");
            System.out.println("2: Cap nhập thông tin sinh viên");
            System.out.println("3: hien thi thong tin sv ");
            System.out.println("4: tính điểm trung bình ");
            System.out.println("5:xếp loại sinh viên");
            System.out.println("6:sắp xếp sinh viên theo điêmt tb tăng dần");
            System.out.println("7: tìm kiêếm sinh viên theo tên");
            System.out.println("8: thống kê sinh viên theo nấc giỏi, khá, tb, yếu");
            System.out.println("9: thống kê sinh viên qua môn học");
            System.out.println("10: thoát");
            System.out.println(" lựa chọn của bank");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
//                    StudentManagement.addNewClass(sc);

                    break;

                case 2:
//                    StudentManagement.updateStudentList();
                    break;

                case 3:
                    StudentManagement.showListStudent();
                    break;

                case 4:
                    StudentManagement.avgMarkStudent();
                    break;

                case 5:
                    StudentManagement.gpaStudent();
                    break;

                case 6:
                    StudentManagement.sortAvgStudent();
                    break;

                case 7:

                    StudentManagement.searchStudent();
                    break;

                case 8:
                    StudentManagement.sortListGpa();
                    break;
                case 9:
                    StudentManagement.showListPass();
                    break;
                case 10:
                    StudentExit = false;
                    break;
                default:
                    System.out.println("chose from 1 to 10");

            }
        } while (StudentExit);


    }

    //----------------------quản lý lớp học--------------------------------
    //--1---------them moi lop hoc---------------
    public static void addNewClass(Scanner sc) {

        System.out.println("nhập số lượng lớp muốn thêm mới");
        int danhMuc = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < danhMuc; i++) {
            System.out.printf(" lớp học thứ %d\n " + (i + 1));
            StudentClass studentClass = new StudentClass();
            studentClass.inputData(sc);
            listClass.add(studentClass);


        }
    }
//-------2------------- cập nhập thông tin lớp học----------------------

    public static void updateClass() {
        System.out.println("nhap lop hoc muon them thong tin");
        String inputClass = sc.nextLine();
        for (StudentClass class1 : listClass) {
            if (class1.getClassId().equals(inputClass)) {
                System.out.println("nhập tên lớp");
                String className = sc.nextLine();
                boolean chekout = true;
                while (chekout) {
                    for (StudentClass class1class : StudentManagement.listClass) {
                        if (class1class.getClassName().equals(className.trim()) || className.trim().length() == 0 || className.trim().length() > 10) {
                            System.out.println("do dai ten <10 va khong dduowjc trung hoawc trong, nhap lai");
                            className = sc.nextLine();
                            break;
                        } else {
                            chekout = false;
                        }
                    }
                }
                class1.setClassName(className);
                System.out.print("moo ta:");
                class1.setDescriptions(sc.nextLine());
                System.out.println("trang thai lop");
                System.out.println("1: sap bat dau");
                System.out.println("2: hoat dong");
                System.out.println("3: tam dung");
                int newClassStatus = 0;
                while (newClassStatus < 1 || newClassStatus > 3) {
                    try {
                        System.out.println("vui long chon trong khoang 1-3:");
                        newClassStatus = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println(" sai định dạng, hay nhập lại");

                    }
                }
                class1.setClassStatus(newClassStatus);
            }
        }
    }

    //-------------------------hien thi thong tin lop hoc-------------------
    public static void displayClassShow() {


    }

    //---------------- thống kê lớp hcj đang hoạt động------------------
    public static void showClassOn() {
        int count = 0;
        for (StudentClass aClass : listClass
        ) {
            if (aClass.getClassStatus() == 2) {
                aClass.displayData();
                count++;
            }
        }
        System.out.printf("co %d lop dang hoat dong. \n", count);
    }

    ///---------------- tim kiem lop hoc theo ten--------------------
    public static void searchClass() {
        System.out.println("nhap ten class can tim: ");
        String inputName = sc.nextLine();
        for (StudentClass aClass : listClass) {
            if (aClass.getClassName().equals(inputName)) {

            } else {
                System.out.printf(" khong ton tai lop hoc %s\n", inputName);
            }

        }
    }

    // -------1-----------thêm mới sinh viên-----------------------
    public void addNewStudent(Scanner sc) {
        System.out.println("nhap so sv can nhap thong tin");
        int cnt = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cnt; i++) {
            // nhap thong tin  sv
            Student studentNew = new Student();
            studentNew.inputData(sc);
            // nhap thong tin lop sinh vien;
            System.out.println("chon lop hoc cho sinh vien");
            int index = 1;
            for (StudentClass stClass : listClass) {
                System.out.printf("%d.%s\n", index, stClass.getClassName());
                index++;
            }
            System.out.println("su lua chon cua ban");
            int choice = Integer.parseInt(sc.nextLine());
            // gan thuocc tinh StudentClass cua doi tuong studentnew;
            studentNew.setStudentClass(listClass.get(choice - 1));
            // add vao listClass;
            listStudent.add(studentNew);

        }
    }
    //---------2---------------chinh sua thong tin sinh vien--------------------
    public static void UpdateStudentList() {
        if (listStudent.size() == 0) {
            System.out.println("danh sach sv trong, hay them moi trc khi chinh sua");
        }
        System.out.print("nhap id de cap nhap thong tin");
        String inputIdStudent = sc.nextLine();
        for (Student student : listStudent) {
            if (student.getStudentId().equals(inputIdStudent)) {
//                System.out.print("nhap tuoi sinh vien");
//                this.age = Integer.parseInt(sc.nextLine());
//                System.out.print("nhap gioi tinh sinh vien");
//                this.sex = Boolean.parseBoolean(sc.nextLine());

            }

        }
    }
    //---3------------hien thi thong tin sv-----------------------
    public static void showListStudent() {
        for (Student student : listStudent) {
            student.displayData();
        }
    }

    //4///////////////tinh diem trung binh-------------------------
    public static void avgMarkStudent() {
        for (Student student : listStudent
        ) {
            student.calAvgMark();

        }
    }

    //-------------5---------xep loai sinh vien/--------------
    public static void gpaStudent() {
        for (Student student : listStudent) {
            student.getGpa();
        }
    }
    //-------------6-----------sawp xep sv theo diem trung binh tang dan-------
    public static void sortAvgStudent(){
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAvgMark() == o2.getAvgMark()) {
                    return 1;
                }else if (o1.getAvgMark() == o2.getAvgMark()) {
                    return 0;
                }else {
                    return -1;
                }
            }
        });
    }

    //--------7-----tim kiem sinh vien-------------------
    public static void searchStudent() {
        System.out.println("nhap ten sinh vien muon tim kiem");
        String searchName = sc.nextLine();
        for (Student student : listStudent) {
            if (student.getStudentName().contains(searchName)) {
                student.displayData();
            }
        }
    }

    //-8-------------thong ke sinh vien theo nac gioi, kha trung binh---------
    public static void sortListGpa() {
        int count_weak = 0;
        int count_medium = 0;
        int count_pretty = 0;
        int count_good = 0;

        for (Student student : listStudent) {
            if (student.getGpa().equals("yeu.")) {
                count_weak++;
            } else if (student.getGpa().equals("trung binh")) {
                count_medium++;
            } else if (student.getGpa().equals("kha")) {
                count_pretty++;
            } else if (student.getGpa().equals("gioi")) {
                count_good++;
            }
        }
        System.out.printf("hoc luc gioi co:" + count_good + "sv", "hoc luc kha co " + count_pretty + "sv", "hoc luc trung binh co" + count_medium + "sv", "hoc luc yeu co" + count_weak + "sv");
    }

    //----------9---------- thong ke sinh vien qua mon hoc---------------
    public static void showListPass() {
        int count = 0;
        for (Student student : listStudent
        ) {
            if (student.getAvgMark() > 5) {
                student.displayData();
                count++;
            }
        }
    }
}

