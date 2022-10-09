package ra.entity;

import java.util.Scanner;

public class StudentClass implements  IStudentManagement {
    private String classId;
    private String className;
    private String descriptions;
    private int classStatus;

    public StudentClass() {
    }

    public StudentClass(String classId, String className, String descriptions, int classStatus) {
        this.classId = classId;
        this.className = className;
        this.descriptions = descriptions;
        this.classStatus = classStatus;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("input classID");
        do {
            this.classId =sc.nextLine();
            if(this.classId.trim().length()==5){
                if (this.classId.charAt(0)=='j'){
                    break;
                }else {
                    System.out.println("input again clasID start with 'j' characters ");
                }
            }else {
                System.out.println("input again classId with 5 characters");
            }

        }while (true);
        System.out.println("enter here class name");
        do {
            this.className = sc.nextLine();
            if (this.className.trim().length()<=10){
                break;
            }else {
                System.out.println("input here with 10 characters grow up");
            }
        }while (true);
        System.out.println("input  Descriptions class");
        this.descriptions = sc.nextLine();
        System.out.println("input here  ClassStatus");
        this.classStatus = Integer.parseInt(sc.nextLine());


    }

    @Override
    public void displayData() {
        System.out.printf("classId: Id - className: name - discriptions: Dis - status: %d\n", this.classId, this.className, this.descriptions, this.classStatus );

    }
}
