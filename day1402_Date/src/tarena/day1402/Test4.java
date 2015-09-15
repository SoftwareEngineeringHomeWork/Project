package tarena.day1402;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) throws ParseException {
		/*
		 * 1.提示“输入年-月”
		 * 2.获得输入的值赋给s
		 * 3.SimpleDateFormat 实例赋给f
		 * 4.用f解析字符串s
		 * 		得到Date 实例赋给d
		 * 5.新建Calendar 实例赋给c
		 * 6.c.setTime(d)
		 * 		将Calendar对象设置成
		 * 		和d相同的时间
		 * 7.c.getActualMaximun()
		 * 		得到当月最大天数赋给max
		 * 8.得到1号是周几赋给day
		 * 		日  一    二   三   四     五    六
		 * 		1 2 3 4 5  6 7
		 * 9.day-1得到空格数量赋给space
		 * 10.定义一个计数变量count=0
		 * 11.输出“日\t一\t二\t三\t四\t五\t六\t”
		 * 12.循环i从0到<space
		 * 		13.输出"\t"
		 * 		count++
		 * 13.循环i从1到<=max
		 * 		14.输出i+"\t"
		 * 		15.count++
		 * 		16.如果count == 7
		 * 			17.输出换行
		 * 			18.count = 0
		 */
		System.out.println("输入年-月");
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
		System.out.println("日\t一\t二\t三\t四\t五\t六");
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
