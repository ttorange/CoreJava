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

	}

}
