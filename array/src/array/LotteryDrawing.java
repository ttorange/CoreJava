package array;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 数组
 *    数组的初始化
 *    遍历  for each 
 *    数组排序Arrays.sort(array)
 *    多维数组，不规则数组
 */
public class LotteryDrawing {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("how many number dou you need to draw?");
		int k=in.nextInt();
		
		System.out.println("what is the highest numbe");
		int n=in.nextInt();
		
		//fill an array with numbers 1 2 3....n
		int[] numbers=new int[n];
		for(int i=0;i<numbers.length;i++)
			numbers[i]=i+1;
		//draw k numbers and put them int a second array
		int[] result=new int[k];
		for(int i=0;i<result.length;i++) {
			int r=(int)(Math.random()*n);
			result[i]=numbers[r];
			numbers[r]=numbers[n-1];
			n--;
		}
		Arrays.sort(result);
		System.out.println("Bet the following combination,it'll make you rich");
		for(int r:result)
			System.out.println(r);
	}

}
