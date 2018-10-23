import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/*@author Cay Horstman
 * 代理
 * 解决的问题：
 *    路由对远程服务器的方法调用
 *    在程序运行期间将用户接口事件与动作关联起来
 *    作为调试，跟踪方法调用
 * 此段代码反应二分查找的具体过程
 * 
 * 代理是在运行过程中创建的。一旦创建就变成了常规类
 * 所有的代理类都扩展于Proxy类每一个代理只有一个实例域——调用处理器
 */
public class ProxyTest {
	public static void main(String[] args) {
		Object[] elements=new Object[100];
		for(int i=0;i<elements.length;i++) {
			Integer value=i+1;
			InvocationHandler handler=new TraceHandler(value);
			//构造一个实现指定接口的代理类的实例，将所有方法都将调用给给定处理器对象的invoke方法
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
	//定义了代理对象调用方法时希望执行的动作
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
