package innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

/*
 * �ڲ���
 *    �Ƕ�������һ�����е���
 *    Ϊ��ʹ���ڲ��ࣿ
 *        �ڲ���ķ������Է��ʸ������������ڵ��������ص����ݣ�����˽������
 *        �ڲ�����Զ�ͬһ�����е���������������
 *        ����Ҫ����һ���ص������в����д��������ʱ��ʹ�������ڲ���Ƚϱ��
 *  
 * ΪʲôҪʹ���ڲ��ࣿ�ڡ�Think in java����������һ�仰��
 * ʹ���ڲ����������˵�ԭ���ǣ�ÿ���ڲ��඼�ܶ����ؼ̳�һ�����ӿڵģ�ʵ�֣�
 * ����������Χ���Ƿ��Ѿ��̳���ĳ�����ӿڵģ�ʵ�֣������ڲ��඼û��Ӱ�졣

      �����ǳ����������ʱ������һЩʹ�ýӿں��ѽ�������⣬
      ���ʱ�����ǿ��������ڲ����ṩ�ġ����Լ̳ж������Ļ��߳������������������Щ����������⡣
      ��������˵���ӿ�ֻ�ǽ���˲������⣬���ڲ���ʹ�ö��ؼ̳еĽ��������ø���������
 */
public class InnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock=new TalkingClock(1000, true);
		clock.start();
		JOptionPane.showMessageDialog(null,"Quit program?");
		System.exit(0);
		
	}

}
//�ֲ��಻����public����private�����������������޶�������ֲ���Ŀ���
class TalkingClock{
	private int interval;
	private boolean beep;
	
	public TalkingClock(int interval,boolean beep) {
		this.interval=interval;
		this.beep=beep;
	}
	
	public void start() {
		ActionListener listener=new TimePrinter();//ͨ������ֲ���ʹ֮��������أ�û�б�ķ���֪��Timeprinter�Ĵ���
		javax.swing.Timer t=new javax.swing.Timer(interval, listener);
		t.start();
	}
	public class TimePrinter implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Date now=new Date();
			System.out.println("At the tone,the time is"+now);
			if(beep) Toolkit.getDefaultToolkit().beep();		}
	}
}