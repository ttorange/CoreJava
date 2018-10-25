package stackTrace;
import java.util.*;
/*
 * 异常
 * 处理错误时程序应该
 *    返回到一种安全状态，并让用户执行其他命令
 *    允许用户保存所有操作结果，以适当方式终止程序
 * 可能出现的问题类型
 *    用户输入错误
 *    设备错误
 *    物理限制
 *    代码错误
 * 异常分类
 *    Throwable——
 *        Error:Java 运行时系统内部错误和资源耗尽错误。此类错误告知用户尽力安全终止程序再无能无力
 *        Exception——IOException：从一个不存在的文件中读取数据，越过文件结尾继续读取，连接一个不存在的URL
 *                 ——RuntimeException:错误的类型转换，数组访问越界。访问空指针
 *     Java异常处理：
 *     Java采用异常处理机制，将异常处理的程序代码集中在一起，与正常的程序代码分开，使得程序简洁，并易于维护。
 *     try 
	捕获异常的第一步是用try{…}语句块选定捕获异常的范围，将可能出现异常的代码放在try语句块中。
    catch (Exceptiontype e)
	在catch语句块中是对异常对象进行处理的代码。每个try语句块可以伴随一个或多个catch语句，
	用于处理可能产生的不同类型的异常对象若try没捕获异常将跳过catch语句
 *     try{...}  catch(IOEException e){....} catch(FileNotFoundException|UnknownHostException e){....} 
 *     
 *     用户自定义异常类MyException，用于描述数据取值范围错误信息。用户自己的异常类必须继承现有的异常类。

class MyException extends Exception {
   	private int idnumber;
 	public MyException(String message, int id) {
		super(message);
		this.idnumber = id;
 	} 
	public int getId() {
		return idnumber;
 	}
}
public class Test8_6{
        public void regist(int num) throws MyException {
 	if (num < 0) 
 	          throw new MyException(“人数为负值，不合理”,3);
	else
	          System.out.println("登记人数" + num );
        }
        public void manager() {
 	try {
	           regist(100);
 	} catch (MyException e) {
 	           System.out.print("登记失败，出错种类"+e.getId());	 	
	}
	System.out.print("本次登记操作结束");
       }
       public static void main(String args[]){
	Test8_6 t = new Test8_6();
	t.manager();
       }
}


 *     
 * 以下程序分析堆栈跟踪元素，程序正常终止无异常时就可以显示出来
 */
public class StackTraceTest {
	public static int factorial(int n) {
		System.out.println("factorial("+n+"):");
		Throwable t=new Throwable();
		StackTraceElement[] frames=t.getStackTrace();
		for(StackTraceElement f:frames)
			System.out.println(f);
		int r = 0;
		if(n<=1)n=1;
		else r=n*factorial(n-1);
		System.out.println("return"+r);
		return r;
	}
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter n:");
		int n=in.nextInt();
		factorial(n);
	}

}
/*
 * Throwable(Throwable cause
 */
