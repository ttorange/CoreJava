package arrayList;
/*
 * 泛型数组列表
 *   ArrayList：动态数组，自动调节数组容量
 *         ArrayList<T>()构造空数组列表
 *         ArrayList<T>(int initialCapacity)指定初始容量的数组列表
 *         int size()返回容量
 *         boolean add(T obj)尾端添加一个元素
 *         void trimTosize()将数组列表的存储容量削减到当前尺寸
 *         staff.set(i,harry)设置元素。staff
 *         .get(i)访问元素
 *     ArrayList 实际上是通过一个数组去保存数据的。
 *         当我们构造ArrayList时；若使用默认构造函数，则ArrayList的默认容量大小是10。
 *     
 *     ArrayList实现源码
 *     
 *          public ArrayList() {
 *         this(10);
 *     }
 * 
      // 创建一个包含collection的ArrayList
      public ArrayList(Collection<? extends E> c) {
          elementData = c.toArray();
          size = elementData.length;
          // c.toArray might (incorrectly) not return Object[] (see 6260652)
          if (elementData.getClass() != Object[].class)
              elementData = Arrays.copyOf(elementData, size, Object[].class);
      }
 
 */
import java.util.ArrayList;

public class AraryListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> staff=new ArrayList<>();
		staff.add(new Employee("Carl",7000,1899,10,1));
		staff.add(new Employee("Jobs",8000,1969,4,1));
		staff.add(new Employee("Xiaobo",1000,1989,6,4));
		for(Employee e:staff)
			e.raiseSalary(5);
		for(Employee e:staff)
			System.out.println("name="+e.getName()+"salary="+e.getSalary()+"hireDay="+e.getHireDay());

	}

}
