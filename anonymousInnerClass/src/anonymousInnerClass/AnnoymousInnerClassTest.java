package anonymousInnerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class AnnoymousInnerClassTest {

	public static void main(String[] args) {
		TalkingClock clock=new TalkingClock();
		clock.start(1000, true);
		JOptionPane.showMessageDialog(null,"quit program?");
		System.exit(0);

	}
}
	class TalkingClock{
		public void start(int interval,final boolean beep) {//�ⲿ��������final
			ActionListener listener=new ActionListener() {//�����ڲ���
				
				@Override
				public void actionPerformed(ActionEvent event) {
					Date now=new Date();
					System.out.println("At the tone,the time is"+now);
					
				}
			};
			Timer t=new Timer(interval,listener);
			t.start();
		}
	

}
