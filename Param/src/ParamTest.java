/*4-4方法参数
 * 参数传递方式： 按值调用，按引用调用（地址调用）
 * java中总是按值调用
 * 按值调用得到的时参数的拷贝，方法不能修改传递给他任何参数变量的内容
 * 方法参数调用的类型有 基本数据类型和对象引用
 * 通过对象引用作为参数可以实现参数值的改变
 * java中参数使用情况的总结：
 * 		一个方法不能修改一个基本数据类型的参数（数值型和布尔型）
 * 		一个方法可以改变一个对象参数的状态
 * 		一个方法不能让对象参数引用一个新的对象
 */
public class ParamTest {
	public static void main(String[] arg) {
		/*Test 1:  Methods can't modify numeric parameters
		 * 调用后percent值仍然为10
		 * 如果想得到30，需要保留对参数的修改值
		 * 比如percent=triplevalue（value）这样
		*/
		System.out.println("test tripleValue");
		double percent=10;
		System.out.println("Before:percent="+ percent);
		tripleValue(percent);
		System.out.println("After:percent="+percent);
		/*
		 * Test 2: Methods can change the state of object parameters
		 * 对象引用做参数。改变了参数的状态
		 * 执行过程为
		 *     x初始化为harry值的拷贝，这里是对象的引用
		 *     raiseSalary应用于这个对象的引用，x和harry同时引用的Employee薪水提高
		  *      方法结束，参数变量x不再使用，harry继续引用那个薪资三倍的雇员对象
		  *      
		  *  这个核心在于上调工资的程序是通过对象内部方法达成的
		 */
		System.out.println("\nTesting tripleSalary");
		Employee harry=new Employee("Harry",500);
		System.out.println("berfore:salary="+harry.getSalary());
		tripleSalary(harry);
		System.out.println("After:salary="+harry.getSalary());
		/*
		 * Test 3:Methods can't attach new objects to object parameters
		 * 发现这种swap方式并没卵用，交换的只是拷贝值
		 * 说明java不是引用调用，
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
