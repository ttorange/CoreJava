package abstractClasses;
/*
 * 最好将类中的域设置为private 将方法标记为public
 *    若希望超类中的某些方法允许被子类访问则将这些方法设置为protected
 */
public class PErsonTest {
	public static void main(String[] args) {
		Person[] people=new Person[2];
		people[0]=new Employee("Harry Hacker",5000,1998,12,25);
		people[1]=new Student("Jobs","CS");
		
		for(Person e:people)
			System.out.println(e.getName()+"  "+e.getDescription());
		//如果抽象方法中没有定义getDesc方法e.getDesc将无法调用，因为编译器只允许调用在类中声明的方法
		
	}

}
