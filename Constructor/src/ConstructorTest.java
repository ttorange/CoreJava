/*4.6
 * ����Ĺ���
 * ���ع�����
 * ��this��.....)������һ��������
 * �޲���������
 * �����ʼ����
 * ��̬��ʼ����
 * ʵ�����ʼ��
 */
public class ConstructorTest {
	public static void main(String[] args) {
		//fill the staff array with three Employee objects
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("Harry",888);
		staff[1]=new Employee(6000);
		staff[2]=new Employee();
		//�������ṩ����һ����������û���ṩ�޲���������ʱ���ṩ�޲���ʵ��ʱ�᲻�Ϸ�
		
		for(Employee e : staff)
			System.out.println("name="+e.getName()+"  id="+e.getId()+"  salary="+e.getSalary());
	}

}
