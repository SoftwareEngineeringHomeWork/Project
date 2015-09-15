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


public class addGoods extends Activity {
	private EditText et1;
	private EditText et2;
	private EditText et3;
	sqlOpenHelper book;
	SQLiteDatabase sDatabase = null;
	String st1;
	private Button bt1;
	private Button bt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addgoods);
		setTitle("添加二手书信息");
		setTitleColor(000000);
		Intent intent = getIntent();
		st1 = intent.getStringExtra("username");
		book = new sqlOpenHelper(getApplicationContext(), "store.db", null, 1);
		sDatabase = book.getWritableDatabase();
		setViews();
		setListeners();

	}	

	private void setViews() {
		et1=(EditText) findViewById(R.id.et1);
		et2=(EditText) findViewById(R.id.et2);
		et3=(EditText) findViewById(R.id.et3);
		bt1=(Button) findViewById(R.id.bt1);
		bt2=(Button) findViewById(R.id.bt2);
	}

	private void setListeners() {
		bt1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(et1.getText().toString().equals("")){
					Dialog.builder(addGoods.this, "提示","请输入二手书名称" );
				}
				else {
					// 查询语句
					Cursor cursor = sDatabase.rawQuery("select pname,pguige,pdanwei from products", null);
					cursor.moveToFirst();
					String ename=et1.getText().toString().trim();
					String eguige=et2.getText().toString().trim();
					String edanwei=et3.getText().toString().trim();
					String nam = null;
					String guig = null;
					String danwe = null;
					do {
						try {
							nam = cursor.getString(0);
							guig = cursor.getString(1);
							danwe= cursor.getString(2);
						} catch (Exception e) {
							Toast.makeText(getApplicationContext(), 
									"", Toast.LENGTH_SHORT).show();
							nam = "";
							guig = "";
							danwe = "";
						}
						if (nam.equals(ename)&&guig.equals(eguige)&&danwe.equals(edanwei)) {
							Dialog.builder(addGoods.this, "错误信息","该书本信息已存在");
							cursor.close();
							break;

						}
					} while (cursor.moveToNext());

					if (!(nam.equals(ename)&&guig.equals(eguige)&&danwe.equals(edanwei))) {
						// 定义ID
						int id = 0;
						Cursor seCursor = sDatabase.rawQuery("select max(_id) from products", null);
						try {
							seCursor.moveToFirst();
							id = Integer.parseInt(seCursor.getString(0));
							id += 1;
						} catch (Exception e) {
							Toast.makeText(getApplicationContext(), 
									"", Toast.LENGTH_SHORT).show();
							id = 0;
						}
						sDatabase.execSQL("insert into products values('" + id + "','"
								+ ename + "','" + eguige + "','" 
								+ edanwei + "')");
						Toast.makeText(addGoods.this, "添加成功", Toast.LENGTH_LONG).show();				
						seCursor.close();
					}
				}

			}
		});
		bt2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("username",st1);
				intent.putExtras(bundle);
				intent.setClass(addGoods.this, Menu.class);
				startActivity(intent);
			}
		});
	}


}
