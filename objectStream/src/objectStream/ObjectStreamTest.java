package objectStream;

import java.io.*;

/**
 * @version 1.10 17 Aug 1998
 * @author Cay Horstmann
 * 
 * 对象流与序列化  
 * 序列化和反序列化的概念
　　把对象转换为字节序列的过程称为对象的序列化。
　　把字节序列恢复为对象的过程称为对象的反序列化。
　　对象的序列化主要有两种用途：
 *  
 *  序列化：每个对象用一个序列号保存
 *       实现：1遇到每个对象用关联的一个序号
 *        2第一次遇到的对象保存到数据流中
 *        3已保存的对象只写出之前保存过的序列号
 *    序列化的另一种重要应用是通过网络将对象合集传送到另一台计算机上。序列号代替原生内存地址
 *    
 * ObjectOut/InputStream,储存/返回的时指定对象的类，类的签名以及这个类及其超类所有非静态和非瞬时的域的值
 */
class ObjectStreamTest
{
   public static void main(String[] args) throws IOException, ClassNotFoundException
   {
      Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
      Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
      carl.setSecretary(harry);
      Manager tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
      tony.setSecretary(harry);

      Employee[] staff = new Employee[3];

      staff[0] = carl;
      staff[1] = harry;
      staff[2] = tony;

      // save all employee records to the file employee.dat         
      try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"))) 
      {
         out.writeObject(staff);
      }

      try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat")))
      {
         // retrieve all records into a new array
         
         Employee[] newStaff = (Employee[]) in.readObject();

         // raise secretary's salary
         newStaff[1].raiseSalary(10);

         // print the newly read employee records
         for (Employee e : newStaff)
            System.out.println(e);
      }
   }
}