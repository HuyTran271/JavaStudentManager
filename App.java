import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagerController smc = new StudentManagerController(scanner);
        StudentManagerView smv = new StudentManagerView();
        StudentManager sm = new StudentManager(scanner);
        smc.run();
    }
}
