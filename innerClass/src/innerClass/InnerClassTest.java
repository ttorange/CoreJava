package innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

/*
 * 内部类
 *    是定义在另一个类中的类
 *    为何使用内部类？
 *        内部类的方法可以访问该类所定义所在的作用域重点数据，包括私有数据
 *        内部类可以对同一个包中的其他类隐藏起来
 *        当想要定义一个回调函数切不想编写大量代码时，使用匿名内部类比较便捷
 *  
 * 为什么要使用内部类？在《Think in java》中有这样一句话：
 * 使用内部类最吸引人的原因是：每个内部类都能独立地继承一个（接口的）实现，
 * 所以无论外围类是否已经继承了某个（接口的）实现，对于内部类都没有影响。

      在我们程序设计中有时候会存在一些使用接口很难解决的问题，
      这个时候我们可以利用内部类提供的、可以继承多个具体的或者抽象的类的能力来解决这些程序设计问题。
      可以这样说，接口只是解决了部分问题，而内部类使得多重继承的解决方案变得更加完整。
 */
public class InnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock=new TalkingClock(1000, true);
		clock.start();
		JOptionPane.showMessageDialog(null,"Quit program?");
		System.exit(0);
		
	}

}
//局部类不能用public或者private声明，它的作用域被限定在这个局部类的块中
class TalkingClock{
	private int interval;
	private boolean beep;
	
	public TalkingClock(int interval,boolean beep) {
		this.interval=interval;
		this.beep=beep;
	}
	
	public void start() {
		ActionListener listener=new TimePrinter();//通过定义局部类使之对外界隐藏，没有别的方法知道Timeprinter的存在
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