package tarena.day1402;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) throws ParseException {
		/*
		 * 1.��ʾ��������-�¡�
		 * 2.��������ֵ����s
		 * 3.SimpleDateFormat ʵ������f
		 * 4.��f�����ַ���s
		 * 		�õ�Date ʵ������d
		 * 5.�½�Calendar ʵ������c
		 * 6.c.setTime(d)
		 * 		��Calendar�������ó�
		 * 		��d��ͬ��ʱ��
		 * 7.c.getActualMaximun()
		 * 		�õ����������������max
		 * 8.�õ�1�����ܼ�����day
		 * 		��  һ    ��   ��   ��     ��    ��
		 * 		1 2 3 4 5  6 7
		 * 9.day-1�õ��ո���������space
		 * 10.����һ����������count=0
		 * 11.�������\tһ\t��\t��\t��\t��\t��\t��
		 * 12.ѭ��i��0��<space
		 * 		13.���"\t"
		 * 		count++
		 * 13.ѭ��i��1��<=max
		 * 		14.���i+"\t"
		 * 		15.count++
		 * 		16.���count == 7
		 * 			17.�������
		 * 			18.count = 0
		 */
		System.out.println("������-��");
		String s = new Scanner(System.in).nextLine();
		
		SimpleDateFormat f =
			new SimpleDateFormat(
			"y-M");
		Date d = f.parse(s);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		
		int max = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int day = c.get(Calendar.DAY_OF_WEEK);
		int space = day-1;
		int count = 0;
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		for(int i=0;i<space;i++){
			System.out.print(" \t");
			count++;
		}
		for(int i=1;i<=max;i++){
			System.out.print(i+"\t");
			count++;
			if(count == 7){
				System.out.println();
				count=0;
			}
		}
	}
}
