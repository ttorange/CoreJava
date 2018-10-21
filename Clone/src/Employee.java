import java.util.Date;
import java.util.GregorianCalendar;
/*
 * 对象克隆
 *   当拷贝一个变量时，若原始变量域拷贝变量引用同一个对象时，改变一个变量会对另一个对象产生影响，如不想如此则需要克隆一个对象进行操作
 *   浅拷贝：一方的改变会导致双方的改变
 *   深拷贝：需要完成所有可变实例域的clone
 *   应该谨慎的使用克隆方法
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
	//实现深克隆，throw...若没有实现Cloneable接口会抛出检验异常
	public Employee clone() throws CloneNotSupportedException{
		Employee cloned=(Employee)super.clone();//call Object.clone()
		//Date是可变的，深拷贝需要克隆所有可变的实例域，如果没有这样做，一方的改变会引起双方共同的改变，违背了初衷
		cloned.hireDay=(Date)hireDay.clone();//clone mutable fields(克隆可变的量)
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
