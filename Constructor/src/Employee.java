
import java.util.*;

public class Employee {
	private static int nextId=1;//��̬����
	private int id;
	//��ʽ���ʼ����Ϊÿ��ʵ��������һ��������ĳ�ֵ
	private String name="";//instance field initialization
	private double salary;
	
	/*
	 *��ʼ����
	 *��ʼ��������ķ�����
	 *    �ڹ�����������ֵ��
	 *    �����и�ֵ
	 *   ��ʼ������ƣ�ֻҪ������Ķ������ݿ飨���԰����������飩�ͻᱻִ��  
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
	//�����������京������Ķ��Ի����
	public Employee(String name,double salary) {
		this.name=name;
		this.salary=salary;
	}
	//������һ��������,���ַ����Թ������������벿��ֻ���дһ��
	public Employee(double salary) {
		//calls the Employee(String,double)constructor
		this("Employee#"+nextId,salary);
	}
	
	//�޲�������������״̬����Ĭ��ֵֵ������û���ṩ�κι�������ʱ��ϵͳ���ṩһ��Ĭ�ϵĹ�����
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
