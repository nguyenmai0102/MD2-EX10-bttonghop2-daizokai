package ra.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudentManagement {
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private StudentClass studentClass;
   private List<Float> listMarkJavaScript = new ArrayList<>();
    private List<Float> listMarkJavaCore = new LinkedList<>();
    private List<Float> listMarkJavaWeb = new ArrayList<>();
    private float avgMark;
    private String gpa;
    private boolean studentStatus;


    public Student() {
    }

    public Student(String studentId, String studentName, int age, boolean sex, StudentClass studentClass, List<Float> listMarkJavaScript, List<Float> listMarkJavaCore, List<Float> listMarkJavaWeb, float avgMark, String gpa, boolean studentStatus) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.studentClass = studentClass;
        this.listMarkJavaScript = listMarkJavaScript;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkJavaWeb;
        this.avgMark = avgMark;
        this.gpa = gpa;
        this.studentStatus = studentStatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public List<Float> getListMarkJavaScript() {
        return listMarkJavaScript;
    }

    public void setListMarkJavaScript(List<Float> listMarkJavaScript) {
        this.listMarkJavaScript = listMarkJavaScript;
    }

    public List<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(List<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public List<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(List<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("input class ID");
        do {
            this.studentId = sc.nextLine();
            if (this.studentId.trim().length()==6){
                if (this.studentId.trim().charAt(0) == 's') {

                    break;
                }else {
                    System.out.println("input again start character 's");

                }
            }else {
                System.out.println("input again classID form 6 characters");
            }
        }while (true);
        System.out.println("input class name");
        do {
            this.studentName =sc.nextLine();
            if (this.studentName.trim().length()>=20 && this.studentName.trim().length()<=50){
                break;
            }else {
                System.out.println("input again class name from 20 to 50 characters");
            }
        }while (true);
        System.out.println("input student age");
        do {
            this.age = Integer.parseInt(sc.nextLine());
            if (this.age>=10){
                break;
            }else {
                System.out.println("input student age from 18 ages grow up");
            }

        }while (true);
        System.out.println("input here student sex");
        this.sex = Boolean.parseBoolean(sc.nextLine());
        int cnt =1;
        System.out.println("input the MarkJavaScript: ");
        inputMark((list<Float>) listMarkJavaScript, sc);
        System.out.println("input the MarkJavaCore: ");
       inputMark((list<Float>) listMarkJavaCore, sc);

        System.out.println("input the MarkJavaWeb: ");
       inputMark((list<Float>) listMarkJavaWeb, sc);
        System.out.println(" input status Class: ");
        this.studentStatus = Boolean.parseBoolean(sc.nextLine());
    }
    public static void inputMark(list<Float> listMark, Scanner sc){
        int cnt = 1 ;
        do {

            System.out.printf("input the mark Test the %d: \n", cnt);
            listMark.add(Float.parseFloat(sc.nextLine()));
            cnt++;
            System.out.println("do you want input  mark test the %d:\n");
            System.out.println("1. yes");
            System.out.println("2.no");
            System.out.println("your choice: ");
            int choice =  Integer.parseInt(sc.nextLine());
            if (choice != 1){
                break;
            }
        }while (true);

    }

    @Override
    public void displayData() {
        System.out.printf("class ID:%s - className: %s- class age: %d - class sex: %b - class:%s\n  ", this.studentId, this.studentName, this.age, this.sex, this.studentClass);
        System.out.print("mark JavaScrip" );
        for (Float js_mark: listMarkJavaScript) {
            System.out.printf("%f\t", js_mark);
        }
        System.out.println("\n");
        System.out.print("mark JavaCore" );
        for (Float js_mark: listMarkJavaCore) {
            System.out.printf("%f\t", js_mark);
        }
        System.out.println("\n");
        System.out.print("mark JavaWeb" );
        for (Float js_mark: listMarkJavaWeb) {
            System.out.printf("%f\t", js_mark);
        }
        System.out.println("\n");
        System.out.printf("diem Tb: %f - xep loai: %s - status: %b\n", this.avgMark, this.gpa, this.studentStatus);


    }
     public void calAvgMark() {
         this.avgMark = (listMarkJavaScript.get(listMarkJavaScript.size() - 1)
                 + listMarkJavaCore.get(listMarkJavaCore.size() - 1)
                 + listMarkJavaWeb.get(listMarkJavaWeb.size() - 1)) / 3;
     }
     public void getGPA(){
        if (this.avgMark<5){
            this.gpa = "yeu";

        }else if (this.avgMark<7){
            this.gpa = "trung binh";

        }else if (this.avgMark<9){
            this.gpa = "kha";

        }else {
            this.gpa = "gioi";
        }
     }

}