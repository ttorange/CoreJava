package simpleframe;
import java.awt.*;
import javax.swing.*;
//图形程序设计Swing概述
public class SimpleFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame=new NothelloWorldFrame();
				frame.setTitle("notHelloWorld");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);				
			}
		});
	}
	
}
class NothelloWorldFrame extends JFrame{
	public NothelloWorldFrame() {
		add(new NotHelloworldComponent());
		pack();
	}
}


class NotHelloworldComponent extends JComponent{
	public static final int MESSAGE_X=75;
	public static final int MESSAGE_Y=100;
	public static final int DEFAULT_WIDTH=100;
	public static final int DEFSULT_HEIGHT=100;
	public void paintComponent(Graphics g) {
		g.drawString("not a hello world program", MESSAGE_X, MESSAGE_Y);
	}
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFSULT_HEIGHT);
	}
}
