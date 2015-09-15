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
public class reviseGoodsInformation extends Activity {
	private EditText name;
	private EditText guige;
	private EditText danwei;
	sqlOpenHelper book;
	SQLiteDatabase sDatabase = null;
	String names;
	private Button bt1;
	private Button bt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addgoods);
		setTitle("修改商品信息");
		Intent intent = getIntent();
		names = intent.getStringExtra("comname");
		book = new sqlOpenHelper(getApplicationContext(), "store.db", null, 1);
		sDatabase = book.getWritableDatabase();
		setViews();
		setListeners();
		Cursor cursor = sDatabase.rawQuery("select pname,pguige,pdanwei from products", null);
		cursor.moveToFirst();
		String pnam = null;
		String pguig = null;
		String pdanwe = null;
		do {
			try {
				pnam = cursor.getString(0);
				pguig = cursor.getString(1);
				pdanwe= cursor.getString(2);
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), 
						"有异常", Toast.LENGTH_SHORT).show();
				e.printStackTrace();
				pnam = "";
				pguig = "";
				pdanwe = "";
			}
			if (pnam.equals(names)) {
				name.setText(pnam);
				guige.setText(pguig);
				danwei.setText(pdanwe);
				cursor.close();
				break;

			}
		} while (cursor.moveToNext());

	}
	private void setViews() {
		name=(EditText) findViewById(R.id.et1);
		guige=(EditText) findViewById(R.id.et2);
		danwei=(EditText) findViewById(R.id.et3);
		bt1=(Button) findViewById(R.id.bt1);
		bt2=(Button) findViewById(R.id.bt2);

	}
	private void setListeners() {
		bt1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(name.getText().toString().trim().equals("")){
					Dialog.builder(reviseGoodsInformation.this, "提示","请输入二手书名" );
				}
				else {
					// 查询语句
					String ename=name.getText().toString().trim();
					String eguige=guige.getText().toString().trim();
					String edanwei=danwei.getText().toString().trim();
					Cursor cursor = sDatabase.rawQuery("select pname,pguige,pdanwei from products", null);
					cursor.moveToFirst();

					do {
						try {

						} catch (Exception e) {
							Toast.makeText(getApplicationContext(), 
									"有异常", Toast.LENGTH_SHORT).show();
							e.printStackTrace();

						}
					} while (cursor.moveToNext());


					// 定义ID
					String select = "select max(_id) from products";
					Cursor seCursor = sDatabase.rawQuery(select, null);
					try {
						seCursor.moveToFirst();
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), 
								"有异常", Toast.LENGTH_SHORT).show();
						e.printStackTrace();
					}
					sDatabase.execSQL("update products set pname='"+ename+"',pguige='"+eguige+"',pdanwei='"+edanwei+"' where pname='"+names+"'");
					Toast.makeText(reviseGoodsInformation.this, "修改成功", Toast.LENGTH_LONG).show();			
					seCursor.close();								
				}				
			}
		});	
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("comname",names);
				intent.putExtras(bundle);
				intent.setClass(reviseGoodsInformation.this, Menu.class);
				startActivity(intent);			
			}
		});
	}


}
