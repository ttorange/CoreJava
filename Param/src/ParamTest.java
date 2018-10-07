/*4-4��������
 * �������ݷ�ʽ�� ��ֵ���ã������õ��ã���ַ���ã�
 * java�����ǰ�ֵ����
 * ��ֵ���õõ���ʱ�����Ŀ��������������޸Ĵ��ݸ����κβ�������������
 * �����������õ������� �����������ͺͶ�������
 * ͨ������������Ϊ��������ʵ�ֲ���ֵ�ĸı�
 * java�в���ʹ��������ܽ᣺
 * 		һ�����������޸�һ�������������͵Ĳ�������ֵ�ͺͲ����ͣ�
 * 		һ���������Ըı�һ�����������״̬
 * 		һ�����������ö����������һ���µĶ���
 */
public class ParamTest {
	public static void main(String[] arg) {
		/*Test 1:  Methods can't modify numeric parameters
		 * ���ú�percentֵ��ȻΪ10
		 * �����õ�30����Ҫ�����Բ������޸�ֵ
		 * ����percent=triplevalue��value������
		*/
		System.out.println("test tripleValue");
		double percent=10;
		System.out.println("Before:percent="+ percent);
		tripleValue(percent);
		System.out.println("After:percent="+percent);
		/*
		 * Test 2: Methods can change the state of object parameters
		 * �����������������ı��˲�����״̬
		 * ִ�й���Ϊ
		 *     x��ʼ��Ϊharryֵ�Ŀ����������Ƕ��������
		 *     raiseSalaryӦ���������������ã�x��harryͬʱ���õ�Employeeнˮ���
		  *      ������������������x����ʹ�ã�harry���������Ǹ�н�������Ĺ�Ա����
		  *      
		  *  ������������ϵ����ʵĳ�����ͨ�������ڲ�������ɵ�
		 */
		System.out.println("\nTesting tripleSalary");
		Employee harry=new Employee("Harry",500);
		System.out.println("berfore:salary="+harry.getSalary());
		tripleSalary(harry);
		System.out.println("After:salary="+harry.getSalary());
		/*
		 * Test 3:Methods can't attach new objects to object parameters
		 * ��������swap��ʽ��û���ã�������ֻ�ǿ���ֵ
		 * ˵��java�������õ��ã�
		 */
		System.out.println("\nTesting swap");
		Employee a=new Employee("Alice",200);
		Employee b=new Employee("Jobs",300);
		System.out.println("Before:a="+a.getName());
		System.out.println("Before:b="+b.getName());
		swap(a,b);
		System.out.println("After:a="+a.getName());
		System.out.println("After:b="+b.getName());
		}
	
	public static void tripleValue(double x) {
		x=3*x;
		System.out.println("end of method x="+x);
	}
	public static void tripleSalary(Employee x) {
		x.raiseSalary(200);
		System.out.println("End of method:salary="+x.getSalary());
	}
	public static void swap(Employee x,Employee y) {
		Employee temp=x;
		x=y;
		y=temp;
		System.out.println("End of method x="+x.getName());
		System.out.println("End of method y="+y.getName());
	}

}
