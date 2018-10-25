package stackTrace;
import java.util.*;
/*
 * �쳣
 * �������ʱ����Ӧ��
 *    ���ص�һ�ְ�ȫ״̬�������û�ִ����������
 *    �����û��������в�����������ʵ���ʽ��ֹ����
 * ���ܳ��ֵ���������
 *    �û��������
 *    �豸����
 *    ��������
 *    �������
 * �쳣����
 *    Throwable����
 *        Error:Java ����ʱϵͳ�ڲ��������Դ�ľ����󡣴�������֪�û�������ȫ��ֹ��������������
 *        Exception����IOException����һ�������ڵ��ļ��ж�ȡ���ݣ�Խ���ļ���β������ȡ������һ�������ڵ�URL
 *                 ����RuntimeException:���������ת�����������Խ�硣���ʿ�ָ��
 *     Java�쳣����
 *     Java�����쳣������ƣ����쳣����ĳ�����뼯����һ���������ĳ������ֿ���ʹ�ó����࣬������ά����
 *     try 
	�����쳣�ĵ�һ������try{��}����ѡ�������쳣�ķ�Χ�������ܳ����쳣�Ĵ������try�����С�
    catch (Exceptiontype e)
	��catch�������Ƕ��쳣������д���Ĵ��롣ÿ��try������԰���һ������catch��䣬
	���ڴ�����ܲ����Ĳ�ͬ���͵��쳣������tryû�����쳣������catch���
 *     try{...}  catch(IOEException e){....} catch(FileNotFoundException|UnknownHostException e){....} 
 *     
 *     �û��Զ����쳣��MyException��������������ȡֵ��Χ������Ϣ���û��Լ����쳣�����̳����е��쳣�ࡣ

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
 	          throw new MyException(������Ϊ��ֵ��������,3);
	else
	          System.out.println("�Ǽ�����" + num );
        }
        public void manager() {
 	try {
	           regist(100);
 	} catch (MyException e) {
 	           System.out.print("�Ǽ�ʧ�ܣ���������"+e.getId());	 	
	}
	System.out.print("���εǼǲ�������");
       }
       public static void main(String args[]){
	Test8_6 t = new Test8_6();
	t.manager();
       }
}


 *     
 * ���³��������ջ����Ԫ�أ�����������ֹ���쳣ʱ�Ϳ�����ʾ����
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
