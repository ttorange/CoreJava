package inheritance;
/*
 * ����ȳ��ࣨ���ࣩ���ḻ�Ĺ���
 * ��װ�˸������ݺ͹���
 *     �����Զ��̳��˸���ķ���
 *     ������Ը��Ǹ���ķ���
 *     ���಻����ɾ���̳е��κ���ͷ���
 *   ���ø���Ĺؼ��֣�super�����Ե��ó���ķ�������������ֻ����Ϊ��һ���������ĵ�һ�仰��
 * 
 */

public class Manager extends Employee{
	private double bonus;
	public Manager(String n,double s,int year,int month,int day) {
		super(n,s,year,month,day);//super�ڹ������е�ʹ��
		bonus=0;
	}
	/*
	 * (non-Javadoc)
	 * @see inheritance.Employee#getSalary()
	 * ��д�����getsalary����
	 * 
	 */
	public double getSalary() {
		double baseSalary=super.getSalary();//�޷�ֱ�ӷ���salary����Ҫͨ��super.getsalay���ʸ���ķ���
		return baseSalary+bonus;
	}
	public void setBonus(double b) {
		bonus=b;
	}
	//����equals�����ȵ��ó����equals�����false��һ������ȣ����ɹ�Ȼ���������е�ʵ����
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject))return false;
		Manager other=(Manager)otherObject;
		return bonus==other.bonus;
	}
	//���¶�����equals�����ͱ������¶���hashCode�����Ա��û����Խ�����嵽ɢ�б���
	public int hashCode() {
		return super.hashCode()+17*new Double(bonus).hashCode();	
		}
	public String toString() {
		return super.toString()+"[bonus="+bonus+"]";
		}

}
