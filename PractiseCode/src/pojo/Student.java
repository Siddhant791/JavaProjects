package src.pojo;

public class Student {
    private int id;
    private String name;
    private double marks;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // toString method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    // equals method
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Student student = (Student) obj;
//        return id == student.id &&
//                Double.compare(student.marks, marks) == 0 &&
//                (name == null ? student.name == null : name.equals(student.name));
//    }

    // hashCode method
//    @Override
//    public int hashCode() {
//        int result = 17;
//        result = 31 * result + id;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        long marksTemp = Double.doubleToLongBits(marks);
//        result = 31 * result + (int) (marksTemp ^ (marksTemp >>> 32));
//        return result;
//    }
}
