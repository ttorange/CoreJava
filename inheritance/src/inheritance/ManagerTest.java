package inheritance;
/*
 * 类的继承
 * 类的继承不仅限于一个层次，形成继承链
 * 多态：“is——a"规则（manger is a employee)
 * 		对象变量时多态的。，
 *   一个子类的对象可以赋给父类变量
 *   不能将一个父类的引用赋给子类变量
 * 
 */

public class ManagerTest {

	public static void main(String[] args) {
		Manager boss=new Manager("tong", 888, 1997, 1, 12);
		boss.setBonus(200);
		Employee[] staff=new Employee[3];
		staff[0]=boss;//任何子类的变量可以赋给父类变量
		/*
		 * staff[0]与boss引用同一个对象，但将boss看为Eemployee对象所以staff【0】.setBornus将报错
		 */
		
		staff[1]=new Employee("harry",3000,1985,7,5);
		staff[2]=new Employee("hali",5000,1985,7,5);
		
		for(Employee e:staff) {
			System.out.println("name="+e.getName()+"  salary="+e.getSalary());//动态绑定(根据它的类绑定方法）
		}

	}

}
