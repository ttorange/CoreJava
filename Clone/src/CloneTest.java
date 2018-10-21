
public class CloneTest {

	public static void main(String[] args) {
		try {
			Employee original=new Employee("john Q.Public", 5000);
			original.setHireDay(2008, 1, 1);
			Employee copy=original.clone();
			copy.raiseSalary(10);
			copy.setHireDay(2002, 2, 12);
			original.raiseSalary(20);
			System.out.println("original="+original);
			System.out.println("copy="+copy);
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

}
