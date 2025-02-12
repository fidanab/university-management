import java.util.Arrays; 

public class Student {
    private String name;
    private int id;
    private double gpa;
    private String[] subjects; 

    public Student(String name, int id, double gpa, String[] subjects) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0 && gpa <= 4) {
            this.gpa = gpa;
        } else {
            System.out.println("Incorrect GPA");
        }
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + Integer.toString(id));
        System.out.println("Student GPA: " + Double.toString(gpa)); 
        System.out.println("Subjects: " + Arrays.toString(subjects)); 
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', id=" + id + ", gpa=" + gpa + ", subjects=" + Arrays.toString(subjects) + "}";
    }

    public static void main(String[] args) {
        String[] studentSubjects = {"Math", "Physics", "Computer Science"};

        Student student1 = new Student("Rouge", 101, 3.5, studentSubjects);

        student1.displayInfo();

        System.out.println(student1);
    }
}
