import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/*@author Cay Horstman
 * ����
 * ��������⣺
 *    ·�ɶ�Զ�̷������ķ�������
 *    �ڳ��������ڼ佫�û��ӿ��¼��붯����������
 *    ��Ϊ���ԣ����ٷ�������
 * �˶δ��뷴Ӧ���ֲ��ҵľ������
 * 
 * �����������й����д����ġ�һ�������ͱ���˳�����
 * ���еĴ����඼��չ��Proxy��ÿһ������ֻ��һ��ʵ���򡪡����ô�����
 */
public class ProxyTest {
	public static void main(String[] args) {
		Object[] elements=new Object[100];
		for(int i=0;i<elements.length;i++) {
			Integer value=i+1;
			InvocationHandler handler=new TraceHandler(value);
			//����һ��ʵ��ָ���ӿڵĴ������ʵ���������з����������ø����������������invoke����
			Object proxy=Proxy.newProxyInstance(null, new Class[] {Comparable.class},handler);
			elements[i]=proxy;
		}
		Integer key=new Random().nextInt(elements.length)+1;
		int result=Arrays.binarySearch(elements,key);
		if(result>=0)System.out.println(elements[result]);
	}
}
/*
 * an invocation handler that prints out the method name and parameters,then invokes the original method
 */
class TraceHandler implements InvocationHandler{
	private Object target;
	public TraceHandler(Object t) {
		target=t;
	}

	@Override
	//�����˴��������÷���ʱϣ��ִ�еĶ���
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		System.out.print(target);
		System.out.print("."+m.getName()+"(");
		if(args!=null)
		{
			for(int i=0;i<args.length;i++) {
				System.out.print(args[i]);
				if(i<args.length-1)System.out.print(",");
			}
		}
		System.out.println(")");
		return m.invoke(target, args);
	}
}
