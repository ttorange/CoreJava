package abstractClasses;

public class Student extends Person{
	private String major;
	public Student(String n,String major) {
		super(n);
		this.major=major;
	}
	public String getDescription() {
		return "a student majoring in"+major;
	}

}
