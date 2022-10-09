package ra.run;
import ra.entity.IStudentManagement;
import ra.entity.Student;
import ra.entity.StudentClass;
import java.util.*;
public class StudentManagement {
    static List<StudentClass> listClass = new ArrayList<>();
    static List<Student> listStudent = new ArrayList<>();
    public static void main(String[] args) {
        do {
            System.out.println("**********************QUẢN LÝ HỌC VIỆN*******************");
            System.out.println("1: Quản lý lớp");
            System.out.println("2: Quản lý học viên");
            System.out.println("3. Thoát");
            System.out.println("Nhập vào lựa chọn của bạn!");
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.err.println("Vui lòng nhập số!!");
            }
            switch (choice){
                case 1:
                    StudentManagement.classMenu(scanner);
                    break;
                case 2:
                    StudentManagement.studentMenu(scanner);
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Vui lòng lựa chọn từ 1-3");
            }
        }while (true);
    }
    public static void classMenu (Scanner scanner){
        boolean runClassMenu = true;
        do {
            System.out.println("**********************QUẢN LÝ LỚP HỌC********************");
            System.out.println("1. Thêm mới lớp học");
            System.out.println("2. Cập nhật thông tin lớp học");
            System.out.println("3. Hiển thị thông tin lớp học");
            System.out.println("4. Thống kê các lớp học đang hoạt động");
            System.out.println("5. Tìm kiếm lớp học theo tên lớp học");
            System.out.println("6. Thoát");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.err.println("Vui lòng nhập số!!");
            }
            switch (choice){
                case 1:
                    inputClass(scanner);
                    break;
                case 2:
                    updateClass(scanner);
                    break;
                case 3:
                    displayClass();
                    break;
                case 4:
                    statisticByStatus();
                    break;
                case 5:
                    seachClassByName(scanner);
                    break;
                case 6:
                    runClassMenu = false;
                default:
            }
        }while (runClassMenu);
    }
    public static void studentMenu (Scanner scanner){
        boolean runStudentMenu = true;
        do {
            System.out.println("***********************QUẢN LÝ SINH VIÊN******************");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Cập nhật thông tin sinh viên");
            System.out.println("3. Hiển thị thông tin sinh viên");
            System.out.println("4. Tính điểm trung bình");
            System.out.println("5. Xếp loại sinh viên");
            System.out.println("6. Sắp xếp sinh viên theo thứ tự điểm trung bình tăng dần");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê số sinh viên đạt loại giỏi, khá, trung bình và yếu");
            System.out.println("9. Thống kê các sinh viên Pass qua các môn học");
            System.out.println("10. Thoát");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.err.println("Vui lòng nhập số!!");
            }
            switch (choice){
                case 1:
                    StudentManagement.inputStudents(scanner);
                    break;
                case 2:
                    StudentManagement.updateStudent(scanner);
                    break;
                case 3:
                    StudentManagement.displayStudents();
                    break;
                case 4:
                    StudentManagement.calAverageScore();
                    break;
                case 5:
                    StudentManagement.ratingStudents();
                    break;
                case 6:
                    StudentManagement.softStudentsByMark();
                    break;
                case 7:
                    StudentManagement.seachStudentsByName(scanner);
                    break;
                case 8:
                    StudentManagement.statisticsByPerformance();
                    break;
                case 9:
                    StudentManagement.statisticsOfPassStudents();
                    break;
                case 10:
                    runStudentMenu = false;
                default:
            }
        }while (runStudentMenu);
    }
    public static void inputClass (Scanner scanner){
        System.out.println("Nhập vào số lượng lớp muốn thêm");
        int number = 0 ;
        try {
            number = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.err.println("Vui lòng nhập số!!");
        }
        for (int i = 0; i < number; i++) {
            StudentClass studentClass = new StudentClass();
            System.out.println("Nhập vào lớp thứ " + (i+1));
            studentClass.inputClassId(listClass);
            studentClass.inputData();
            listClass.add(studentClass);
        }
    }
    public static void displayClass (){
        System.out.printf("%-10s%-15s%-20s%-15s\n","Mã lớp học","Tên lớp học","Mô tả", "Trạng thái");
        for (int i = 0; i < listClass.size(); i++) {
            listClass.get(i).displayData();
        }
    }
    public static void updateClass (Scanner scanner){

        int indexData =-1;
        boolean check = true;
        System.out.println("Nhập vào mã lớp học cần cập nhật thông tin");
        System.out.println("Vui lòng chọn mã lớp học trong danh sách sau:");
        System.out.println(" STT   Mã lớp học");
        for (int j = 0; j < listClass.size(); j++) {
            System.out.printf("%-5d%-15s\n", (j + 1), listClass.get(j).getclassId());
        }
        while (check) {
            try {
                indexData = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập vào số !!! ");
            }
            if (indexData<=listClass.size()){
                check = false;
            }else {
                System.err.println("Vui lòng nhập lại");
            }
        }
        if (indexData!=-1){
            System.out.println("Nhập tên lớp học mới! Tên cũ: " + listClass.get(indexData-1).getclassName());
            listClass.get(indexData-1).setclassName(listClass.get(indexData-1).inputClassName());
            System.out.println("Nhập mô tả mới cho lớp học! Mô tả cũ " + listClass.get(indexData-1).getDescriptions());
            listClass.get(indexData-1).setDescriptions(StudentManagement.inputUpdateString(scanner));
            System.out.println("Cập nhật trạng thái mới! Trạng thái cũ: " + listClass.get(indexData-1).displayStatus());
            listClass.get(indexData-1).setClassStatus(listClass.get(indexData-1).inputClassStatus());
        }

//
//        StudentManagement.getDataforUpdate(scanner);
//
//        System.out.println("Nhập tên lớp học mới! Tên cũ: " + listClass.get(StudentManagement.getDataforUpdate(scanner)).getclassName());
//        listClass.get(StudentManagement.getDataforUpdate(scanner)).setclassName(inputUpdateString(scanner));
//        System.out.println("Nhập vào mô tả lớp mới! Tên cũ: " + listClass.get(StudentManagement.getDataforUpdate(scanner)).getDescriptions());
//        listClass.get(StudentManagement.getDataforUpdate(scanner)).setDescriptions(inputUpdateString(scanner));
//        System.out.println("Nhập vào trạng thái lớp mới! Trạng thái cũ" + listClass.get(StudentManagement.getDataforUpdate(scanner)).displayStatus());
//        listClass.get(StudentManagement.getDataforUpdate(scanner)).setClassStatus(listClass.get(StudentManagement.getDataforUpdate(scanner)).inputClassStatus());
    }
    public static String inputUpdateString (Scanner scanner){
        String check;
        while (true){
             check = scanner.nextLine();
            if (check.trim().length()!=0){
                break;
            }else {
                System.err.println("Không được để trống!!!");
            }
        }
        return check;
    }
    public static int getDataforUpdate (Scanner scanner){
        int indexData =-1;
        boolean check = true;
        System.out.println("Nhập vào mã lớp học cần cập nhật thông tin");
        while (check) {
            System.out.println("Vui lòng chọn mã lớp học trong danh sách sau:");
            System.out.println(" STT   Mã lớp học");
            for (int j = 0; j < listClass.size(); j++) {
                System.out.printf("%-5d%-15s\n", (j + 1), listClass.get(j).getclassId());
            }
            try {
                indexData = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập vào số !!! ");
            }
            if (indexData<listClass.size()){
                check = false;
            }else {
                System.err.println("Vui lòng nhập lại");
            }
        }
        return indexData-1;
    }
    public static void statisticByStatus(){
        int cnt = 0;
        System.out.printf("%-10s%-15s%-20s%-15s\n","Mã lớp học","Tên lớp học","Mô tả", "Trạng thái");
        for (int i = 0; i < listClass.size(); i++) {
            if (listClass.get(i).getClassStatus()==1){
                listClass.get(i).displayData();
                cnt++;
            }
        }
        System.out.println("Hiện tại có " + cnt + " lớp đang hoạt động!");
    }
    public static void seachClassByName (Scanner scanner){
        while (true){
            System.out.println("Nhập vào tên lớp cần tìm kiếm!");
            String name = scanner.nextLine();
            if (name.trim().length()!=0){
                System.out.printf("%-10s%-15s%-20s%-15s\n","Mã lớp học","Tên lớp học","Mô tả", "Trạng thái");
                for (int i = 0; i < listClass.size(); i++) {
                    if (name.toLowerCase().equals(listClass.get(i).getclassName())){
                        listClass.get(i).displayData();
                    }else {
                        System.err.println("Không có tên này trong danh sách! Vui lòng nhập lại!");
                    }
                }
            }else {
                System.err.println("Không được để trống!!!");
            }
        }
    }
    //-------------------------------------STUDENT------------------------------------------
    public static void inputStudents (Scanner scanner){
        System.out.println("Nhập vào số lượng học viên muốn thêm!");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            Student student = new Student();
            System.out.println("Nhập vào sinh viên thứ " + (i+1));
            student.inputStudentId(listStudent);
            student.inputData();
            System.out.println("Chọn lớp cho sinh viên!");
            System.out.println("STT     Tên lớp học");
            for (int j = 0; j < listClass.size(); j++) {
                System.out.printf("%-5d%-15s\n", (j + 1), listClass.get(j).getclassName());
            }
            System.out.println("Lựa chọn của bạn là: ");
            int num = 0;
            try {
                num = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Vui lòng nhập vào số");
            }
            student.setClassStudent(listClass.get(num-1));
            listStudent.add(student);
        }
    }
    public static void displayStudents (){
        for (Student student : listStudent) {
            student.displayData();
        }
    }
    public static void calAverageScore(){
        for (int i = 0; i < listStudent.size(); i++) {
            listStudent.get(i).calAvgMark();
        }
        System.out.println("Đã tính xong điểm trung bình của Sinh viên");
    }
    public static void updateStudent (Scanner scanner){

        StudentManagement.getupDateDataStudent(scanner);


    }
    public static int getupDateDataStudent (Scanner scanner){
        int checkData ;
        while (true){
            System.out.println("Nhập vào mã sinh viên cần cập nhật thông tin!");
            String checkUpdate = scanner.nextLine();
            if (checkUpdate.trim().length() == 6 && checkUpdate.charAt(0) == 'S'){
                for (int i = 0; i < listStudent.size(); i++) {
                    if (checkUpdate.equals(listStudent.get(i).getStudentId())){
                        checkData = i;
                        break;
                    }else {
                        System.err.println("Không tìm thấy mã sản phẩm này");
                        System.out.println("Bạn muốn tìm lại mã khác không?");
                        System.out.println("1. Có");
                        System.out.println("2. Không");
                        System.out.println("Lựa chọn của bạn là!");
                        int choice = Integer.parseInt(scanner.nextLine());
                        if (choice!=1){
                            break;
                        }
                    }
                }
            }else {
                System.err.println("Vui lòng nhập mã sinh viên có 6 ký tự và bắt đầu bằng ký tự 'S' ");
            }
        }

    }
    public static void  ratingStudents (){
        for (int i = 0; i < listStudent.size(); i++) {
            listStudent.get(i).getGPA();
        }
        System.out.println("Đã xếp loại thành công!!!");
    }
    public static void softStudentsByMark (){
        listStudent.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getAvgMark()-o2.getAvgMark());
            }
        });
        for (Student student : listStudent) {
            student.displayData();
        }
    }
    public static void seachStudentsByName (Scanner scanner){

        while (true) {
            System.out.println("Nhập tên sinh viên muốn tìm kiếm!");
            String name = scanner.nextLine();
            if (name.trim().length()!=0){
                for (Student student : listStudent) {
                    if (name.equals(student.getStudentName())) {
                        student.displayData();
                        break;
                    } else {
                        System.err.println("Không có tên sinh viên này trong danh sách! Vui lòng nhập tên khác!");
                    }
                }
            }else {
                System.err.println("Không được để trống!!!");
            }
        }
    }
    public static void statisticsByPerformance (){
        int good = 0;
        int pretty = 0;
        int average = 0;
        int bad = 0;
        System.out.println("Số học sinh đạt học sinh giỏi");
        for (Student student : listStudent) {
            if (Objects.equals(student.getgPA(), "Giỏi")) {
                student.displayData();
                good++;
            }
        }
        System.out.println("Tổng: " + good);
        System.out.println("Số học sinh đạt học sinh khá");
        for (Student student : listStudent) {
            if (Objects.equals(student.getgPA(), "Khá")) {
                student.displayData();
                pretty++;
            }
        }
        System.out.println("Tổng: " + pretty);
        System.out.println("Số học sinh đạt học sinh trung bình");
        for (Student student : listStudent) {
            if (Objects.equals(student.getgPA(), "Trung Bình")) {
                student.displayData();
                average++;
            }
        }
        System.out.println("Tổng: " + average);
        System.out.println("Số học sinh đạt học sinh kém");
        for (Student student : listStudent) {
            if (Objects.equals(student.getgPA(), "Yếu")) {
                student.displayData();
                bad++;
            }
        }
        System.out.println("Tổng: " + bad);
    }
    public static void statisticsOfPassStudents (){
        IStudentManagement markPass = new Student();
        int cnt = 0;
        System.out.println("Những học sinh qua môn JavaScript");
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getTopMark(listStudent.get(i).getListMarkJavaScript())>=markPass.MARK_PASS){
                System.out.printf("%d%s\n",cnt+1 , listStudent.get(i).getStudentName());
                cnt++;
            }
        }
        System.out.println("Tổng: " +cnt);
        cnt=0;
        System.out.println("Những học sinh qua môn Java Core");
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getTopMark(listStudent.get(i).getListMarkJavaCore())>=markPass.MARK_PASS){
                System.out.printf("%d%s\n",cnt+1 , listStudent.get(i).getStudentName());
                cnt++;
            }
        }
        System.out.println("Tổng: " +cnt);
        cnt=0;
        System.out.println("Những học sinh qua môn JavaScript");
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getTopMark(listStudent.get(i).getListMarkJavaWeb())>=markPass.MARK_PASS){
                System.out.printf("%d%s\n",cnt+1 , listStudent.get(i).getStudentName());
                cnt++;
            }
        }
        System.out.println("Tổng: " +cnt);
    }
}
