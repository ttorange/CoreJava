/*程序4-3
 * 用户自定义类的使用
 * 涉及内容
 *    类的构造器
 *    隐式参数显式参数
 *    封装的优点
 *    基于类的访问权限
 *    私有方法
 *    final实例域
 *    静态域域静态方法
 * 
 */
public class EmployeeTest {
	public static void main(String[] args) {
		Employee[] staff =new Employee[3];
		staff[0]=new Employee("nike", 75000, 1997, 12,15);
		staff[1]=new Employee("tong", 85000, 1999, 10,15);
		staff[2]=new Employee("jame", 79000, 1977, 12,15);
		//raise everyone's  salary by 5%
		for(Employee e:staff) {
			e.raiseSalary(5);
		}
		//print out information about all of them
		
		for(Employee e:staff)//for each 结构
		{
			e.setId();
			System.out.println("id:"+e.getId()+"  name="+e.getName()+"  salary="+e.getSalary()+"  hiereDay"+e.getHireDay());
			
		}
	}

}

