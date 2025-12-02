import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StudentManager {
    private static List<Student> st = new ArrayList<>();
    private Scanner sc;

    String ID_PATTERN = "^SV\\d{3,4}$";
    String NAME_PATTERN = "^[a-zA-Z\\s]+$";
    String DATE_PATTERN = "^\\d{1,2}[\\/|-]\\d{1,2}[\\/|-]\\d{4}$";
    String TEL_PATTERN = "^0[1-9]{9,10}$";

    public StudentManager(Scanner sc) {
        this.sc = sc;
    }

    public List<Student> getST () {
        return this.st;
    }

    public boolean idValid(String id) {
        return Pattern.matches(ID_PATTERN,id);
    }

    public boolean nameValid(String name) {
        return Pattern.matches(NAME_PATTERN,name);
    }

    public boolean birthValid(String birth) {
        return Pattern.matches(DATE_PATTERN,birth);
    }

    public boolean telValid(String tel) {
        return Pattern.matches(TEL_PATTERN,tel);
    }

    public boolean addStudent(Student stu) {
        if (findById(stu.getId()) != null) {
            System.out.println("Ma so sinh vien da ton tai!");
            return false;
        }
        return st.add(stu);
    }

    public Student findById(String id) {
        return st.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Student> findByName(String keyWord) {
        return st.stream() 
                .filter(s -> s.getName().toLowerCase().contains(keyWord.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Student> findByYear(String year) {
        return st.stream()
                .filter(s -> s.getBirth().contains(year))
                .collect(Collectors.toList());
    }

    public boolean getUserInfo(Student stu) {
        if (findById(stu.getId()) != null) {
            return true;
        }
        return st.add(stu);
    }

    public boolean deleteById(String id) {
        return st.removeIf(s -> s.getId().equals(id));
    }

    public void showAllStudent() {
        for (int i=0;i<st.size();i++) {
            System.out.println(st.get(i));
        }
    }
}
