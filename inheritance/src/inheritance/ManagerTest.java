package inheritance;


/*
 * ��ļ̳�
 * ��ļ̳в�������һ����Σ��γɼ̳���
 * ��̬����is����a"����manger is a employee)
 * 		�������ʱ��̬�ġ���
 *   һ������Ķ�����Ը����������
 *   ���ܽ�һ����������ø����������
 * 
 */

public class ManagerTest {

	public static void main(String[] args) {
		Manager boss=new Manager("tong", 888, 1997, 1, 12);
		boss.setBonus(200);
		Employee[] staff=new Employee[3];
		staff[0]=boss;//�κ�����ı������Ը����������
		/*
		 * staff[0]��boss����ͬһ�����󣬵���boss��ΪEemployee��������staff��0��.setBornus������
		 */
		
		staff[1]=new Employee("harry",3000,1985,7,5);
		staff[2]=new Employee("hali",5000,1985,7,5);
		
		for(Employee e:staff) {
			System.out.println("name="+e.getName()+"  salary="+e.getSalary());//��̬��(����������󶨷�����
		}
		
		Employee alice1=new Employee("alice", 75000, 1999, 11, 11);
		Employee alice2=alice1;
		Employee alice3=new Employee("alice", 75000, 1999, 11, 11);
		Employee bob=new Employee("bob", 7000, 1899, 11, 11);
		System.out.println("alice1==alice2:  "+(alice1==alice2));
		System.out.println("alice1==alice3:  "+(alice1==alice3));//"==="�����ж����������ַ�Ƿ����
		System.out.println("alice1.equals(alice3) "+alice1.equals(alice3));
		System.out.println("alice1.equals(bob) "+alice1.equals(bob));
		System.out.println("bob.toString"+bob);//bobҲ����д��bob.toString
		
		Manager carl=new Manager("Carl", 8000, 1997, 8, 2);
		Manager monster=new Manager("Carl", 8000, 1997, 8, 2);
		monster.setBonus(2000);//ֻ�����bonus�ˣ������ٱȾͲ�һ����
		
		System.out.println("monster "+monster);
		System.out.println("carl.equal(monster)"+carl.equals(monster));
		System.out.println("alice1.hashCode"+alice1.hashCode());
		System.out.println("alice3.hashCode"+alice3.hashCode());
		System.out.println("bob.hashCode"+bob.hashCode());
		System.out.println("carl.hashCode"+carl.hashCode());
	}

}
