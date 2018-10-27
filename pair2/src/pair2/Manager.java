package pair2;

public class Manager extends Employee{
	private double bonus;
	public Manager(String n,double s,int year,int month,int day) {
		super(n,s,year,month,day);//super在构造器中的使用
		bonus=0;
	}
	
	public double getSalary() {
		double baseSalary=super.getSalary();//无法直接访问salary，需要通过super.getsalay访问父类的方法
		return baseSalary+bonus;
	}
	public void setBonus(double b) {
		bonus=b;
	}
	public double getBonus() {
		return bonus;
	}

}
