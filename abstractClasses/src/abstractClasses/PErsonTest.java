package abstractClasses;
/*
 * ��ý����е�������Ϊprivate ���������Ϊpublic
 *    ��ϣ�������е�ĳЩ�������������������Щ��������Ϊprotected
 */
public class PErsonTest {
	public static void main(String[] args) {
		Person[] people=new Person[2];
		people[0]=new Employee("Harry Hacker",5000,1998,12,25);
		people[1]=new Student("Jobs","CS");
		
		for(Person e:people)
			System.out.println(e.getName()+"  "+e.getDescription());
		//������󷽷���û�ж���getDesc����e.getDesc���޷����ã���Ϊ������ֻ������������������ķ���
		
	}

}
