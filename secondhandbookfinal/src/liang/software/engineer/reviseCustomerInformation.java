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



public class reviseCustomerInformation extends Activity {
	private EditText et1;
	private EditText et2;
	private EditText et3;
	private EditText et4;
	private EditText et5;
	private EditText et6;
	private EditText et7;
	private EditText et8;
	private EditText et9;
	sqlOpenHelper book;
	SQLiteDatabase sDatabase = null;
	String names;
	private Button bt1;
	private Button bt2;

	protected void onCreate(Bundle savedInstanceState)  {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addcustomer);
		setTitle("修改买家信息");
		Intent inte = getIntent();
		names = inte.getStringExtra("compname");
		book = new sqlOpenHelper(getApplicationContext(), "store.db", null, 1);
		sDatabase = book.getWritableDatabase();
		setViews();
		setListeners();
		Cursor cursor = sDatabase.rawQuery("select comname,pername,addr,city,diqu,youbian,tel,chuangzhen,web from guke", null);
		cursor.moveToFirst();
		String cname = null;
		String pname = null;
		String padd = null;
		String pcity = null;
		String pdiqu = null;
		String pyoubian = null;
		String ptel = null;
		String pzhen = null;
		String pweb = null;
		do {
			try {
				cname = cursor.getString(0);
				pname = cursor.getString(1);
				padd = cursor.getString(2);
				pcity = cursor.getString(3);
				pdiqu = cursor.getString(4);
				pyoubian = cursor.getString(5);
				ptel = cursor.getString(6);
				pzhen = cursor.getString(7);
				pweb = cursor.getString(8);
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), 
						"无数据", Toast.LENGTH_SHORT).show();
				e.printStackTrace();
				cname = "";
				pname = "";
				padd = "";
				pcity = "";
				pdiqu = "";
				pyoubian = "";
				ptel = "";
				pzhen = "";
				pweb = "";
			}
			if (cname.equals(names)) {
				et1.setText(cname);
				et2.setText(pname);
				et3.setText(padd);
				et4.setText(pcity);

				et5.setText(pdiqu);
				et6.setText(pyoubian);

				et8.setText(pzhen);
				et7.setText(ptel);
				et9.setText(pweb);
				cursor.close();
				break;

			}
		} while (cursor.moveToNext());
	}
	private void setViews() {
		et1 = (EditText) findViewById(R.id.et1);
		et2 = (EditText) findViewById(R.id.et2);
		et4 = (EditText) findViewById(R.id.et4);
		et3 = (EditText) findViewById(R.id.et3);
		et5 = (EditText) findViewById(R.id.et5);
		et6 = (EditText) findViewById(R.id.et6);
		et7 = (EditText) findViewById(R.id.et7);
		et8 = (EditText) findViewById(R.id.et8);
		et9 = (EditText) findViewById(R.id.et9);
		bt1 = (Button) findViewById(R.id.bt1);
		bt2 = (Button) findViewById(R.id.bt2);

	}
	private void setListeners() {
		bt1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (et1.getText().toString().equals("")) {
					Dialog.builder(reviseCustomerInformation.this, "提示", "请输入买家姓名");
				} else {
					// 查询语句
					String egsmc = et1.getText().toString().trim();
					String elxr = et2.getText().toString().trim();
					String elxdz = et3.getText().toString().trim();
					String ecsmc = et4.getText().toString().trim();
					String edqmc = et5.getText().toString().trim();
					String eyzbm = et6.getText().toString().trim();
					String elxdh = et7.getText().toString().trim();
					String eczhm = et8.getText().toString().trim();
					String egszy = et9.getText().toString().trim();
					Cursor cursor = sDatabase.rawQuery("select comname,pername,addr,city,diqu,youbian,tel,chuangzhen,web from guke", null);
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
					Cursor seCursor = sDatabase.rawQuery("select max(_id) from guke", null);
					try {
						seCursor.moveToFirst();
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), 
								"有异常", Toast.LENGTH_SHORT).show();
						e.printStackTrace();
					}
					sDatabase.execSQL("update guke set comname='"+egsmc+"',pername='"+elxr+"',addr='"+elxdz+"',city='"+ecsmc+"',diqu='"+edqmc+"',youbian='"
							+eyzbm+"',tel='"+elxdh+"',chuangzhen='"+eczhm+"',web='"+egszy+"'where comname='"+names+"'"
							);
					Toast.makeText(reviseCustomerInformation.this, "修改成功", Toast.LENGTH_LONG).show();

					seCursor.close();			
				}			
			}
		});	
		bt2.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("username", names);
				intent.putExtras(bundle);
				intent.setClass(reviseCustomerInformation.this, Menu.class);
				startActivity(intent);				
			}
		});
	}

}
