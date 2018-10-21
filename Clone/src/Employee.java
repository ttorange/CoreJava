import java.util.Date;
import java.util.GregorianCalendar;
/*
 * �����¡
 *   ������һ������ʱ����ԭʼ�����򿽱���������ͬһ������ʱ���ı�һ�����������һ���������Ӱ�죬�粻���������Ҫ��¡һ��������в���
 *   ǳ������һ���ĸı�ᵼ��˫���ĸı�
 *   �������Ҫ������пɱ�ʵ�����clone
 *   Ӧ�ý�����ʹ�ÿ�¡����
 *  
 */
public class Employee implements Cloneable{
	private String name;  
	private double salary;
	private Date hireDay;
	
	public Employee(String n,double s) {
		
		name=n;
		salary=s;
		hireDay=new Date();
	}
	//ʵ�����¡��throw...��û��ʵ��Cloneable�ӿڻ��׳������쳣
	public Employee clone() throws CloneNotSupportedException{
		Employee cloned=(Employee)super.clone();//call Object.clone()
		//Date�ǿɱ�ģ������Ҫ��¡���пɱ��ʵ�������û����������һ���ĸı������˫����ͬ�ĸı䣬Υ���˳���
		cloned.hireDay=(Date)hireDay.clone();//clone mutable fields(��¡�ɱ����)
		return cloned;
	}
	public void setHireDay(int year,int month,int day) {
		Date newHireDay=new GregorianCalendar(year,month-1,day).getTime();
		
		hireDay.setTime(newHireDay.getTime());
	}
	
	
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public Date getHireDay() {
		return hireDay;
	}
	public void raiseSalary(double byPercent) {
		double raise=this.salary *byPercent/100;
		this.salary+=raise;
	}
	public String toString() {
		return "Employee[name="+name+",salary="+salary+",hireDay="+hireDay+"]";
	}


}
