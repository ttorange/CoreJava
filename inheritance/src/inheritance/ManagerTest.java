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
		
		Employee alice1=new Employee("alice", 75000, 1999, 11, 11);
		Employee alice2=alice1;
		Employee alice3=new Employee("alice", 75000, 1999, 11, 11);
		Employee bob=new Employee("bob", 7000, 1899, 11, 11);
		System.out.println("alice1==alice2:  "+(alice1==alice2));
		System.out.println("alice1==alice3:  "+(alice1==alice3));//"==="用于判断两个对象地址是否相等
		System.out.println("alice1.equals(alice3) "+alice1.equals(alice3));
		System.out.println("alice1.equals(bob) "+alice1.equals(bob));
		System.out.println("bob.toString"+bob);//bob也可以写成bob.toString
		
		Manager carl=new Manager("Carl", 8000, 1997, 8, 2);
		Manager monster=new Manager("Carl", 8000, 1997, 8, 2);
		monster.setBonus(2000);//只给这个bonus了，这俩再比就不一样了
		
		System.out.println("monster "+monster);
		System.out.println("carl.equal(monster)"+carl.equals(monster));
		System.out.println("alice1.hashCode"+alice1.hashCode());
		System.out.println("alice3.hashCode"+alice3.hashCode());
		System.out.println("bob.hashCode"+bob.hashCode());
		System.out.println("carl.hashCode"+carl.hashCode());
	}

}
