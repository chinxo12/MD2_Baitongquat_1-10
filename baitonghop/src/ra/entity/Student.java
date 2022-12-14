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
        System.out.println("Nh???p v??o gi???i t??nh (Male/Female ho???c Nam/N???)");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Nh???p v??o ??i???m thi m??n JavaScript");
        inputMark(scanner,listMarkJavaScript);
        System.out.println("Nh???p v??o ??i???m thi m??n JavaCore");
        inputMark(scanner,listMarkJavaCore);
        System.out.println("Nh???p v??o ??i???m thi m??n JavaWeb");
        inputMark(scanner,listMarkJavaWeb);
        System.out.println("Nh???p v??o tr???ng th??i c???a sinh vi??n (??ang h???c/???? ngh???)");
        inputStudentStatus(scanner);
    }

    public void inputStudentId(List<Student> list) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("Nh???p v??o m?? sinh vi??n ");
            String id = scanner.nextLine();
            if (id.trim().length() == 5) {
                if (id.charAt(0)=='S') {
                    if (list.size()!=0){
                        for (int i = 0; i < list.size() ; i++) {
                            if (!id.equals(list.get(i).studentId)){
                                this.studentId = id;
                                check = false;
                            }else {
                                System.err.println("???? c?? id n??y trong danh s??ch vui l??ng nh???p l???i!!!");
                            }
                        }
                    }else {
                        this.studentId = id;
                        check = false;
                    }
                } else {
                    System.err.println("M?? sinh vi??n b???t ?????u b???ng ch??? 'S'");
                }
            } else {
                System.err.println("M?? sinh vi??n g???m 5 k?? t???:");
            }
        }
    }
    public String inputStudentName (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nh???p v??o t??n sinh vi??n");
        while (true){
            String name = scanner.nextLine();
            if (name.trim().length()<=50 && name.trim().length()>=6){
                this.studentName = name;
                break;
            }else {
                System.err.println("T??n sinh vi??n nhi???u h??n 6 v?? ??t h??n 50 k?? t???!!!");
            }
        }
        return this.studentName;
    }
    public int inputAge (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nh???p v??o tu???i c???a sinh vi??n: ");
        while (true){
            int checkAge = 0;
            try {
                 checkAge = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Vui l??ng nh???p l???i (Nh???p v??o s???)");
            }
            if (checkAge>=18){
                this.age = checkAge;
                break;
            }else {
                System.err.println("Tu???i c???a sinh vi??n ph???i l???n h??n 18");
            }
        }
        return this.age;
    }
    public void inputMark (Scanner scanner, List<Float> listMark){
        int cnt = 1;
        do {
            System.out.printf("Nh???p ??i???m thi l???n %d: \n", cnt);
            checkInputMark(scanner,listMark);
            cnt++;
            System.out.printf("B???n c?? mu???n nh???p ??i???m thi l???n %d kh??ng: \n", cnt);
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("L???a ch???n c???a b???n: ");
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
                System.out.println("Vui l??ng nh???p l???i (Nh???p v??o s???)");

            }
            if (mark>10.0){
                System.err.println("??i???m thi ph???i <=10.0 ! Vui l??ng nh???p l???i!!! ");
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
            if (status.toLowerCase().equals("??ang h???c")) {
                this.studentStatus = true;
               break;
            } else if (status.toLowerCase().equals("???? ngh???")) {
                this.studentStatus = false;
                break;
            } else {
                System.out.println("vui l??ng nh???p l???i");
                System.out.println("Nh???p v??o tr???ng th??i c???a sinh vi??n (??ang h???c/???? ngh???)");
            }
        } while (true);
    }
    public String displayStudentStatus (){
        String displayStudentStatus;
        if (this.studentStatus){
            displayStudentStatus = "??ang h???c";
        }else {
            displayStudentStatus = "???? ngh???";
        }
        return displayStudentStatus;
    }

    @Override
    public void displayData() {
        System.out.printf("M?? sinh vi??n: %-10s T??n sinh vi??n: %-30s Tu???i: %-5d Gi???i t??nh: %-10s L???p: %-10s\n",
                this.studentId, this.studentName, this.age, this.sex, classStudent.getclassName());
        System.out.print("??i???m thi m??n JavaScript: ");
        for (Float js_mark:listMarkJavaScript) {
            System.out.printf("%f\t", js_mark);
        }
        System.out.print("\n");
        System.out.print("??i???m thi m??n Java Core: ");
        for (Float js_mark:listMarkJavaCore) {
            System.out.printf("%f\t", js_mark);
        }
        System.out.print("\n");
        System.out.print("??i???m thi m??n Java Web");
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
           this.gPA = "K??m";
        }else if (this.avgMark<5){
            this.gPA = "Y???u";
        }else if (this.avgMark<6.5){
            this.gPA = "Trung B??nh";
        } else if (this.avgMark < 8.0) {
            this.gPA = "Kh??";
        }else {
            this.gPA = "Gi???i";
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
