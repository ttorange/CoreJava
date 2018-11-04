package unsynch;

import java.util.*;
import java.util.concurrent.locks.*;

/**
 * A bank with a number of bank accounts that uses locks for serializing access.
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 * 
 * 
 * 将transfer方法进行原子操作。把操作放在lock  unlock中
 * 
 * 常用API
 * 线程优先级 void setPriority(int newPriority) MIN_PRIORITY,NORM_PRIORITY,MAX_PRIORITY
 * static void yield()导致当前执行线程处于让步状态
 * 守护线程  t.setDaemon(true);  
 *      守护线程的作用是为其他线程提供服务，比如计时器
 *     它不应该访问固有资源，如文件数据库等，因为它随时有可能中断
*     public static boolean interrupted() 测试当前线程是否中断。 该方法可以清除线程的中断状态 。 
*public boolean isInterrupted() 测试这个线程是否被中断。 线程的中断状态不受此方法的影响。

 * 进程同步：
 *   在竞争条件下，需要合理控制进程次序
 *   锁对象：保证任何时刻只有一个线程进入临界区
 *      lock...unlock
 * void await（）  将该线程放到条件等待集中
 * void signalAll() 接触该条件的等待集 中的所有线程阻塞状态
 * void signal()  从该条件的等待集 中随机选取一个线程解除其阻塞状态。
 *               该方法比signalAll更有效。但也有危险。有可能发生死锁
 */
public class Bank
{
   private final double[] accounts;
   /*
    * ReentrantLock implements the Lock interface,
     *  每个 Bank对象有自己的ReeentrantLock对象,多个线程访问同一个Bank将串行工作，否则都不会发生阻塞
     *  锁是可重入的，线程可以重复的获得已经持有的锁，锁通过持有计数器跟踪锁的嵌套调用
    */
   private Lock bankLock;
   private Condition sufficientFunds;

   /**
    * Constructs the bank.
    * @param n the number of accounts
    * @param initialBalance the initial balance for each account
    */
   public Bank(int n, double initialBalance)
   {
      accounts = new double[n];
      Arrays.fill(accounts, initialBalance);
      bankLock = new ReentrantLock();
      sufficientFunds = bankLock.newCondition();
   }

   /**
    * Transfers money from one account to another.
    * @param from the account to transfer from
    * @param to the account to transfer to
    * @param amount the amount to transfer
    * 
    * 条件对象：
    */
   public void transfer(int from, int to, double amount) throws InterruptedException
   {
      bankLock.lock();
      try
      {
         while (accounts[from] < amount)
            sufficientFunds.await();//阻塞当前线程并放弃锁
         System.out.print(Thread.currentThread());
         accounts[from] -= amount;
         System.out.printf(" %10.2f from %d to %d", amount, from, to);
         accounts[to] += amount;
         System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
         sufficientFunds.signalAll();//激活await的线程（接触阻塞状态）再次检测已满足条件的线程以运行
      }
      finally
      {
         bankLock.unlock();
      }
   }

   /**
    * Gets the sum of all account balances.
    * @return the total balance
    */
   public double getTotalBalance()
   {
      bankLock.lock();
      try
      {
         double sum = 0;

         for (double a : accounts)
            sum += a;

         return sum;
      }
      finally
      {
         bankLock.unlock();
      }
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
