package array;

import java.util.Arrays;

/*
 * ��ά����
 * ��ά�������ʱ
 * array.length��ʾ����
 * array[].length��ʾ�����е�Ԫ�ظ���
 * 
 * ���ú���
 *   ���ٴ�ӡ����/System.out.println(Arrays.deepToString(balances))
 *   �������� Arrays.copyOf(type[] a,int length),�÷��������������������鳤��
 *   ������������ֵv�����ɹ��������±� static int binarySearch(type[] a,type, v)
 */
public class CompoundInterest {

	public static void main(String[] args) {
		final double STARATE=10;
		final int NRATES=6;
		final int NYEARS=10;
		//set interest rates to 10...15%
		
		double[] interestRate=new double[NRATES];
		for(int j=0;j<interestRate.length;j++) {
			interestRate[j]=(STARATE+j)/100.0;
		}
		double[][] balances=new double[NYEARS][NRATES];
		
		//set initial balances to 10000
		for(int j=0;j<balances[0].length;j++)
			balances[0][j]=10000;
		
		//compute interest for future years
		for(int i=1;i<balances.length;i++) {
			for(int j=0;j<balances[i].length;j++) {
				//get year's balances from previous row
				double oldBalance=balances[i-1][j];
				double interest=oldBalance*interestRate[j];
				balances[i][j]=oldBalance+interest;
				}
		}
			//print one row of interest rate
			for(int j=0;j<interestRate.length;j++)
				System.out.printf("%9.0f%%",100*interestRate[j]);
				System.out.println();
			
			for(double[] row:balances)
			{
				for(double b:row)
					System.out.printf("%10.2f",b);
				System.out.println();
				
				//System.out.println(Arrays.deepToString(balances));���Կ��ٴ�ӡһ����ά����
			}
			
		}

	}


