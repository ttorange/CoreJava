package reflection;

import java.lang.reflect.*;
import java.util.*;
/*����
 *   �ܹ������������ĳ����Ϊ���䣬������ƿ���������
 *        �������з����� ������
 *        �������в鿴�������дtoString������
 *        ʵ��ͨ�õ������������
 *       ����Method��������ָ��Ĺ���
 * Class��
 *   Java����ʱϵͳΪ���ж���ά��һ��������ʱ�����ͱ�־��������Ϣ����ÿһ��������������
 *   
 *  �����쳣
 *  �쳣���ͣ�
 *   δ����쳣������Ƿ�Ϊ�����ṩ�˴�����
 *   �Ѽ���쳣���׳�����쳣���ṩ�쳣������
 * try ����catch��Exception e)
 * 
 * 
 * Class�ೣ�÷���
 *  Field[] getFields()//���ذ���Field���򣩶�������顣��Щ�����¼���������䳬��Ĺ�����
 *  Field[] getDeclareFields()//���ذ���Field���򣩶�������顣��Щ�����¼��������͵�ȫ����
 *  Method[] getMethods()/getDeclareMethods  //���й��÷����������ӳ���̳�����/������ӿڵ�ȫ���������������̳����ķ���
 *  Constructor[] getConstructors()/getDeclareConstructors() ���й��й�����/���й����� 
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
            printConstructors(cl);//��ӡ�������б�
            System.out.println();
            printMethods(cl);//��ӡ����
            System.out.println();
            printFields(cl);//��ӡ�ļ�λ��
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printConstructors(Class cl) {
    	Constructor[] constructors=cl.getDeclaredConstructors();
    	//����һ����ӳ Constructor�����ʾ�������������� Constructor����������� ��
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
            String modifiers = Modifier.toString(method.getModifiers());//���η����ַ�����ʾ
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
        	//���� Field �����һ�����飬����������� Class ��������ʾ�����ӿ��������������ֶΣ�����˽�г�Ա��
        	System.out.print("    ");
            String modifiers = Modifier.toString(field.getModifiers());
            if (!modifiers.isEmpty()) {
                System.out.print(modifiers + " ");
            }
            System.out.println(field.getType().getName() + " " + field.getName() + ";");
        }
    }
}