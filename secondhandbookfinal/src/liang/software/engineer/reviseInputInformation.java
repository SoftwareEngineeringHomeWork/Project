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

public class reviseInputInformation extends Activity {
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
	String gsname[];
	String spname[];
	String gs;
	String sp;
	String da;
	int i = 0;
	int j = 0;
	DatePicker date;
	int year;
	int mon;
	int day;
	Calendar c;
	String names;
	private Button bt1;
	private Button bt2;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addinput);
		Intent intent = getIntent();
		names = intent.getStringExtra("chuangzhen");
		book = new sqlOpenHelper(getApplicationContext(), "store.db", null, 1);
		sDatabase = book.getWritableDatabase();
		setViews();
		setListeners();
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		mon = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		da=year+"年"+(mon+1)+"月"+day+"日";
		date = (DatePicker) findViewById(R.id.dp1);
		date.init(year , mon ,day 
				, new OnDateChangedListener()
		{

			@Override
			public void onDateChanged(DatePicker arg0, int year
					, int month, int day)
			{
				reviseInputInformation.this.year = year;
				reviseInputInformation.this.mon = month;
				reviseInputInformation.this.day = day;
				//显示当前日期、时间
				da=year+"年"+(month+1)+"月"+day+"日";

			}
		});

		Cursor cursor = sDatabase.rawQuery("select comname  from gongys", null);
		Cursor cursor1 = sDatabase.rawQuery("select pname  from products", null);
		cursor.moveToFirst();
		cursor1.moveToFirst();
		int count = cursor.getCount();
		int count1 = cursor1.getCount();
		gsname = new String[count];
		spname = new String[count1];
		do {
			try {
				gsname[i] = cursor.getString(0);
				System.out.println(gsname[i]);
				i++;

			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), 
						"有异常", Toast.LENGTH_SHORT).show();
				e.printStackTrace();

			}

		} while (cursor.moveToNext());
		do {
			try {
				spname[j] = cursor1.getString(0);
				System.out.println(spname[j]);
				j++;

			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), 
						"有异常", Toast.LENGTH_SHORT).show();
				e.printStackTrace();

			}

		} while (cursor1.moveToNext());
		BaseAdapter ba = new BaseAdapter() {
			@Override
			public int getCount() {
				// 指定一共包含10个选项
				return gsname.length;
			}

			@Override
			public Object getItem(int position) {
				return null;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}

			// 重写该方法，该方法返回的View将作为列表框的每项
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView text = new TextView(reviseInputInformation.this);
				text.setText(gsname[position]);
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
				return spname.length;
			}

			@Override
			public Object getItem(int position) {
				return null;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}

			// 重写该方法，该方法返回的View将作为列表框的每项
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView text = new TextView(reviseInputInformation.this);
				text.setText(spname[position]);
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
				// TODO Auto-generated method stub
				gs = gsname[arg2];
				Cursor cursor2 = sDatabase.rawQuery("select pername,tel from gongys where comname='"
						+ gs + "'", null);
				cursor2.moveToFirst();
				String name = null;
				String tel = null;
				do {
					try {
						name = cursor2.getString(0);
						tel = cursor2.getString(1);
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), 
								"有异常", Toast.LENGTH_SHORT).show();
						e.printStackTrace();
						name = "";
						tel = "";

					}

				} while (cursor2.moveToNext());
				et1.setText(name);
				et2.setText(tel);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				sp = spname[arg2];
				Cursor cursor3 = sDatabase.rawQuery("select pguige,pdanwei from products where pname='"
						+ sp + "'", null);
				cursor3.moveToFirst();
				String guige = null;
				String danwei = null;
				do {
					try {
						guige = cursor3.getString(0);
						danwei = cursor3.getString(1);
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), 
								"有异常", Toast.LENGTH_SHORT).show();
						e.printStackTrace();
						guige = "";
						danwei = "";

					}

				} while (cursor3.moveToNext());
				et3.setText(guige);
				et4.setText(danwei);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

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
		bt1 = (Button) findViewById(R.id.bt1);
		bt2 = (Button) findViewById(R.id.bt2);		
	}
	private void setListeners() {
		bt1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(et5.getText().toString().equals("")||et6.getText().toString().equals("")){
					Dialog.builder(reviseInputInformation.this, "提示", "请填写完整信息");

				}
				else{

					// 查询语句

					String elxr=et1.getText().toString();
					String elxdh=et2.getText().toString();
					String espgg=et3.getText().toString();
					String ejldw=et4.getText().toString();
					String espdj=et5.getText().toString();
					String espgs=et6.getText().toString();

					// 定义ID
					Cursor seCursor = sDatabase.rawQuery("select max(_id) from ruku", null);
					try {
						seCursor.moveToFirst();
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), 
								"有异常", Toast.LENGTH_SHORT).show();
						e.printStackTrace();
					}
					sDatabase.execSQL("update ruku set comname='"+gs+"',pername='"+elxr+"',tel='"+elxdh+"',products='"+sp+"',guige='"+espgg+"',danwei='"
							+ejldw+"',danjia='"+espdj+"',num='"+espgs+"',date='"+da+"'where _id='"+names+"'"
							);
					Toast.makeText(reviseInputInformation.this, "修改成功", Toast.LENGTH_LONG).show();

					seCursor.close();


				}

			}
		});
		bt2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("username",names);
				intent.putExtras(bundle);
				intent.setClass(reviseInputInformation.this, Menu.class);
				startActivity(intent);			
			}
		});		
	}

}
