import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private static List<Student> st = new ArrayList<>();

    public StudentManager() {

    }

    public List<Student> getST () {
        return this.st;
    }
}
