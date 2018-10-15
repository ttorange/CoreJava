
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * �����Ƽ��ɣ�
 *     1��֤����˽��
 *     2Ҫ�����ݽ��г�ʼ�����ṩĬ��ֵ��
 *     3��Ҫ������ʹ�ù���������ͣ����罫Customer���е�street��city���ݴ����һ��Address�ࣩ
 *     4�������е���Ҫ��������������͸�����
 *     5��ְ����������зֽ⣨����ϣ���һ����ϸ�ֳɶ���࣬��Ҫ��һ��������̫�Ӵ�
 *     6�����ͷ�����Ҫ����������ְ�� 
 */
public class Employee {
	private static int nextId=1;//��̬����
	private int id;
	
	private String name;   //Ϊ�˱�֤���󹹽��󲻻ᱻ�ı������final�ؼ���
	//���� private final String name;
	private double salary;
	private Date hireDay;//�˴����ܸ�hireDay����final��String�ǲ��ɱ��࣬Date�ǿɱ��࣬final����ɻ���
	
	/*һ�����������ĸ�������private��ֻ֤������ķ������Է��ʸ����ݣ�����������ͬ��
	ע��㣺����������ͬ��
	         ÿ���������һ�����ϵĹ�����
	       �����������ж������
	     ������û�з���ֵ
	     ���������ǰ�����new����һ�����
	     
	*/
	public Employee(String n,double s,int year,int month,int day) {
		//��Ҫ�ڹ������ж�����ʵ���������ľֲ�����
		name=n;//����˴� д�� String name=n;  double salary=s;��������������εĴ�����Ϊ֮ǰ�Ѿ������
		salary=s;
		id=0;
		GregorianCalendar calendar=new GregorianCalendar(year,month-1,day);//Gregoriancalendar uses 0 for January
		hireDay=calendar.getTime();
	}
	
	/*������������ֻ����ʵ����ֵ
	 *ͨ���˷�����װ����
	 *�˴�name��������ֻ���ġ�һ��������Ͼ��޷����޸�salaryֻ��ͨ��raiseSalary�����޸�
	 *ͨ����û�����һ��ʵ����ֵ��Ҫ������Ϊ��
	 *     1һ��˽�е�������  2һ�����е��������3  һ�����е������������
	 *  ���������ô���  
	 *    �ı��ڲ�ʵ��ʱ����Ӱ���������� ���� name���ݸĳ� firstname  ��  lastname����ʱֻ��ı�getname�ĳ���
	 *    �����������������ô�������򣬱��� setsalary ��salary<0ʱ����
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
	/*��̬���������������ʵ��ʵʩ�����ķ����������൫��������Ķ���ķ���
	 *    ���硣Math���pow����   Math.pow(x,a)
	 *         ����x��a�η���
	 *         ����ʱ�������κ�Math���󣨼�û����ʽ������
	 *  ��̬�������ܲ����������Բ����ٽ�̩�����з���ʵ���򡣵��ǿ��Է����������еľ�̬��
	 *  
	 * ��̬������ʹ�ó���
	 *     һ����������Ҫ���ʶ���״̬���������������ʽ�����ṩ
	 *     һ������ֻ��Ҫ���ʾ�̬��
	 *   ��̬������ʹ�ý϶� ����Math�е�Pi
	 *         �˴�nextIdΪ��̬����,
	 *             ������100��ʵ�����ͻ���100��id����ֻ��1��nextId��û��ʵ��ʱҲ����һ��nextId
	*/
	public static int getNExtID() {
		return nextId;//nextId Ϊ��̬��
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
		this.salary+=raise;//����ʱ  e.raiseSalary(5) ������ǰ�Ķ���Ϊ��ʽ�����������е�ֵΪ��ʽ����
		              //��this��ʾ��ʽ����,�������԰Ѿֲ�������ʵ�������Ե�������� 
	}
	public static int getNextId() {
		return nextId;//returns static fiedld
	}
	//ÿ���඼������һ��main�����������ڲ��ԣ����������ڳ�����ʱ����main����ִ��
	public static void main(String[] args) {
		Employee e=new Employee("tong",16500, 2018, 12, 8);
		System.out.println(e.getName()+"   "+e.getSalary());
	}
}
