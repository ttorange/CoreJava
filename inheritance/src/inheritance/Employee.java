package inheritance;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee {
	
	private String name;  
	private double salary;
	private Date hireDay;
	
	public Employee(String n,double s,int year,int month,int day) {
		
		name=n;
		salary=s;
		GregorianCalendar calendar=new GregorianCalendar(year,month-1,day);
		hireDay=calendar.getTime();
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
	/*
	 * Object:��������ĳ���
	 *        Object��ֻ��������ֵ��ͨ�ó����ߣ�Ҫ�������ʱ��Ҫת�� 
	 *        ��object���ͱ��������κ����Ͷ��� Object obj=new Employee("harry",100);
	 *        ����ת���� Employee e=(Employee)obj;
	 * equals������������������Ƿ����
	 *        ���˼·��
	 *        
	 *        1����ʽ��������ΪotherObject���Ժ�ת���ɽ�other�ı���
	 *        2�����this��otherObject�Ƿ�����ͬһ������
	 *        3�����otherObject�Ƿ�Ϊnull�����Ϊnull������false
	 *        4���Ƚ�this��otherObject����ͬһ���ࣨgetClass��������һ�������������ࣩ
	 *        5����otherObjectת��Ϊ��Ӧ�������ͱ���
	 *        6��������Ƚ�
	 */
	public boolean equals(Object otherObject) {
		if(this==otherObject)return true;
		if(otherObject==null)return false;
		if(getClass()!=otherObject.getClass())return false;
		Employee other=(Employee)otherObject;
		
		return Objects.equals(name,other.name)&&salary==other.salary&&Objects.equals(hireDay, other.hireDay);
	}
	/*
	 * hashCode�ɶ��󵼳���һ������ֵ
	 * 
	 */
	public int hashCode() {
		return Objects.hash(name,salary,hireDay);
	}
	//toStrign���ر�ʾ����ֵ���ַ���
	      //��һ�ַǳ���Ч�ĵ��Թ��ߣ������û���ȡ����״̬�ı�Ҫ��Ϣ
	public String toString() {
		return getClass().getName()+"[name="+name+",salary="+salary+",hireDay="+hireDay+"]";
	}

}
