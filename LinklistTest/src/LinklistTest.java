import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//将两个链表合并，将第二个链表间隔删除

public class LinklistTest {

	public static void main(String[] args) {
		
		List<String> a=new LinkedList<>();
		a.add("Amy");
		a.add("Cat");
		a.add("Dog");
		
		List<String>b=new LinkedList<>();
		b.add("Panda");
		b.add("Monkey");
		b.add("Nanny");
		b.add("Tb");
		
		//merge the words from b into a
		ListIterator<String>aIter=a.listIterator();
		Iterator<String>bIter=b.listIterator();
		
		while(bIter.hasNext()) {
			if(aIter.hasNext())aIter.next();
			aIter.add(bIter.next());
		}
		System.out.println(a);
		
		bIter=b.iterator();
		//remove every second word from b
		while(bIter.hasNext()) {
			bIter.next();
			if(bIter.hasNext()) {
				bIter.next();
				bIter.remove();
			}	
		}
		System.out.println(b);
		//bulk operation:remove all words in b from a
		a.remove(b);
		System.out.println(a);

	}

}
