package pair2;

public class PairTest2 {
	public static void main(String[] args) {
		Manager ceo=new Manager("Gus", 80000, 2008, 12, 15);
		Manager cfo=new Manager("Bob", 60000, 2001, 12, 15);
		Pair<Manager> buddies=new Pair<>(ceo,cfo);
		printBuddies(buddies);
		
		ceo.setBonus(1000);
		cfo.setBonus(800);
		Manager[] managers= {ceo,cfo};
		
		Pair<Employee>result=new Pair<>();
		minmaxBonus(managers,result);
		System.out.println("first:"+result.getFirst().getName()+",second:"+result.getSecond().getName());
		maxminBonus(managers, result);
		System.out.println("first:"+result.getFirst().getName()+",second:"+result.getSecond().getName());
		
	}
	public static void printBuddies(Pair<? extends Employee> p) {
		//�����޶�������ʹ�÷���ֵ������Ϊ�����ṩ����
		Employee first=p.getFirst();
		Employee second=p.getSecond();
		System.out.println(first.getName()+" and "+second.getName()+" are buddies");
	}

	public static void minmaxBonus(Manager[] a,Pair<? super Manager>result) {
		//�����޶�������Ϊ�����ṩ����������ʹ���䷵��ֵ
		if(a==null||a.length==0)return;
		Manager min=a[0];
		Manager max=a[0];
		for(int i=1;i<a.length;i++) {
			if(min.getBonus()>a[i].getBonus())min=a[i];
			if(max.getBonus()<a[i].getBonus())max=a[i];
		}
		result.setFirst(min);
		result.setSecond(max);
	}
	public static void maxminBonus(Manager[] a,Pair<? super Manager>result) {
		minmaxBonus(a,result);
		 PairAlg.swapHelper(result);
	}

}
class PairAlg{
	public static boolean hasNulls(Pair<?> p) {//���޶�ͨ���
		return p.getFirst()==null||p.getSecond()==null;
	}
	public static void swap(Pair<?>p) {swapHelper(p);}
	public static  <T> void swapHelper(Pair<T> p) {//ͨ�������
		T t=p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(t);
	}

}