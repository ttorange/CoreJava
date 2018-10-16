package enums;
/*
 * 枚举类
 *    变量的取值只能在有限的集合内
 */
import java.util.Scanner;

public class EnumTest {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter a size:SMALL，MEDIUM，LARGE...");
		String input=in.next().toUpperCase();
		Size size=Enum.valueOf(Size.class,input);
		System.out.println("size="+size);
		System.out.println("abbreviation="+size.getAbbreviation());
		if(size==Size.EXTRA_LARGE)
			System.out.println("Good job you paid  attention to the _.");
		in.close();
		
		Size[] value=Size.values();//返回包enum中所有元素的数组
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
