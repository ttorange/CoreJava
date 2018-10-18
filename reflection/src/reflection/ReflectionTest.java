package reflection;

import java.lang.reflect.*;
import java.util.*;
/*反射
 *   能够分析类能力的程序称为反射，反射机制可以用来：
 *        在运行中分析类 的能力
 *        在运行中查看对象（如编写toString方法）
 *        实现通用的数组操作代码
 *       利用Method对象，类似指针的功能
 * Class类
 *   Java运行时系统为所有对象维护一个“运行时的类型标志”，该信息跟踪每一个对象所属的类
 *   
 *  捕获异常
 *  异常类型：
 *   未检查异常：检测是否为错误提供了处理器
 *   已检测异常：抛出检查异常，提供异常处理器
 * try ……catch（Exception e)
 * 
 * 
 * Class类常用方法
 *  Field[] getFields()//返回包含Field（域）对象的数组。这些对象记录了这个类或其超类的公有域
 *  Field[] getDeclareFields()//返回包含Field（域）对象的数组。这些对象记录了这个类型的全部域
 *  Method[] getMethods()/getDeclareMethods  //所有公用方法，包括从超类继承来的/这个类或接口的全部方法，不包括继承来的方法
 *  Constructor[] getConstructors()/getDeclareConstructors() 所有共有构造器/所有构造器 
 *  
 */
public class ReflectionTest {
    public static void main(String[] args) {
        String className;

        if (args.length > 0) {
            className = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter class name (e.g. java.util.Date):");
            className = scanner.next();
        }

        try {
            Class cl = Class.forName(className);
            Class superclass = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (!modifiers.isEmpty()) {
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + className);
            if (superclass != null && superclass != Object.class) {
                System.out.print(" extends " + superclass.getName() + " ");
            }
            System.out.println("{");
            printConstructors(cl);//打印构造器列表
            System.out.println();
            printMethods(cl);//打印方法
            System.out.println();
            printFields(cl);//打印文件位置
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printConstructors(Class cl) {
    	Constructor[] constructors=cl.getDeclaredConstructors();
    	//返回一个反映 Constructor对象表示的类声明的所有 Constructor对象的数组类 。
        for (Constructor c :constructors) {
            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (!modifiers.isEmpty()) {
                System.out.print(modifiers + " ");
            }
            System.out.print(c.getName() + "(");

            Class[] parameterTypes = c.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    private static void printMethods(Class cl) {
        for (Method method : cl.getDeclaredMethods()) {
            System.out.print("    ");
            String modifiers = Modifier.toString(method.getModifiers());//修饰符的字符串表示
            if (!modifiers.isEmpty()) {
                System.out.print(modifiers + " ");
            }
            System.out.print(method.getReturnType().getName() + " ");
            System.out.print(method.getName() + "(");

            Class[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    private static void printFields(Class cl) {
        for (Field field : cl.getDeclaredFields()) {
        	//返回 Field 对象的一个数组，该数组包含此 Class 对象所表示的类或接口所声明的所有字段（包括私有成员）
        	System.out.print("    ");
            String modifiers = Modifier.toString(field.getModifiers());
            if (!modifiers.isEmpty()) {
                System.out.print(modifiers + " ");
            }
            System.out.println(field.getType().getName() + " " + field.getName() + ";");
        }
    }
}