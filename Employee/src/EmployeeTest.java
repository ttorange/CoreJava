/*����4-3
 * �û��Զ������ʹ��
 * �漰����
 *    ��Ĺ�����
 *    ��ʽ������ʽ����
 *    ��װ���ŵ�
 *    ������ķ���Ȩ��
 *    ˽�з���
 *    finalʵ����
 *    ��̬����̬����
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
		
		for(Employee e:staff)//for each �ṹ
		{
			e.setId();
			System.out.println("id:"+e.getId()+"  name="+e.getName()+"  salary="+e.getSalary()+"  hiereDay"+e.getHireDay());
			
		}
	}

}

