
import java.util.*;

public class Employee {
	private static int nextId=1;//静态常量
	private int id;
	//显式域初始化，为每个实例域设置一个有意义的初值
	private String name="";//instance field initialization
	private double salary;
	
	/*
	 *初始化块
	 *初始化数据域的方法：
	 *    在构造器中设置值。
	 *    声明中赋值
	 *   初始化块机制，只要构造类的对象，数据块（可以包含多个代码块）就会被执行  
	 */
	static
	{
		Random generator=new Random();
		//set next id to a random number between 0 and 9999
		nextId=generator.nextInt(10000);
	}
	//object initialization block
	{
		id=nextId;
		nextId++;
	}
	//参数名带有其含义代码阅读性会更好
	public Employee(String name,double salary) {
		this.name=name;
		this.salary=salary;
	}
	//调用另一个构造器,这种方法对公共构造器代码部分只需编写一次
	public Employee(double salary) {
		//calls the Employee(String,double)constructor
		this("Employee#"+nextId,salary);
	}
	
	//无参数构造器，其状态都是默认值值，当类没有提供任何构造器的时候系统会提供一个默认的构造器
	public Employee() {
		/*
		 * name initialized to "" 
		 * salary not explicitly set--initialized to 0
		 * id initialized in initialization block
		 */
	}
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	
	
	

}
