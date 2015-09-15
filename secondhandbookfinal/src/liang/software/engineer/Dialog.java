package liang.software.engineer;


import android.app.AlertDialog;
import android.content.Context;

public class Dialog
{
	// 错误消息对话框
	public static void builder(Context context, String title, String message)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(title)
			   .setMessage(message)
			   .setPositiveButton("确定", null)
			   .create()			   
			   .show();
	}
}
