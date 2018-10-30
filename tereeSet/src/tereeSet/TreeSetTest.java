package tereeSet;
import java.util.*;

public class TreeSetTest {

	public static void main(String[] args) {
		SortedSet<Item> parts=new TreeSet<>();//写为 Treeset<Item> parts=new TreeSet<> 也可以
		parts.add(new Item("Toaster",1234));
		parts.add(new Item("Widget",4562));
		parts.add(new Item("Modem",9912));
		System.out.println(parts);
		
		SortedSet<Item>sortByDesription=new TreeSet<>(new Comparator<Item>() {
			public int compare(Item a,Item b) {
				String descrA=a.getDescription();
				String descrB=b.getDescription();
				return descrA.compareTo(descrB);
			}
		});
		sortByDesription.addAll(parts);
		System.out.println(sortByDesription);
		

	}

}
