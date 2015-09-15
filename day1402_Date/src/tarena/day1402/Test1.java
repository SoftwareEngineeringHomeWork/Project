package tarena.day1402;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) {
		Date a = new Date();
		Date b = new Date(600000000000L);
		
		System.out.println(a);
		System.out.println(b);
		
		SimpleDateFormat f = 
			new SimpleDateFormat(
			"y-M-dd H:m:s");
		System.out.println(f.format(a));
		System.out.println(f.format(b));
	}
}
