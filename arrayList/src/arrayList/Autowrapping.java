package arrayList;

import java.util.ArrayList;
/*
 * �����װ�����Զ�װ��
 *     ���������Ͱ�װ�ɶ��� �� Integer Double,Void Boolean
 *     ��һ��Integer���󸳸�һ��intֵʱ�����Զ����䣬�Ƚ�ʱ��equals����
 *     int intValue() ��int��ʽ�Ż�Integer��ֵ
 *     static String toString(int i)  ��һ����String�������ʽ��ָ����ֵi��ʮ���Ʊ�ʾ
 */
public class Autowrapping {
	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(3);
		for(Integer a:list)
			System.out.println(a);
		
		
		Integer x;
		x=9;//Integer x=new Integer(9)�˷�����java 9����������
		String i=x.toString();
		System.out.println(x+i);
		
	}

}
