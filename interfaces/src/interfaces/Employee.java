package interfaces;
/*
 * �ӿڣ����ĳ�������ĳ���ض��Ľӿڣ���ô�������������
 * sort�������Զ� �����������򣬵�Ҫ�����ǰ���Ƕ���ʵ��comparable�ӿ�
 * comparable�ӿڱ������compareTo����
 * 
 * �ӿڵ�����
 *     �ӿڲ����಻��newһ��ʵ��
 *       �ӿڱ�������Ӧ��ʵ�ֽӿڵ������
 *    ������instanceof���һ�������Ƿ�������������Ƿ�ʵ��ĳ���ӿ�
 *    �ӿڿ��Ա���չ��extends��
 *    �ӿ��в��ܰ���ʵ������߾�̬�����������԰�������
 *    �ӿ��еķ����Զ�������Ϊpublic���ӿ��е����Զ�����Ϊpublic static final 
 *    ÿ�������ʵ�ֶ���ӿڣ��м��������ԡ�ÿ���ӿ���,�ֿ�
 * �ӿ��������
 *    �������ʾͨ�����Դ��ڵ����⣬����ÿ����ֻ����һ�����࣬�ӿ��ṩ�˶��ؼ̳еĺô������˸�����
 */

public class Employee implements Comparable<Employee>{
	private String name;  
	private double salary;
	
	
	public Employee(String n,double s) {
		
		name=n;
		salary=s;
	
	}
	
	
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	
	public void raiseSalary(double byPercent) {
		double raise=this.salary *byPercent/100;
		this.salary+=raise;
	}
	/*
	 * Compares employees by salary
	 *@param other another Employee object
	 *@return a negative value if this employee has a lower salary than 
	 *  otherObject,0 if the salaries are the same,a positive value otherwise
	 */
	public int compareTo(Employee other) {
		return Double.compare(salary, other.salary);
	}

}
