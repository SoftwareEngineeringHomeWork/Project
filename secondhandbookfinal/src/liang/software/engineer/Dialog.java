package liang.software.engineer;


import android.app.AlertDialog;
import android.content.Context;

public class Dialog
{
	// ������Ϣ�Ի���
	public static void builder(Context context, String title, String message)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(title)
			   .setMessage(message)
			   .setPositiveButton("ȷ��", null)
			   .create()			   
			   .show();
	}
}
