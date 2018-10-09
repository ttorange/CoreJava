/*4.6
 * 对象的构造
 * 重载构造器
 * 用this（.....)调用另一个构造器
 * 无参数构造器
 * 对象初始化块
 * 静态初始化块
 * 实例域初始化
 */
public class ConstructorTest {
	public static void main(String[] args) {
		//fill the staff array with three Employee objects
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("Harry",888);
		staff[1]=new Employee(6000);
		staff[2]=new Employee();
		//当类中提供至少一个构造器但没有提供无参数构造器时，提供无参数实例时会不合法
		
		for(Employee e : staff)
			System.out.println("name="+e.getName()+"  id="+e.getId()+"  salary="+e.getSalary());
	}

}
