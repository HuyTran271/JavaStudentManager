public class App {
    public static void main(String[] args) {
        StudentManagerController smc = new StudentManagerController();
        StudentManagerView smv = new StudentManagerView(smc);
        smv.menu();
    }
}
