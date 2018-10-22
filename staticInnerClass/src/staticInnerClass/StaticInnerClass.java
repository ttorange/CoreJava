package staticInnerClass;
/*
 * 在Java中，允许一个类的定义位于另一个类的内部，前者称为内部类
内部类和外层封装它的类之间存在逻辑上的所属关系
Inner class一般用在定义它的类或语句块之内，在外部引用它时必须给出完整的名称。
 Inner class的名字不能与包含它的类名相同；
Inner class可以使用包含它的类的静态和实例成员变量，也可以使用它所在方法的局部变量；

Inner class可以声明为抽象类 ，因此可以被其它的内部类继承。也可以声明为final的。
和外层类不同，Inner class可以声明为private或protected；
Inner class 可以声明为static的，但此时就不能再使用外层封装类的非static的成员变量；
非static的内部类中的成员不能声明为static的，只有在顶层类或static的内部类中才可声明static成员；


 */
public class StaticInnerClass {
	public static void main(String[] args) {
		double[] d=new double[20];
		for(int i=0;i<d.length;i++)
			d[i]=100*Math.random();
		ArrayAlg.Pair p=ArrayAlg.minmax(d);
		System.out.println("max="+p.getSecond());
		System.out.println("min="+p.getFirst());
		
	}
}
	
	class ArrayAlg{
		public static class Pair
		{
			private double first;
			private double second;
			
			public Pair(double f,double s) {
				first=f;
				second=s;
			}
			//return the first number of the pair
			public double getFirst() {
				return first;
			}
			//return second
			public double getSecond() {
				return second;
			}
		}
		
		/*computes both the minimum and the maximum of an array
		 * @param values an array of floating-point number
		 * @return a pair whose first element is the minimum and whose second element is the maximum
		 */
		public static Pair minmax(double[] values) {
			double min=Double.MAX_VALUE;
			double max=Double.MIN_VALUE;
			for(double v:values) {
				if(min>v)min=v;
				if(max<v)max=v;
			}
			return new Pair(min,max);
		}
}


