/*Core java 示例程序的实现
 *章节：4——1
 *    预定义类的使用，Date类，GreGorianCalen类
 *    对象与对象变量，通过构造器构造新实例
 *    更改器方法与访问器方法，通过get方法得到数据，set方法设置变量值
 * 功能：打印本月日历
 * 
 * 
 * 
 * 
 * 
 * 
 */
import java.text.DateFormatSymbols;
import java.util.*;
public class CalendarTest {
	public static void main(String args[]) {
		
		Locale.setDefault(Locale.US);//set local
		
		//construct d as current date
		GregorianCalendar d= new GregorianCalendar();
		int today=d.get(Calendar.DAY_OF_MONTH);
		int month=d.get(Calendar.MONTH);
		
		//set d to start date of the month
		d.set(Calendar.DAY_OF_MONTH,1);
		int weekday= d.get(Calendar.DAY_OF_WEEK);
		
		//get first day of week(SUnday in the US)
		int firstDayOfWeek=d.getFirstDayOfWeek();
		
		//determine the required indentation for the first line
		int indent =0;
		while(weekday!=firstDayOfWeek) {
			indent++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
		}
		//print weekday names
		String[] weekdayNames=new DateFormatSymbols().getShortWeekdays();
		do {
			System.out.printf("%4s",weekdayNames[weekday]);
			d.add(Calendar.DAY_OF_MONTH,1);
			weekday=d.get(Calendar.DAY_OF_WEEK);	
		}
		while(weekday!=firstDayOfWeek);
		
		//控制首行缩进
		System.out.println();
		for(int i=1;i<=indent;i++)
			System.out.printf("    ");
		d.set(Calendar.DAY_OF_MONTH,1);
		do {
			//print day
			int day=d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d",day);
			//mark current day with
			if(day==today) System.out.printf("*");
			else System.out.printf(" ");
			
			//advance d to the next day
			d.add(Calendar.DAY_OF_WEEK,1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
			
			//start a new line at the start of the week
			if(weekday==firstDayOfWeek)System.out.println();			
		}
		while(d.get(Calendar.MONTH)==month);
		//the loop exits when day 1 of the next month
		
		//print final end of line if necessary
		if(weekday!=firstDayOfWeek)System.out.println();
	}
	

}
