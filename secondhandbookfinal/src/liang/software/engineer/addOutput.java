package liang.software.engineer;

import java.util.Calendar;

import liang.software.engineer.R;









import android.app.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class addOutput extends Activity {
	sqlOpenHelper book;
	SQLiteDatabase sDatabase = null;
	Spinner sp1;
	EditText et1;
	EditText et2;
	Spinner sp2;
	EditText et3;
	EditText et4;
	EditText et5;
	EditText et6;
	String st1[];
	String st2[];
	String st3;
	String st4;
	String st5;
	int i = 0;
	int j = 0;
	DatePicker dp1;
	int year;
	int mon;
	int day;
	Calendar c;
	String st6;
	private Button bt1;
	private Button bt2;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addoutput);		
		Intent intent = getIntent();
		st6 = intent.getStringExtra("username");
		book = new sqlOpenHelper(getApplicationContext(), "store.db", null, 1);
		sDatabase = book.getWritableDatabase();
		setViews();
		setListeners();
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		mon = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		st5=year+"年"+(mon+1)+"月"+day+"日";
		dp1.init(year , mon ,day 
				, new OnDateChangedListener()
		{

			@Override
			public void onDateChanged(DatePicker arg0, int year
					, int month, int day)
			{
				addOutput.this.year = year;
				addOutput.this.mon = month;
				addOutput.this.day = day;
				//显示当前日期、时间
				st5=year+"年"+(month+1)+"月"+day+"日";
				System.out.println(st5);

			}
		});


		Cursor cursor = sDatabase.rawQuery("select comname  from guke", null);
		Cursor cursor1 = sDatabase.rawQuery("select pname  from products", null);
		cursor.moveToFirst();
		cursor1.moveToFirst();
		int count = cursor.getCount();
		int count1 = cursor1.getCount();
		st1 = new String[count];
		st2 = new String[count1];
		do {
			try {
				st1[i] = cursor.getString(0);
				System.out.println(st1[i]);
				i++;

			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), 
						"请填写数据", Toast.LENGTH_SHORT).show();

			}

		} while (cursor.moveToNext());
		do {
			try {
				st2[j] = cursor1.getString(0);
				System.out.println(st2[j]);
				j++;

			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), 
						"请填写数据", Toast.LENGTH_SHORT).show();
			}

		} while (cursor1.moveToNext());
		BaseAdapter ba = new BaseAdapter() {
			@Override
			public int getCount() {
				// 指定一共包含10个选项
				return st1.length;
			}

			@Override
			public Object getItem(int position) {
				return null;
			}

			@Override
			public long getItemId(int position) {
				return 0;
			}

			// 重写该方法，该方法返回的View将作为列表框的每项
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView text = new TextView(addOutput.this);
				text.setText(st1[position]);
				text.setTextSize(20);
				text.getResources().getColor(R.color.red);
				return text;

			}

		};
		sp1.setAdapter(ba);
		BaseAdapter ba1 = new BaseAdapter() {
			@Override
			public int getCount() {
				// 指定一共包含10个选项
				return st2.length;
			}

			@Override
			public Object getItem(int position) {
				return null;
			}

			@Override
			public long getItemId(int position) {
				return 0;
			}

			// 重写该方法，该方法返回的View将作为列表框的每项
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView text = new TextView(addOutput.this);
				text.setText(st2[position]);
				text.setTextSize(20);
				text.getResources().getColor(R.color.red);
				return text;

			}

		};
		sp2.setAdapter(ba1);
		sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				st3 = st1[arg2];
				Cursor cursor2 = sDatabase.rawQuery("select pername,tel from guke where comname='"
						+ st3 + "'", null);
				cursor2.moveToFirst();
				String name = null;
				String tel = null;
				do {
					try {
						name = cursor2.getString(0);
						tel = cursor2.getString(1);
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), 
								"请填写数据", Toast.LENGTH_SHORT).show();
						name = "";
						tel = "";

					}

				} while (cursor2.moveToNext());
				et1.setText(name);
				et2.setText(tel);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				st4 = st2[arg2];
				Cursor cursor3 = sDatabase.rawQuery("select pguige,pdanwei from products where pname='"
						+ st4 + "'", null);
				cursor3.moveToFirst();
				String guige = null;
				String danwei = null;
				do {
					try {
						guige = cursor3.getString(0);
						danwei = cursor3.getString(1);
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), 
								"请填写数据", Toast.LENGTH_SHORT).show();
						guige = "";
						danwei = "";
					}

				} while (cursor3.moveToNext());
				et3.setText(guige);
				et4.setText(danwei);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

	}

	private void setListeners() {
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(et5.getText().toString().trim().equals("")||et6.getText().toString().trim().equals("")){
					Dialog.builder(addOutput.this, "提示", "请填写完整信息");

				}
				else{
					String elxr=et1.getText().toString().trim();
					String elxdh=et2.getText().toString().trim();
					String espgg=et3.getText().toString().trim();
					String ejldw=et4.getText().toString().trim();
					String espdj=et5.getText().toString().trim();
					String espgs=et6.getText().toString().trim();

					// 定义ID
					int id = 0;
					String select = "select max(_id) from chuku";
					Cursor seCursor = sDatabase.rawQuery(select, null);
					try {
						seCursor.moveToFirst();
						id = Integer.parseInt(seCursor.getString(0));
						id += 1;
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), 
								"请填写数据", Toast.LENGTH_SHORT).show();
						e.printStackTrace();
						id = 0;
					}
					sDatabase.execSQL("insert into chuku values('" + id + "','"
							+ st3 + "','" + elxr + "','" +elxdh+ "','"+st4+ "','"
							+ espgg+ "','"+ejldw+ "','"+ espdj+ "','"+espgs+ "','"+st5+ "')");
					Toast.makeText(addOutput.this, "添加成功", Toast.LENGTH_LONG).show();
					seCursor.close();
				}
				
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("username",st6);
				intent.putExtras(bundle);
				intent.setClass(addOutput.this, Menu.class);
				startActivity(intent);
				
			}
		});
		
	}

	private void setViews() {
		sp1 = (Spinner) findViewById(R.id.sp1);
		sp2 = (Spinner) findViewById(R.id.sp2);
		et1 = (EditText) findViewById(R.id.et1);
		et2 = (EditText) findViewById(R.id.et2);
		et3 = (EditText) findViewById(R.id.et3);
		et4 = (EditText) findViewById(R.id.et4);
		et5 = (EditText) findViewById(R.id.et5);
		et6 = (EditText) findViewById(R.id.et6);
		dp1 = (DatePicker) findViewById(R.id.dp1);
		bt1 = (Button)	findViewById(R.id.bt1);
		bt2 = (Button) findViewById(R.id.bt2);
	}

}
