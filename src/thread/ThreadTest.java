package thread;
/*参考自CSDN博客
 * 
 * 作者：Evankaka 
    来源：CSDN 
   原文：https://blog.csdn.net/Evankaka/article/details/44153709 
 */

public class ThreadTest {
public static void main(String[] args) {
		
		ThreadYield yt1 = new ThreadYield("A");
    	ThreadYield yt2 = new ThreadYield("BB");
        yt1.start();
        yt2.start();
	}



}
/*   Thread.yield()方法作用是：暂停当前正在执行的线程对象，并执行其他线程。
    yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。
      因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
      但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。

    sleep()和yield()的区别):sleep()使当前线程进入停滞状态，所以执行sleep()的线程在指定的时间内肯定不会被执行；
    yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。
*/
class ThreadYield extends Thread{
    public ThreadYield(String name) {
        super(name);
    }
 
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为10时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i ==10) {
                this.yield();
            }
        }
	
}
}

