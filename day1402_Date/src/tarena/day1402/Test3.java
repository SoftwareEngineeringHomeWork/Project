package tarena.day1402;

import java.util.Calendar;

public class Test3 {
	public static void main(String[] args) {
		Calendar a = Calendar.getInstance();
		//���Dateʵ��
		System.out.println(a.getTime());
		//���ָ���ֶε�ֵ
		System.out.println(a.get(Calendar.YEAR));
		System.out.println(a.get(Calendar.MONTH));
		System.out.println(a.get(Calendar.DAY_OF_YEAR));
		
		//��ָ���ֶε�ֵ����
		a.set(Calendar.MONTH,1);
		System.out.println(a.getTime());
		//����������ʱ����
		a.set(2000, 1,1,0,0,0);
		System.out.println(a.getTime());
		//ָ���ֶ��ϼ�һ��ֵ
		a.add(Calendar.DAY_OF_MONTH, 100);
		System.out.println(a.getTime());
		//ָ���ֶε�ʵ�����ֵ
		System.out.println(a.getActualMaximum
				(Calendar.DAY_OF_MONTH));
		//��ú���ֵ
		System.out.println(a.getTimeInMillis());
		
	}
}
