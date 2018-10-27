package pair2;

public class Pair<T> {//泛型变量<T> java库中E表示集合的元素类型K,V表示关键字的值与类型
	private T first;
	private T second;
	public Pair(){first=null;second=null;}
	public Pair(T first,T second) {this.first=first;this.second=second;}
	
	public T getFirst() {return first;}
	public T getSecond() {return second;}
	
	public void setFirst(T newValue) { first=newValue;}
	public void setSecond(T newValue) {second=newValue;}
}