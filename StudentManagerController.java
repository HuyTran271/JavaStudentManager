import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentManagerController {
    StudentManager sm = new StudentManager();
    Scanner sc = new Scanner(System.in);
    public StudentManagerController() {
    }

    public void idInput(Student st1) {
        System.out.println("Nhap ma so sinh vien(SV + So co 3 chu so): ");
        String ID_PATTERN = "^SV\\d{3,4}$";
        st1.setId(sc.nextLine());
        while (Pattern.matches(ID_PATTERN,st1.getId()) == false) {
            System.out.println("Sai dinh dang ma so sinh vien! Xin hay nhap lai: ");
            st1.setId(sc.nextLine());
        }
    }

    public void nameInput(Student st1) {
        String NAME_PATTERN = "^[a-zA-Z\\s]+$";
        System.out.println("Nhap ho va ten cua sinh vien: ");
        st1.setName(sc.nextLine());
        while (Pattern.matches(NAME_PATTERN,st1.getName()) == false) {
            System.out.println("Sai dinh dang ten! Xin hay nhap lai!");
            st1.setName(sc.nextLine());
        }
    }

    public void birthInput(Student st1) {
        System.out.println("Nhap ngay sinh cua sinh vien: ");
        String DATE_PATTERN= "^\\d{1,2}[\\/|-]\\d{1,2}[\\/|-]\\d{4}$";
        st1.setBirth(sc.nextLine());
        while(Pattern.matches(DATE_PATTERN,st1.getBirth()) == false) {
            System.out.println("Sai dinh dang ngay! Xin hay nhap lai: ");
            st1.setBirth(sc.nextLine());
        }
    }

    public void telInput(Student st1) {
        System.out.println("Nhap so dien thoai cua sinh vien: ");
        st1.setTel(sc.nextLine());
        while (st1.getTel().length()<10 || st1.getTel().length()>11 || st1.getTel().charAt(0)!='0') {
            System.out.println("Sai dinh dang so dien thoai! Xin hay nhap lai: ");
            st1.setTel(sc.nextLine());
        }
    }

    public void getUserInfo() {
        Student st1 = new Student();
        idInput(st1);
        nameInput(st1);
        birthInput(st1);
        telInput(st1);
        while (true) {
            if (sm.getST().contains(st1)) {
                System.out.println("Ma so sinh vien da ton tai! Xin hay nhap lai!");
                idInput(st1);
                nameInput(st1);
                birthInput(st1);
                telInput(st1);      
            }
            else {
                sm.getST().add(st1);
                System.out.println("Ma so sinh vien chua ton tai! Da them sinh vien!");
                break;
            }
        }
    }

    public void checkInfoById() {
        while (true) {
            System.out.println("Hay nhap ma so sinh vien de tra cuu thong tin: ");
            Student st1 = new Student();
            st1.setId(sc.nextLine());
            boolean found = false;
            for (int i=0;i<sm.getST().size();i++) {
                if (sm.getST().get(i).getId().equals(st1.getId())) {
                    System.out.println("Ma so sinh vien: "+ sm.getST().get(i).getId() + "-" + " Ho va ten: " + sm.getST().get(i).getName() + "-" + " Ngay sinh: " + sm.getST().get(i).getBirth() + "-" + "So dien thoai: " + sm.getST().get(i).getTel());
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            } else {
                System.out.println("Ma so sinh vien khong ton tai! Xin hay nhap lai!");
            }
        }
    }

    public void deleteById() {
        while (true) {
            System.out.println("Hay nhap ma so sinh vien can xoa: ");
            Student st1 = new Student();
            boolean found = false;
            for (int i=0;i<sm.getST().size();i++) {
                if (sm.getST().get(i).getId().equals(st1.getId())) {
                    sm.getST().remove(i);
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            } else {
                System.out.println("Ma so sinh vien khong ton tai! Xin hay nhap lai!");
            }
        }
    }
}
