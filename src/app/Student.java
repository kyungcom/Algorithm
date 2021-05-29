package app;

public class Student implements Comparable<Student> {
    private String name;
    private int grade;

    public Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Student other) {
        if (this.grade < other.grade) {
            return -1;
        }
        return 1;
    }
}
