import java.util.List;
import java.util.Scanner;

public class StudentManagerView {
    private Scanner sc = new Scanner(System.in);

    public StudentManagerView () {
    }
    
    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showSuccess(String msg) {
        System.out.println("✓ " + msg);
    }

    public void showError(String msg) {
        System.out.println("✗ " + msg);
    }

    public void showStudent(Student stu) {
        System.out.println(stu);
    }

    public String getInput(String msg) {
        System.out.println(msg);
        return sc.nextLine().trim();
    }

    public int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                showError("Vui long nhap so hop le!");
            }
        }
    }

    public boolean askContinue(String action) {
        System.out.println("1. " + action + " tiep");
        System.out.println("2. Quay lai"); 
        System.out.print("Nhap lua chon: ");     
        try {
            int selection1 = Integer.parseInt(sc.nextLine()); 
            return selection1 == 1;
        } catch (NumberFormatException e) {
            System.out.println("Lua chon khong hop le! Xin hay nhap lai!");
            return false;
        }
    }

    public void showAllStudent(List<Student> st) {
        if(!st.isEmpty()) {
            System.out.println("Danh sach sinh vien");
            System.out.println(st);
        } else {
            System.out.println("Danh sach rong!");
        }
    }

    public void showMainMenu() {
        System.out.println("===Main menu===");
        System.out.println("1. Them sinh vien");
        System.out.println("2. Tim kiem sinh vien");
        System.out.println("3. Xoa sinh vien");
        System.out.println("4. Thay doi thong tin sinh vien");
        System.out.println("5. Hien thi danh sach sinh vien");
        System.out.println("6. Thoat chuong trinh");
    }

    public void showChangeMenu() {
        System.out.println("===Thay doi thong tin sinh vien===");
        System.out.println("1. Thay doi ho va ten");
        System.out.println("2. Thay doi ngay sinh");
        System.out.println("3. Thay doi so dien thoai");
        System.out.println("4. Quay lai");
    }
    
    public void showFindMenu() {
        System.out.println("===Tim kiem sinh vien===");
        System.out.println("1. Tim kiem theo ma so sinh vien");
        System.out.println("2. Tim kiem theo ho va ten hoac 1 phan ten");
        System.out.println("3. Tim kiem theo nam sinh");
        System.out.println("4. Quay lai");
    }
}
