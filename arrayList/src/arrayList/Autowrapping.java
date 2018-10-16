package arrayList;

import java.util.ArrayList;
/*
 * 对象包装器域自动装箱
 *     将基本类型包装成对象 如 Integer Double,Void Boolean
 *     将一个Integer对象赋给一个int值时，会自动拆箱，比较时用equals方法
 *     int intValue() 以int形式放回Integer的值
 *     static String toString(int i)  以一个新String对象的形式返指定数值i的十进制表示
 */
public class Autowrapping {
	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(3);
		for(Integer a:list)
			System.out.println(a);
		
		
		Integer x;
		x=9;//Integer x=new Integer(9)此方法在java 9以来被弃用
		String i=x.toString();
		System.out.println(x+i);
		
	}

}
