package ra.entity;

import java.util.List;
import java.util.Scanner;

public class StudentClass implements IStudentManagement{
    private String classId;
    private String className;
    private String descriptions;
    private int classStatus;

    public StudentClass() {
    }

    public StudentClass(String classId, String className, String descriptions, int classStatus) {
        classId = classId;
        this.className = className;
        this.descriptions = descriptions;
        this.classStatus = classStatus;
    }

    public String getclassId() {
        return classId;
    }

    public void setclassId(String classId) {
        classId = classId;
    }

    public String getclassName() {
        return className;
    }

    public void setclassName(String className) {
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
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
       inputClassName();
        System.out.println("Thêm Mô tả ");
        this.descriptions = scanner.nextLine();
        inputClassStatus();
    }
    public String displayStatus (){
        String status;
        if (this.classStatus==1){
            status = "Lớp đang học";
        }else if (this.classStatus==2){
            status = "Lớp đã kết thúc";
        }else {
            status = "Lớp đang tạm nghỉ";
        }
        return status;
    }
    @Override
    public void displayData() {
        System.out.printf("%-10s%-15s%-20s%-15s\n",this.classId,this.className,this.descriptions, displayStatus());
    }
    public int inputClassStatus (){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập vào một trong những mục sau");
            System.out.println("1: Lớp đang học");
            System.out.println("2: Lớp đã kết thúc");
            System.out.println("3: Lớp đang tạm nghỉ");
            String number = scanner.nextLine();
            if (number.trim().length()!=0){
                if (number.equals("1") || number.equals("2") || number.equals("3")){
                    this.classStatus = Integer.parseInt(number);
                    break;
                }else {
                    System.err.println("Vui lòng nhập từ 1-3");
                }
            }else {
                System.err.println("Không được để trống!!!");
                System.out.println("Vui lòng nhập lại");
            }
        }while (true);
        return this.classStatus;
    }
    public void inputClassId(List<StudentClass> list){
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check){
            System.out.println("Nhập vào mã lớp học: ");
            String id = scanner.nextLine();
            if (id.trim().length()==5){
                if (id.charAt(0)=='J'){
                    if (list.size()!=0){
                        for (int i = 0; i < list.size(); i++) {
                            if (!id.equals(list.get(i).classId)){
                                this.classId = id;
                                check = false;
                            }else {
                                System.err.println("Đã có ID này trong danh sách!!!");
                            }
                        }
                    }else {
                        this.classId = id;
                        check = false;
                    }
                }else {
                    System.err.println("Mã lớp học bắt đầu bằng chữ J");
                }
            }else {
                System.err.println("Vui lòng nhập lại (Mã lớp học gồm 5 ky tự)");
            }
        }
    }
    public String inputClassName (){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Nhập tên lớp");
            String name = scanner.nextLine();
            if (name.trim().length()<=10){
                this.className = name;
                break;
            }else {
                System.err.println("Tên lớp ít hơn 10 ký tự");
            }
        }
        return this.className;
    }

}
