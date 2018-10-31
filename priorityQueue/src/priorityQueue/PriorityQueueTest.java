package priorityQueue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

//优先队列 priority queue
public class PriorityQueueTest {//按照元素优先级删除（年份由小到大）

	public static void main(String[] args) {
		PriorityQueue<GregorianCalendar> pq=new PriorityQueue<>();
		pq.add(new GregorianCalendar(1906,Calendar.DECEMBER,9));
		pq.add(new GregorianCalendar(1815,Calendar.DECEMBER,10));
		pq.add(new GregorianCalendar(1903,Calendar.DECEMBER,3));
		pq.add(new GregorianCalendar(1910,Calendar.AUGUST,22));
		
		System.out.println("Iterating over elements...");
		for(GregorianCalendar date:pq)
			System.out.println(date.get(Calendar.YEAR));
		System.out.println("Removing elements...");
		while(!pq.isEmpty())
			System.out.println(pq.remove().get(Calendar.YEAR));

	}

}
