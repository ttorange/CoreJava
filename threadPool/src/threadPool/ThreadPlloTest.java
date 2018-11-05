package threadPool;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * @version 1.02 2015-06-21
 * @author Cay Horstmann
 * 
 * 参考博客：https://zhuanlan.zhihu.com/p/26441926
 *          https://www.jianshu.com/p/b8197dd2934c
 * 
 * FutureTask表示一个异步运算的任务。FutureTask里面可以传入一个Callable的具体实现类，
 * 可以对这个异步运算的任务的结果进行等待获取、判断是否已经完成、取消任务等操作。
 * 当然，由于FutureTask也是Runnable接口的实现类，所以FutureTask也可以放入线程池中。
 * 
 * 单独使用 Callable，无法在新线程中(new Thread(Runnable r))使用，Thread 类只支持 Runnable。不过 Callable 可以使用 ExecutorService 
 * Future 定义了5个方法：

1）boolean cancel(boolean mayInterruptIfRunning)：试图取消对此任务的执行。如果任务已完成、或已取消，或者由于某些其他原因而无法取消，则此尝试将失败。当调用 cancel() 时，如果调用成功，而此任务尚未启动，则此任务将永不运行。如果任务已经启动，则 mayInterruptIfRunning 参数确定是否应该以试图停止任务的方式来中断执行此任务的线程。此方法返回后，对 isDone() 的后续调用将始终返回 true。如果此方法返回 true，则对 isCancelled() 的后续调用将始终返回 true。
2）boolean isCancelled()：如果在任务正常完成前将其取消，则返回 true。
3）boolean isDone()：如果任务已完成，则返回 true。 可能由于正常终止、异常或取消而完成，在所有这些情况中，此方法都将返回 true。
4）V get()throws InterruptedException,ExecutionException：如有必要，等待计算完成，然后获取其结果。
5）V get(long timeout,TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException： 如有必要，最多等待为使计算完成所给定的时间之后，获取其结果（如果结果可用）。

FutureTask 是为了弥补 Thread 的不足而设计的，它可以让程序员准确地知道线程什么时候执行完成并获得到线程执行完成后返回的结果。FutureTask 是一种可以取消的异步的计算任务，它的计算是通过 Callable 实现的，它等价于可以携带结果的 Runnable，并且有三个状态：等待、运行和完成。完成包括所有计算以任意的方式结束，包括正常结束、取消和异常。

线程池的优点
1）避免线程的创建和销毁带来的性能开销。
2）避免大量的线程间因互相抢占系统资源导致的阻塞现象。
3｝能够对线程进行简单的管理并提供定时执行、间隔执行等功能。

再撸一撸概念
Java里面线程池的顶级接口是 Executor，不过真正的线程池接口是 ExecutorService， ExecutorService 的默认实现是 ThreadPoolExecutor；普通类 Executors 里面调用的就是 ThreadPoolExecutor。

Executors 提供四种线程池：

1）newCachedThreadPool 是一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。调用 execute() 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。因此，长时间保持空闲的线程池不会使用任何资源。注意，可以使用 ThreadPoolExecutor 构造方法创建具有类似属性但细节不同（例如超时参数）的线程池。

2）newSingleThreadExecutor 创建是一个单线程池，也就是该线程池只有一个线程在工作，所有的任务是串行执行的，如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它，此线程池保证所有任务的执行顺序按照任务的提交顺序执行。

3）newFixedThreadPool 创建固定大小的线程池，每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小，线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。

4）newScheduledThreadPool 创建一个大小无限的线程池，此线程池支持定时以及周期性执行任务的需求。

1）什么是 Executor 框架？

Executor框架在Java 5中被引入，Executor 框架是一个根据一组执行策略调用、调度、执行和控制的异步任务的框架。

无限制的创建线程会引起应用程序内存溢出，所以创建一个线程池是个更好的的解决方案，因为可以限制线程的数量并且可以回收再利用这些线程。利用 Executor 框架可以非常方便的创建一个线程池。

2）Executors 类是什么？

Executors为Executor、ExecutorService、ScheduledExecutorService、ThreadFactory 和 Callable 类提供了一些工具方法。Executors 可以用于方便的创建线程池。



 */
public class ThreadPlloTest
{
   public static void main(String[] args) throws Exception
   {
      try (Scanner in = new Scanner(System.in))
      {
         System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src): ");
         String directory = in.nextLine();
         System.out.print("Enter keyword (e.g. volatile): ");
         String keyword = in.nextLine();
   
         ExecutorService pool = Executors.newCachedThreadPool();//创建新线程，空线程保留60s
   
         MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
         Future<Integer> result = pool.submit(counter);
   
         try
         {
            System.out.println(result.get() + " matching files.");
         }
         catch (ExecutionException e)
         {
            e.printStackTrace();
         }
         catch (InterruptedException e)
         {
         }
         pool.shutdown();
   
         int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
         System.out.println("largest pool size=" + largestPoolSize);
      }
   }
}

/**
 * This task counts the files in a directory and its subdirectories that contain a given keyword.
 */
class MatchCounter implements Callable<Integer>//callable返回Future
{
   private File directory;
   private String keyword;
   private ExecutorService pool;
   private int count;

   /**
    * Constructs a MatchCounter.
    * @param directory the directory in which to start the search
    * @param keyword the keyword to look for
    * @param pool the thread pool for submitting subtasks
    */
   public MatchCounter(File directory, String keyword, ExecutorService pool)
   {
      this.directory = directory;
      this.keyword = keyword;
      this.pool = pool;
   }

   public Integer call()
   {
      count = 0;
      try
      {
         File[] files = directory.listFiles();
         List<Future<Integer>> results = new ArrayList<>();

         for (File file : files)
            if (file.isDirectory())
            {
               MatchCounter counter = new MatchCounter(file, keyword, pool);
               Future<Integer> result = pool.submit(counter);
               results.add(result);
            }
            else
            {
               if (search(file)) count++;
            }

         for (Future<Integer> result : results)
            try
            {
               count += result.get();
            }
            catch (ExecutionException e)
            {
               e.printStackTrace();
            }
      }
      catch (InterruptedException e)
      {
      }
      return count;
   }

   /**
    * Searches a file for a given keyword.
    * @param file the file to search
    * @return true if the keyword is contained in the file
    */
   public boolean search(File file)
   {
      try
      {
         try (Scanner in = new Scanner(file, "UTF-8"))
         {
            boolean found = false;
            while (!found && in.hasNextLine())
            {
               String line = in.nextLine();
               if (line.contains(keyword)) found = true;
            }         
            return found;
         }
      }
      catch (IOException e)
      {
         return false;
      }
   }
}