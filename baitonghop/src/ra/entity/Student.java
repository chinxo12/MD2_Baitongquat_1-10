package ra.entity;

import java.util.*;

public class Student  implements IStudentManagement{
    private String studentId;
    private String studentName;

    private int age;
    private boolean sex;
    private StudentClass classStudent;
    private List<Float> listMarkJavaScript = new ArrayList<>();
    private List<Float> listMarkJavaCore = new LinkedList<>();
    private List<Float> listMarkJavaWeb = new ArrayList<>();
    private float avgMark;
    private String gPA;
    private boolean studentStatus;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, boolean sex, StudentClass classStudent,
                   ArrayList<Float> listMarkJavaScript, ArrayList<Float> listMarkJavaCore,
                   ArrayList<Float> listMarkJavaWeb, float avgMark, String gPA, boolean studentStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.classStudent = classStudent;
        this.listMarkJavaScript = listMarkJavaScript;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkJavaWeb;
        this.avgMark = avgMark;
        this.gPA = gPA;
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

    public StudentClass getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(StudentClass classStudent) {
        this.classStudent = classStudent;
    }

    public List<Float> getListMarkJavaScript() {
        return listMarkJavaScript;
    }

    public List<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public List<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaScript(ArrayList<Float> listMarkJavaScript) {
        this.listMarkJavaScript = listMarkJavaScript;
    }



    public void setListMarkJavaCore(ArrayList<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }



    public void setListMarkJavaWeb(ArrayList<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getgPA() {
        return gPA;
    }

    public void setgPA(String gPA) {
        this.gPA = gPA;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        inputStudentName();
        inputAge();
        System.out.println("Nhập vào giới tính (Male/Female hoặc Nam/Nữ)");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Nhập vào điểm thi môn JavaScript");
        inputMark(scanner,listMarkJavaScript);
        System.out.println("Nhập vào điểm thi môn JavaCore");
        inputMark(scanner,listMarkJavaCore);
        System.out.println("Nhập vào điểm thi môn JavaWeb");
        inputMark(scanner,listMarkJavaWeb);
        System.out.println("Nhập vào trạng thái của sinh viên (Đang học/Đã nghỉ)");
        inputStudentStatus(scanner);
    }

    public void inputStudentId(List<Student> list) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("Nhập vào mã sinh viên ");
            String id = scanner.nextLine();
            if (id.trim().length() == 5) {
                if (id.charAt(0)=='S') {
                    if (list.size()!=0){
                        for (int i = 0; i < list.size() ; i++) {
                            if (!id.equals(list.get(i).studentId)){
                                this.studentId = id;
                                check = false;
                            }else {
                                System.err.println("Đã có id này trong danh sách vui lòng nhập lại!!!");
                            }
                        }
                    }else {
                        this.studentId = id;
                        check = false;
                    }
                } else {
                    System.err.println("Mã sinh viên bắt đầu bằng chữ 'S'");
                }
            } else {
                System.err.println("Mã sinh viên gồm 5 ký tự:");
            }
        }
    }
    public String inputStudentName (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tên sinh viên");
        while (true){
            String name = scanner.nextLine();
            if (name.trim().length()<=50 && name.trim().length()>=6){
                this.studentName = name;
                break;
            }else {
                System.err.println("Tên sinh viên nhiều hơn 6 và ít hơn 50 ký tự!!!");
            }
        }
        return this.studentName;
    }
    public int inputAge (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tuổi của sinh viên: ");
        while (true){
            int checkAge = 0;
            try {
                 checkAge = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Vui lòng nhập lại (Nhập vào số)");
            }
            if (checkAge>=18){
                this.age = checkAge;
                break;
            }else {
                System.err.println("Tuổi của sinh viên phải lớn hơn 18");
            }
        }
        return this.age;
    }
    public void inputMark (Scanner scanner, List<Float> listMark){
        int cnt = 1;
        do {
            System.out.printf("Nhập điểm thi lần %d: \n", cnt);
            checkInputMark(scanner,listMark);
            cnt++;
            System.out.printf("Bạn có muốn nhập điểm thi lần %d không: \n", cnt);
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice != 1) {
                break;
            }
        } while (true);
    }
    public float checkInputMark (Scanner scanner,List<Float> listMark){
        float mark = 0;
        while (true){
            try {
                mark = Float.parseFloat(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Vui lòng nhập lại (Nhập vào số)");

            }
            if (mark>10.0){
                System.err.println("Điểm thi phải <=10.0 ! Vui lòng nhập lại!!! ");
            }else {
                listMark.add(mark);
                break;
            }
        }
        return mark;
    }
    public void inputStudentStatus (Scanner scanner){
        do {
            String status = scanner.nextLine();
            if (status.toLowerCase().equals("đang học")) {
                this.studentStatus = true;
               break;
            } else if (status.toLowerCase().equals("đã nghỉ")) {
                this.studentStatus = false;
                break;
            } else {
                System.out.println("vui lòng nhập lại");
                System.out.println("Nhập vào trạng thái của sinh viên (Đang học/Đã nghỉ)");
            }
        } while (true);
    }
    public String displayStudentStatus (){
        String displayStudentStatus;
        if (this.studentStatus){
            displayStudentStatus = "Đang học";
        }else {
            displayStudentStatus = "Đã nghỉ";
        }
        return displayStudentStatus;
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sinh viên: %-10s Tên sinh viên: %-30s Tuổi: %-5d Giới tính: %-10s Lớp: %-10s\n",
                this.studentId, this.studentName, this.age, this.sex, classStudent.getclassName());
        System.out.print("Điểm thi môn JavaScript: ");
        for (Float js_mark:listMarkJavaScript) {
            System.out.printf("%f\t", js_mark);
        }
        System.out.print("\n");
        System.out.print("Điểm thi môn Java Core: ");
        for (Float js_mark:listMarkJavaCore) {
            System.out.printf("%f\t", js_mark);
        }
        System.out.print("\n");
        System.out.print("Điểm thi môn Java Web");
        for (Float js_mark:listMarkJavaWeb) {
            System.out.printf("%f\t", js_mark);
        }
        System.out.printf("\n");
        System.out.printf("Diem TB: %f - Xep loai: %s - Trang thai: %s\n", this.avgMark, this.gPA, displayStudentStatus());

    }
    public void calAvgMark (){
        this.avgMark  = (listMarkJavaScript.get(listMarkJavaScript.size()-1)
                +listMarkJavaCore.get(listMarkJavaCore.size()-1)
                +listMarkJavaWeb.get(listMarkJavaWeb.size()-1))/3;
    }
    public void getGPA(){
        if (this.avgMark<3){
           this.gPA = "Kém";
        }else if (this.avgMark<5){
            this.gPA = "Yếu";
        }else if (this.avgMark<6.5){
            this.gPA = "Trung Bình";
        } else if (this.avgMark < 8.0) {
            this.gPA = "Khá";
        }else {
            this.gPA = "Giỏi";
        }
    }
    public float getTopMark (List<Float> list){
        list.sort(new Comparator<Float>() {
            @Override
            public int compare(Float o1, Float o2) {
                return (int) (o1 - o2);
            }
        });
        return list.get(list.size()-1);
    }
}
