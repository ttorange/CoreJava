package pair;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PairTest {
	public static void main(String[] args) {
		GregorianCalendar[] birthdays= {
				new GregorianCalendar(1906,Calendar.DECEMBER,9),
				new GregorianCalendar(1997,Calendar.DECEMBER,10),
				new GregorianCalendar(1958,Calendar.DECEMBER,18),
				new GregorianCalendar(1988,Calendar.DECEMBER,25),
		};
		Pair<GregorianCalendar> mm=ArrayAlg.minmax(birthdays);
		System.out.println("min="+mm.getFirst().getTime());
		System.out.println("max="+mm.getSecond().getTime());
		
	}


}
class ArrayAlg{
	public static <T extends Comparable> Pair<T> minmax(T[] a){//将泛型实例化，泛型方法，泛型变量的限定（extend...）
		if(a==null||a.length==0)return null;
		T min=a[0];//
		T max=a[0];
		for(int i=1;i<a.length;i++) {
			if(min.compareTo(a[i])>0)min=a[i];
			if(max.compareTo(a[i])<0)max=a[i];
		}
		return new Pair<>(min,max);
	}
}
