import java.util.Scanner;
public class StudentManagerController {
    private Scanner sc;
    StudentManager sm = new StudentManager(sc);
    StudentManagerView view = new StudentManagerView();
    public StudentManagerController(Scanner sc) {
        this.sc = sc;
        this.sm = new StudentManager(sc);
    }

    public void addStudent() {
        String id;
        while (true) {
            id = view.getInput("Nhap ma so sinh vien (Vi du: SV001, SV123, SV0001): ");

            if (sm.findById(id)!=null) {
                view.showMessage("Ma so sinh vien da ton tai! Xin hay nhap lai");
                continue;
            }

            if (!sm.idValid(id)) {
                view.showMessage("Sai dinh dang ma so sinh vien! Xin hay nhap lai!");
                continue;
            }

            break;
        }

        String name;
        while (true) { 
            name = view.getInput("Nhap ho va ten: ");

            if (!sm.nameValid(name)) {
                view.showMessage("Sai dinh dang ho va ten! Xin hay nhap lai!");
                continue;
            }

            break;
        }

        String birth;
        while (true) {
            birth = view.getInput("Nhap ngay sinh (dd/mm/yyyy): ");

            if (!sm.birthValid(birth)) {
                view.showMessage("Sai dinh dang ngay sinh! Xin hay nhap lai!");
                continue;
            }
            break;
        }

        String tel;
        while (true) {  
            tel = view.getInput("Nhap so dien thoai: ");

            if (!sm.telValid(tel)) {
                view.showMessage("Sai dinh dang so dien thoai! Xin hay nhap lai!");
                continue;
            }
            break;
        }

        Student student = new Student(id,name,birth,tel);
        sm.addStudent(student);
        view.showSuccess("Them thanh cong!");
    }

    public void changeStudent() {
        String id = view.getInput("Nhap ma so sinh vien de tim kiem: ");
        Student st = sm.findById(id);
        if (st == null) {
            System.out.println("Sinh vien khong ton tai");
            return;
        }
        view.showChangeMenu();
        int s1 = view.getIntInput("Chon thong tin de thay doi: ");
        switch (s1) {
            case 1:
                String newName = view.getInput("Nhap ten de thay doi");
                st.setName(newName);
                view.showSuccess("Thay doi ten thanh cong");
                break;
            case 2:
                String newBirth = view.getInput("Nhap ngay sinh de thay doi");
                st.setBirth(newBirth);
                break;
            case 3:
                String newTel = view.getInput("Nhap so dien thoai de thay doi");
                st.setTel(newTel);
                break;
            case 4:
                return;
            default:
                view.showError("Lua chon khong ton tai");
                return;
        }
    }

    public void findStudent() {
        view.showFindMenu();
       
        int selection = view.getIntInput("Nhap lua chon: ");

        switch (selection) {
            case 1:
                String id = view.getInput("Nhap ma so sinh vien cua sinh vien can tim kiem (Vi du: SV001, SV123, SV0001): ");
                Student found1 = sm.findById(id);
                if (found1 != null) {
                    view.showSuccess("Da tim thay sinh vien: " + found1);
                } else {
                    view.showError("Sinh vien khong ton tai!");
                    return;
                }
                break;
            case 2:
                String name = view.getInput("Nhap ten hoac 1 phan ten cua sinh vien can tim kiem (Vi du: Tim Tran Huy thi co the nhap Tran hoac Huy hoac Tran Huy): ");
                if (!sm.findByName(name).isEmpty()) {
                    view.showSuccess("Da tim thay sinh vien: " + sm.findByName(name));
                } else {
                    view.showError("Sinh vien khong ton tai!");
                    return;
                }
                break;
            case 3:
                String year = view.getInput("Nhap nam cua sinh vien can tim kiem (Vi du: 1990, 2000, 2023): ");
                if (!sm.findByYear(year).isEmpty()) {
                    view.showSuccess("Da tim thay sinh vien: " + sm.findByYear(year));
                } else {
                    view.showError("Sinh vien khong ton tai!");
                    return;
                }
                break;
            case 4:
                return;
            default:
                view.showError("Lua chon khong ton tai");
        }
    }

    public void deleteStudent() {
        String id = view.getInput("Nhap ma so sinh vien cua sinh vien can xoa: ");

        if (sm.deleteById(id)) {
            view.showSuccess("Xoa thanh cong!");
        } else {
            view.showError("Xoa khong thanh cong!");
        }
    }

    public void showAllStudent() {
        view.showAllStudent(sm.getST());
    }

    public void run() {
        while (true) {
            view.showMainMenu();
            int selection = view.getIntInput("Nhap lua chon: ");
            switch (selection) {
                case 1:
                    while (true) {
                        addStudent();
                        if (view.askContinue("Nhap")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        findStudent();
                        if (view.askContinue("Tim")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        deleteStudent();
                        if (view.askContinue("Xoa")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        changeStudent();
                        if (view.askContinue("Thay doi")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    break;
                case 5:
                    showAllStudent();
                    break;
                case 6:
                    view.showMessage("Thoat chuong trinh");
                    return;
                default:
                    view.showError("Lua chon khong ton tai! Xin hay nhap lai!");
                    continue;
            }
        }
    }
}
