package tarena.day1402;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) throws ParseException {
		System.out.println("生日：");
		String s = new Scanner(System.in).nextLine();
		
		/*
		 * "1991-6-16" -->解析 -->Date -->
		 * 
		 */
		SimpleDateFormat f = 
		  new SimpleDateFormat(
		  "yyy-M-d");
		
		Date d = f.parse(s);
		long t = System.currentTimeMillis() - 
				d.getTime();
		t = t/1000/60/60/24;
		System.out.println("你已经生存了："+t+"day");
		
	}
}
