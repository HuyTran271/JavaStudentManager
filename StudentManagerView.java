import java.util.Scanner;

public class StudentManagerView {
    public static Scanner sc = new Scanner(System.in);
    int selection;
    StudentManagerController smc = new StudentManagerController();

    public StudentManagerView (StudentManagerController smc) {
            this.smc = smc;
    }

    public void menu() {
        while (true) {
            System.out.println("1. Nhap thong tin sinh vien");
            System.out.println("2. Tra cuu sinh vien");
            System.out.println("3. Xoa sinh vien");
            System.out.println("4. Thoat");
            System.out.println("Nhap lua chon: ");
            try {
                selection = sc.nextInt();
                switch (selection) {
                    case 1:
                    while (true) { 
                            smc.getUserInfo();
                            System.out.println("1. Tiep tuc nhap them");
                            System.out.println("2. Quay lai");
                            System.out.println("Nhap lua chon: ");
                        try {
                            int selection1 = sc.nextInt();
                            if (selection1==1) {
                                continue;
                            } else if (selection1==2) {
                                break; 
                            }
                        }
                        catch (java.util.InputMismatchException e) {
                            System.out.println("Lua chon khong hop le! Xin hay nhap lai: ");
                            sc.nextLine();
                        }
                    }
                        break;
                    case 2:
                        smc.checkInfoById();
                        System.out.println("1. Tim tiep");
                        System.out.println("2. Quay lai");
                        int selection2 = sc.nextInt();
                        if (selection2 == 1) {
                            smc.checkInfoById();
                        } else {
                            break;
                        }
                        break;
                    case 3:
                        smc.deleteById();
                        System.out.println("1. Xoa tiep");
                        System.out.println("2. Quay lai");
                        int selection3 = sc.nextInt();
                        if (selection3 == 1) {
                            smc.deleteById();
                        } else {
                            break;
                        }
                        break;
                    case 4:
                        throw new RuntimeException("Thoat ung dung");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Lua chon khong hop le! Xin hay nhap lai: ");
                sc.nextLine();
            }
        }
    }
}
