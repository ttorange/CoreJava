package abstractClasses;
/*
 * ������
 *   �̳����У��ϲ������ͨ����
 *   ���󷽷��䵱��վλ�Ľ�ɫ��������Զ���ȫ�����󷽷����������Ͳ��ǳ������
 *   �������û�ж���ȫ�����󷽷�����ô����Ȼ�ǳ�����
 *   �಻�����󷽷�Ҳ���Զ���Ϊ������
 *   �����಻�ܱ�ʵ����������new person("Swift")���ᱨ��
 */
public abstract class Person {
	public abstract String getDescription();//���󷽷�
	private String name;
	public Person(String n) {
		name=n;
	}
	public String getName() {
		return name;
	}

}
