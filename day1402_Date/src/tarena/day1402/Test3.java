package tarena.day1402;

import java.util.Calendar;

public class Test3 {
	public static void main(String[] args) {
		Calendar a = Calendar.getInstance();
		//获得Date实例
		System.out.println(a.getTime());
		//获得指定字段的值
		System.out.println(a.get(Calendar.YEAR));
		System.out.println(a.get(Calendar.MONTH));
		System.out.println(a.get(Calendar.DAY_OF_YEAR));
		
		//对指定字段的值设置
		a.set(Calendar.MONTH,1);
		System.out.println(a.getTime());
		//设置年月日时分秒
		a.set(2000, 1,1,0,0,0);
		System.out.println(a.getTime());
		//指定字段上加一个值
		a.add(Calendar.DAY_OF_MONTH, 100);
		System.out.println(a.getTime());
		//指定字段的实际最大值
		System.out.println(a.getActualMaximum
				(Calendar.DAY_OF_MONTH));
		//获得毫秒值
		System.out.println(a.getTimeInMillis());
		
	}
}
