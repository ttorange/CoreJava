package pair2;

public class Manager extends Employee{
	private double bonus;
	public Manager(String n,double s,int year,int month,int day) {
		super(n,s,year,month,day);//super�ڹ������е�ʹ��
		bonus=0;
	}
	
	public double getSalary() {
		double baseSalary=super.getSalary();//�޷�ֱ�ӷ���salary����Ҫͨ��super.getsalay���ʸ���ķ���
		return baseSalary+bonus;
	}
	public void setBonus(double b) {
		bonus=b;
	}
	public double getBonus() {
		return bonus;
	}

}
