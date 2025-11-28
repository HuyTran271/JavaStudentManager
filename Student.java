public class Student {
    private String studentId;
    private String name;
    private String birth;
    private String tel;

    public Student () {
    }

    public String getId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }
    
    public String getTel() {
        return tel;
    }

    public void setId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Student)) return false;
        Student other = (Student) o;
        return studentId != null && studentId.equals(other.studentId);
    }

    @Override
    public int hashCode() {
        return studentId == null ? 0: studentId.hashCode();
    }
}
