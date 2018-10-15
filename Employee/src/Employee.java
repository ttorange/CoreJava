
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * 类的设计技巧：
 *     1保证数据私有
 *     2要对数据进行初始化（提供默认值）
 *     3不要在类中使用过多基本类型（比如将Customer类中的street，city数据打包成一个Address类）
 *     4不是所有的域都要独立的域访问器和更改器
 *     5将职责过多的类进行分解（低耦合，把一个类细分成多个类，不要把一个类做得太庞大）
 *     6类名和方法名要能体现它的职责 
 */
public class Employee {
	private static int nextId=1;//静态常量
	private int id;
	
	private String name;   //为了保证对象构建后不会被改变可以用final关键字
	//比如 private final String name;
	private double salary;
	private Date hireDay;//此处不能给hireDay加上final，String是不可变类，Date是可变类，final会造成混乱
	
	/*一个构造器和四个方法，private保证只有自身的方法可以访问该数据，构造器与类同名
	注意点：构造器与类同名
	         每个类可以有一个以上的构造器
	       构造器可以有多个参数
	     构造器没有返回值
	     构造器总是伴随着new操作一起调用
	     
	*/
	public Employee(String n,double s,int year,int month,int day) {
		//不要在构造器中定义与实例域重名的局部变量
		name=n;//比如此处 写成 String name=n;  double salary=s;这样会产生很隐蔽的错误，因为之前已经定义过
		salary=s;
		id=0;
		GregorianCalendar calendar=new GregorianCalendar(year,month-1,day);//Gregoriancalendar uses 0 for January
		hireDay=calendar.getTime();
	}
	
	/*访问器方法，只返回实例域值
	 *通过此方法封装数据
	 *此处name等数据是只读的。一旦设置完毕就无法被修改salary只能通过raiseSalary方法修改
	 *通常获得或设置一个实例域值需要的内容为：
	 *     1一个私有的数据域  2一个共有的域访问器3  一个共有的域更改器方法
	 *  这种做法好处有  
	 *    改变内部实现时不会影响其他方法 比如 name数据改成 firstname  和  lastname，此时只需改变getname的程序
	 *    更改器方法可以设置错误检查程序，比如 setsalary 当salary<0时报错
	 *    
	 *    
	 */
	public int getId() {
		return id;
	}
	public void setId() {
		id=nextId;
		nextId++;
	}
	/*静态方法：不能像对象实例实施操作的方法、属于类但不属于类的对象的方法
	 *    比如。Math类的pow方法   Math.pow(x,a)
	 *         计算x的a次方，
	 *         运算时不适用任何Math对象（即没有隐式参数）
	 *  静态方法不能操作对象，所以不能再金泰方法中访问实例域。但是可以访问自身类中的静态域
	 *  
	 * 静态方法的使用场景
	 *     一个方法不需要访问对象状态，所需参数都是显式参数提供
	 *     一个方法只需要访问静态域
	 *   静态常量。使用较多 比如Math中的Pi
	 *         此处nextId为静态变量,
	 *             比如有100个实例，就会有100个id但会只有1个nextId，没有实例时也会有一个nextId
	*/
	public static int getNExtID() {
		return nextId;//nextId 为静态域
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
		this.salary+=raise;//调用时  e.raiseSalary(5) 方法名前的对象为隐式参数，括号中的值为显式参数
		              //用this表示隐式参数,这样可以把局部变量与实例域明显的区别出来 
	}
	public static int getNextId() {
		return nextId;//returns static fiedld
	}
	//每个类都可以有一个main方法，常用于测试，当此类用于程序中时，该main不会执行
	public static void main(String[] args) {
		Employee e=new Employee("tong",16500, 2018, 12, 8);
		System.out.println(e.getName()+"   "+e.getSalary());
	}
}
