package liang.software.engineer;



import liang.software.engineer.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

/**
 * ��¼ҳ��
 * 
 * @author ��־Զ
 * 
 */
public class loginActivity extends Activity {
	private EditText use;// �û���
	private EditText password;// ����
	sqlOpenHelper db;
	SQLiteDatabase sDatabase = null;

	/** Called when the activity is first created. */

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		setViews();
		db = new sqlOpenHelper(getApplicationContext(), "store.db", null, 1);
		sDatabase = db.getWritableDatabase();

	}

	private void setViews() {
		use = (EditText) findViewById(R.id.et1);
		password = (EditText) findViewById(R.id.et2);
		
	}

	// ��¼��ť����
	public void onLoad(View v)
	{

		// ����ȡ���ݵ��ַ���
		String userName = "";
		String userPw = "";

		String i = use.getText().toString().trim();
//		��д���ݿ����
//		ִ�����
		Cursor cursor = sDatabase.rawQuery("select username,password from user_info where username = '"
				+ i + "'", null);
		cursor.moveToFirst();
		// ����������ȡ�����û��������븳ֵ�������ַ�������
		try
		{
			userName = cursor.getString(0);
			userPw = cursor.getString(1);
		} catch (Exception e)
		{
			e.printStackTrace();
			userName = "";
			userPw = "";
			Toast.makeText(getApplicationContext(), 
					"��½ʧ��", 
					Toast.LENGTH_LONG).show();
		}

//		�ж��û����Ƿ�Ϊ��
		if (use.getText().toString().equals(""))
		{
			Dialog.builder(loginActivity.this, "������Ϣ",
					"�û�������Ϊ�գ�");
		}
//		�ж������Ƿ�Ϊ��
		else if (password.getText().toString().equals(""))
		{
			Dialog.builder(loginActivity.this, "������Ϣ",
					"���벻��Ϊ�գ�");
		} 
//		�ж��û����������Ƿ���ȷ
		else if (!(use.getText().toString().equals(userName) && password
				.getText().toString().equals(userPw)))
		{
			Dialog.builder(loginActivity.this, "������Ϣ",
					"�û����������������������");
		}
//		ȫ����ȷ��ת����������
		else
		{
			cursor.close();
			Intent intent = new Intent();
			Bundle bundle = new Bundle();
			bundle.putString("username",userName);
			intent.putExtras(bundle);
			intent.setClass(getApplicationContext(), Menu.class);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), 
					"��ӭ��½���������ƽ̨", Toast.LENGTH_LONG).show();

		}
	}
	//ע�ᰴť����



}