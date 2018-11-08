package textFile;
import java.io.*;
import java.util.*;
/*
 * IO流分为字节流和字符流
 * 
 * 字节流：
 * Java中的字节流处理的最基本单位为单个字节，它通常用来处理二进制数据。
 * Java中最基本的两个字节流类是InputStream和OutputStream，它们分别代表了一组基本的输入字节流和输出字节流。
 * FileOutputStream(String name,boolean append)/(File file,boolean append)  
 * 由name字符串对象或file对象指定路径创建文件输出流
 * append为true数据将被添加到文件为，具有相同名字的文件不会删除，否则同名文件将被删除
 * 
 * 字符流：
 * Java中的字符流处理的最基本的单元是Unicode码元（大小2字节），它通常用来处理文本数据
 * PrintWriter(Writer out,boolean autoFush)
 * out:字符输出的写出器   autoflsh 为true则println 方法将冲刷输出缓冲区（默认false
 * flush()方法可以强迫输出流(或缓冲的流)发送数据，即使此时缓冲区还没有填满，以此来打破这种死锁的状态。
     当我们使用输出流发送数据时，当数据不能填满输出流的缓冲区时，这时，数据就会被存储在输出流的缓冲区中。
    如果，我们这个时候调用关闭(close)输出流，存储在输出流的缓冲区中的数据就会丢失。所
    以说，关闭(close)输出流时，应先刷新(flush)换冲的输出流，话句话说就是：“迫使所有缓冲的输出数据被写出到底层输出流中”。

 */

public class TextFileTest {

	public static void main(String[] args) throws IOException{
		Employee[] staff=new Employee[3];
		
		staff[0]=new Employee("Namny", 7500, 1998, 5, 7);
		staff[1]=new Employee("Halo", 1500, 1977, 6, 7);
		staff[2]=new Employee("NASA", 9500, 1999, 6, 12);
		
		//将employee类按一定格式输出，文件后缀无限制，可以在该目录下看到输出的文件
		try(PrintWriter out=new PrintWriter("employee.dat","UTF-8")){
			writeData(staff, out);
		}//将输出的文件根据其格式读取并显示出来
		try(Scanner in=new Scanner(
				new FileInputStream("employee.txt"),"UTF-8")){
			Employee[] newStaff=readData(in);
			for(Employee e:newStaff)
				System.out.println(e);
		}
		
		
		

	}
	public static void writeData(Employee[] employees,PrintWriter out)throws IOException
	{
		out.println(employees.length);
		for(Employee e: employees)
			writeEmployee(out,e);
	}
	
	private static Employee[] readData(Scanner in) {
		int n=in.nextInt();//读取员工个数
		in.nextLine();
		
		Employee[] employees=new Employee[n];
		for(int i=0;i<n;i++) {
			employees[i]=readEmployee(in);
		}
		return employees;
		}
	
	public static void writeEmployee(PrintWriter out,Employee e)
	{
		GregorianCalendar calendar=new GregorianCalendar();
		calendar.setTime(e.getHireDay());
		out.println(e.getName()+"|"+e.getSalary()+"|"+calendar.get(Calendar.YEAR)+"|"//此处写成out.print将会打乱格式导致错误
		+(calendar.get(Calendar.MONTH)+1)+"|"+calendar.get(Calendar.DAY_OF_MONTH));
	}
	//读取一行数据，进行分解
	public static Employee readEmployee(Scanner in) {
		String line=in.nextLine();
		String[] tokens=line.split("\\|");//这个要了解正则表达式
		String name=tokens[0];
		double salary=Double.parseDouble(tokens[1]);
		int year=Integer.parseInt(tokens[2]);
		int month=Integer.parseInt(tokens[3]);
		int day=Integer.parseInt(tokens[4]);
		return new Employee(name, salary, year, month, day);
	}

}
