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
 * 登录页面
 * 
 * @author 田志远
 * 
 */
public class loginActivity extends Activity {
	private EditText use;// 用户名
	private EditText password;// 密码
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

	// 登录按钮监听
	public void onLoad(View v)
	{

		// 定义取数据的字符串
		String userName = "";
		String userPw = "";

		String i = use.getText().toString().trim();
//		编写数据库语句
//		执行语句
		Cursor cursor = sDatabase.rawQuery("select username,password from user_info where username = '"
				+ i + "'", null);
		cursor.moveToFirst();
		// 将从数据中取出的用户名和密码赋值给两个字符串变量
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
					"登陆失败", 
					Toast.LENGTH_LONG).show();
		}

//		判断用户名是否为空
		if (use.getText().toString().equals(""))
		{
			Dialog.builder(loginActivity.this, "错误信息",
					"用户名不能为空！");
		}
//		判断密码是否为空
		else if (password.getText().toString().equals(""))
		{
			Dialog.builder(loginActivity.this, "错误信息",
					"密码不能为空！");
		} 
//		判断用户名和密码是否正确
		else if (!(use.getText().toString().equals(userName) && password
				.getText().toString().equals(userPw)))
		{
			Dialog.builder(loginActivity.this, "错误信息",
					"用户名或密码错误，请重新输入");
		}
//		全部正确跳转到操作界面
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
					"欢迎登陆二手书管理平台", Toast.LENGTH_LONG).show();

		}
	}
	//注册按钮监听



}