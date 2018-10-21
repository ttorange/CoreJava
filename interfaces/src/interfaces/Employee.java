package interfaces;
/*
 * 接口：如果某各类遵从某个特定的接口，那么久履行这项服务
 * sort方法可以对 对象数组排序，但要满足的前提是对象实现comparable接口
 * comparable接口必须包含compareTo方法
 * 
 * 接口的特性
 *     接口不是类不能new一个实例
 *       接口变量必须应用实现接口的类对象
 *    可以用instanceof检查一个对象是否属于摸个类或是否实现某个接口
 *    接口可以被扩展（extends）
 *    接口中不能包含实例域或者静态方法，但可以包含常量
 *    接口中的方法自动被设置为public。接口中的域自动设置为public static final 
 *    每个类可以实现多个接口，有极大的灵活性。每个接口用,分开
 * 接口与抽象类
 *    抽象类表示通用属性存在的问题，所以每个类只能有一个父类，接口提供了多重继承的好处避免了复杂性
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
