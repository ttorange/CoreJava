package synch;
import java.util.*;
/*
 * 声明synchronized关键字对象锁将保护整个方法
 *     synchronized关键字的作用域有二种： 
1）是某个对象实例内，synchronized aMethod(){}可以防止多个线程同时访问这个对象的synchronized方法
（如果一个对象有多个synchronized方法，只要一个线程访问了其中的一个synchronized方法，其它线程不能同时访问这个对象中任何一个synchronized方法）。
这时，不同的对象实例的synchronized方法是不相干扰的。也就是说，其它线程照样可以同时访问相同类的另一个对象实例中的synchronized方法； 
2）是某个类的范围，synchronized static aStaticMethod{}防止多个线程同时访问这个类中的synchronized static 方法。
它可以对类的所有对象实例起作用。 

2、除了方法前用synchronized关键字，synchronized关键字还可以用于方法中的某个区块中，表示只对这个区块的资源实行互斥访问。用法是: synchronized(this){/*区块}，它的作用域是当前对象； 

3、synchronized关键字是不能继承的，也就是说，基类的方法synchronized f(){} 在继承类中并不自动是synchronized f(){}，而是变成了f(){}。继承类需要你显式的指定它的某个方法为synchronized方法； 


 * wait方法和notifyAll等价于awit和signalAll方法
 * 
 * volatile关键字
 *    在访问volatile变量时不会执行加锁操作，因此也就不会使执行线程阻塞，因此volatile变量是一种比sychronized关键字更轻量级的同步机制。
 *    当对非 volatile 变量进行读写的时候，每个线程先从内存拷贝变量到CPU缓存中。如果计算机有多个CPU，每个线程可能在不同的CPU上被处理，这意味着每个线程可以拷贝到不同的 CPU cache 中。

       而声明变量是 volatile 的，JVM 保证了每次读变量都从内存中读，跳过 CPU cache 这一步。

当一个变量定义为 volatile 之后，将具备两种特性：

　　1.保证此变量对所有的线程的可见性（每次使用肯定是最新值！），这里的“可见性”，如本文开头所述，当一个线程修改了这个变量的值，volatile 保证了新值能立即同步到主内存，以及每次使用前立即从主内存刷新。但普通变量做不到这点，普通变量的值在线程间传递均需要通过主内存（详见：Java内存模型）来完成。

　　2.禁止指令重排序优化。有volatile修饰的变量，赋值后多执行了一个“load addl $0x0, (%esp)”操作，这个操作相当于一个内存屏障（指令重排序时不能把后面的指令重排序到内存屏障之前的位置），只有一个CPU访问内存时，并不需要内存屏障；（什么是指令重排序：是指CPU采用了允许将多条指令不按程序规定的顺序分开发送给各相应电路单元处理）。

volatile 性能：

　　volatile 的读性能消耗与普通变量几乎相同，但是写操作稍慢，因为它需要在本地代码中插入许多内存屏障指令来保证处理器不发生乱序执行。

    volatile不保证原子操作。所以不是线程安全的
 * 
 * 
 * stop 和 suspend已抛弃使用
 */
public class Bank {
	private final double[] accounts;

	   /**
	    * Constructs the bank.
	    * @param n the number of accounts
	    * @param initialBalance the initial balance for each account
	    */
	   public Bank(int n, double initialBalance)
	   {
	      accounts = new double[n];
	      Arrays.fill(accounts, initialBalance);
	   }

	   /**
	    * Transfers money from one account to another.
	    * @param from the account to transfer from
	    * @param to the account to transfer to
	    * @param amount the amount to transfer
	    */
	   public synchronized void transfer(int from, int to, double amount) throws InterruptedException
	   {
	      while (accounts[from] < amount)
	         wait();
	      System.out.print(Thread.currentThread());
	      accounts[from] -= amount;
	      System.out.printf(" %10.2f from %d to %d", amount, from, to);
	      accounts[to] += amount;
	      System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
	      notifyAll();
	   }

	   /**
	    * Gets the sum of all account balances.
	    * @return the total balance
	    * 
	    * 声明synchronizid对象锁将保护整个方法
	    *    
	    */
	   public synchronized double getTotalBalance()
	   {
	      double sum = 0;

	      for (double a : accounts)
	         sum += a;

	      return sum;
	   }

	   /**
	    * Gets the number of accounts in the bank.
	    * @return the number of accounts
	    */
	   public int size()
	   {
	      return accounts.length;
	   }

}
