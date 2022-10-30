package app.pojos;

public class Student implements Comparable<Student> {
	public int rollNo;
	public String name;
	
	public Student(int rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + "]";
	}
	
	public int compareTo(Student that) {
		return this.name.compareToIgnoreCase(that.name);
//		return this.rollNo-that.rollNo;
	}
	
	
	
}
