package enums;
/*
 * ö����
 *    ������ȡֵֻ�������޵ļ�����
 */
import java.util.Scanner;

public class EnumTest {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter a size:SMALL��MEDIUM��LARGE...");
		String input=in.next().toUpperCase();
		Size size=Enum.valueOf(Size.class,input);
		System.out.println("size="+size);
		System.out.println("abbreviation="+size.getAbbreviation());
		if(size==Size.EXTRA_LARGE)
			System.out.println("Good job you paid  attention to the _.");
		in.close();
		
		Size[] value=Size.values();//���ذ�enum������Ԫ�ص�����
		for(Size v:value)
			System.out.println(v);
	}
	
	
		
}
enum Size{
	
	SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
	private Size(String abbreviation) {this.abbreviation=abbreviation;}
	public String getAbbreviation() {return abbreviation;}
	private String abbreviation;

	
}
