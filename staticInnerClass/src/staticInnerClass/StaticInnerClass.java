package staticInnerClass;
/*
 * ��Java�У�����һ����Ķ���λ����һ������ڲ���ǰ�߳�Ϊ�ڲ���
�ڲ��������װ������֮������߼��ϵ�������ϵ
Inner classһ�����ڶ��������������֮�ڣ����ⲿ������ʱ����������������ơ�
 Inner class�����ֲ������������������ͬ��
Inner class����ʹ�ð���������ľ�̬��ʵ����Ա������Ҳ����ʹ�������ڷ����ľֲ�������

Inner class��������Ϊ������ ����˿��Ա��������ڲ���̳С�Ҳ��������Ϊfinal�ġ�
������಻ͬ��Inner class��������Ϊprivate��protected��
Inner class ��������Ϊstatic�ģ�����ʱ�Ͳ�����ʹ������װ��ķ�static�ĳ�Ա������
��static���ڲ����еĳ�Ա��������Ϊstatic�ģ�ֻ���ڶ������static���ڲ����вſ�����static��Ա��


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


