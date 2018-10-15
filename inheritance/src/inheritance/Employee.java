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
	 * Object:是所有类的超类
	 *        Object类只能做各种值的通用持有者，要具体操作时需要转化 
	 *        用object类型变量引用任何类型对象 Object obj=new Employee("harry",100);
	 *        具体转化： Employee e=(Employee)obj;
	 * equals方法：检测两个对象是否相等
	 *        检测思路：
	 *        
	 *        1：显式参数命名为otherObject，稍后转换成叫other的变量
	 *        2：检测this域otherObject是否引用同一个对象
	 *        3：检测otherObject是否为null，如果为null，返回false
	 *        4：比较this与otherObject属于同一个类（getClass方法返回一个对象所属的类）
	 *        5：将otherObject转化为相应的类类型变量
	 *        6：进行域比较
	 */
	public boolean equals(Object otherObject) {
		if(this==otherObject)return true;
		if(otherObject==null)return false;
		if(getClass()!=otherObject.getClass())return false;
		Employee other=(Employee)otherObject;
		
		return Objects.equals(name,other.name)&&salary==other.salary&&Objects.equals(hireDay, other.hireDay);
	}
	/*
	 * hashCode由对象导出的一个整型值
	 * 
	 */
	public int hashCode() {
		return Objects.hash(name,salary,hireDay);
	}
	//toStrign返回表示对象值的字符串
	      //是一种非常有效的调试工具，方便用户获取对象状态的必要信息
	public String toString() {
		return getClass().getName()+"[name="+name+",salary="+salary+",hireDay="+hireDay+"]";
	}

}
