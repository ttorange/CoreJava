package inheritance;
/*
 * 子类比超类（父类）更丰富的功能
 * 封装了更多数据和功能
 *     子类自动继承了父类的方法
 *     子类可以覆盖父类的方法
 *     子类不可以删除继承的任何域和方法
 *   调用父类的关键字：super，可以调用超类的方法。构造器（只能作为另一个构造器的第一句话）
 * 
 */

public class Manager extends Employee{
	private double bonus;
	public Manager(String n,double s,int year,int month,int day) {
		super(n,s,year,month,day);//super在构造器中的使用
		bonus=0;
	}
	/*
	 * (non-Javadoc)
	 * @see inheritance.Employee#getSalary()
	 * 重写父类的getsalary方法
	 * 
	 */
	public double getSalary() {
		double baseSalary=super.getSalary();//无法直接访问salary，需要通过super.getsalay访问父类的方法
		return baseSalary+bonus;
	}
	public void setBonus(double b) {
		bonus=b;
	}
	//子类equals方法先调用超类的equals，如果false。一定不相等，若成功然后检测子类中的实例域
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject))return false;
		Manager other=(Manager)otherObject;
		return bonus==other.bonus;
	}
	//重新定义了equals方法就必须重新定义hashCode方法以便用户可以将对象插到散列表中
	public int hashCode() {
		return super.hashCode()+17*new Double(bonus).hashCode();	
		}
	public String toString() {
		return super.toString()+"[bonus="+bonus+"]";
		}

}
