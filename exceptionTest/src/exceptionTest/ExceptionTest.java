package exceptionTest;

public class ExceptionTest {

	public static void main(String[] args) {
		CargoBoat ship=new CargoBoat();
		ship.setMaxContent(1000);
		int m=600;
		try {
			ship.loading(m);;
			m=200;
			ship.loading(m);
			
			m=367;
			ship.loading(m);
			m=555;
			ship.loading(m);
		}
		catch(DangerException e) {
			System.out.println(e.warnMess());
			System.out.println("�޷�װ��"+m+"�ֵĻ���");
			
		}
		finally {//finallyʼ�ջ�ִ��
			System.out.println("�����������𺽣���");
			
		}

	}

}
