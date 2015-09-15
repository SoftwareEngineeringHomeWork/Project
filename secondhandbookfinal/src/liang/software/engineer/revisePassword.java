package liang.software.engineer;

import liang.software.engineer.R;
import android.app.Activity;
import android.content.Intent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class revisePassword extends Activity {
	private EditText et11;
	private EditText et22;
	private EditText et3;
	String names;
	sqlOpenHelper book;
	SQLiteDatabase sDatabase = null;
	private Button bt1;
	private Button bt2;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.revisepassword);
		setTitle("修改密码");
		Intent intent = getIntent();
		book = new sqlOpenHelper(getApplicationContext(), "store.db", null, 1);
		sDatabase = book.getWritableDatabase();
		names = intent.getStringExtra("username");
		setViews();
		setListeners();


	}
	private void setViews() {
		et11 = (EditText) findViewById(R.id.et1);
		et22 = (EditText) findViewById(R.id.et2);
		et3=(EditText) findViewById(R.id.et3);
		bt1=(Button) findViewById(R.id.bt1);
		bt2=(Button) findViewById(R.id.bt2);


	}
	private void setListeners() {
		bt1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Cursor cursor = sDatabase.rawQuery("select password from user_info where username='"+names+"'", null);
				cursor.moveToFirst();
				String pass=null;
				String et1=et11.getText().toString().trim();
				String et2=et22.getText().toString().trim();
				String quemima=et3.getText().toString().trim();
				if(et1.equals("")||et2.equals("")||quemima.equals("")){
					Dialog.builder(revisePassword.this , "提示", "请填写完整信息");
				}
				else if (!et22.getText().toString()
						.equals(et3.getText().toString())) {
					Dialog.builder(revisePassword.this, "错误信息", "两次密码输入不一致！");}
				else{
					do {
						try {
							pass= cursor.getString(0);
						} catch (Exception e) {
							Toast.makeText(getApplicationContext(), 
									"有异常", Toast.LENGTH_SHORT).show();
							e.printStackTrace();
							pass="";
						}
						if (!et1.equals(pass)) {
							Dialog.builder(revisePassword.this, "错误信息","原始密码错误");
							cursor.close();
							break;

						}

					} while (cursor.moveToNext());
					if (et1.equals(pass)) {


						sDatabase.execSQL("update user_info set password='"+et2+"' where username='"+names+"'");
						Toast.makeText(revisePassword.this, "修改成功", Toast.LENGTH_LONG).show();
					}

				}

			}
		});
		bt2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("username",names);
				intent.putExtras(bundle);
				intent.setClass(revisePassword.this, Menu.class);
				startActivity(intent);			
			}
		});

	}


}
