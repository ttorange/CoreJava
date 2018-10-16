package arrayList;
/*
 * ���������б�
 *   ArrayList����̬���飬�Զ�������������
 *         ArrayList<T>()����������б�
 *         ArrayList<T>(int initialCapacity)ָ����ʼ�����������б�
 *         int size()��������
 *         boolean add(T obj)β�����һ��Ԫ��
 *         void trimTosize()�������б�Ĵ洢������������ǰ�ߴ�
 *         staff.set(i,harry)����Ԫ�ء�staff
 *         .get(i)����Ԫ��
 *     ArrayList ʵ������ͨ��һ������ȥ�������ݵġ�
 *         �����ǹ���ArrayListʱ����ʹ��Ĭ�Ϲ��캯������ArrayList��Ĭ��������С��10��
 *     
 *     ArrayListʵ��Դ��
 *     
 *          public ArrayList() {
 *         this(10);
 *     }
 * 
      // ����һ������collection��ArrayList
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
