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


public class addSupplier extends Activity {
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
	String st1;
	private Button bt1;
	private Button bt2;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addsupplier);
		setTitle("���������Ϣ");
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
		et4=(EditText) findViewById(R.id.et4);
		et3=(EditText) findViewById(R.id.et3);
		et5=(EditText) findViewById(R.id.et5);
		et6=(EditText) findViewById(R.id.et6);
		et7=(EditText) findViewById(R.id.et7);
		et8=(EditText) findViewById(R.id.et8);
		et9=(EditText) findViewById(R.id.et9);
		bt1=(Button)findViewById(R.id.bt1);
		bt2=(Button)findViewById(R.id.bt2);
	}	
	private void setListeners() {
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(et1.getText().toString().equals("")){
					Dialog.builder(addSupplier.this, "��ʾ", "��������������");
				}
				else{
					String egsmc=et1.getText().toString();
					String elxr=et2.getText().toString();
					String elxdz=et3.getText().toString();
					String ecsmc=et4.getText().toString();
					String edqmc=et5.getText().toString();
					String eyzbm=et6.getText().toString();
					String elxdh=et7.getText().toString();
					String eczhm=et8.getText().toString();
					String egszy=et9.getText().toString();
					Cursor cursor = sDatabase.rawQuery("select comname  from gongys", null);
					cursor.moveToFirst();
					String nameg = null;

					do {
						try {
							nameg = cursor.getString(0);
						} catch (Exception e) {
							Toast.makeText(getApplicationContext(), 
									"���쳣", Toast.LENGTH_SHORT).show();
							e.printStackTrace();
							nameg = "";

						}
						if (nameg.equals(egsmc)) {
							Dialog.builder(addSupplier.this, "������Ϣ","��������Ϣ�Ѵ���");
							cursor.close();
							break;

						}
					} while (cursor.moveToNext());

					if (!nameg.equals(egsmc)) {
						// ����ID
						int id = 0;
						Cursor seCursor = sDatabase.rawQuery("select max(_id) from gongys", null);
						try {
							seCursor.moveToFirst();
							id = Integer.parseInt(seCursor.getString(0));
							id += 1;
						} catch (Exception e) {
							Toast.makeText(getApplicationContext(), 
									"���쳣", Toast.LENGTH_SHORT).show();
							e.printStackTrace();
							id = 0;
						}
						sDatabase.execSQL("insert into gongys values('" + id + "','"
								+ egsmc + "','" + elxr + "','" +elxdz+ "','"+ecsmc+ "','"
								+ edqmc+ "','"+eyzbm+ "','"+ elxdh+ "','"+eczhm+ "','"+egszy+ "')");
						Toast.makeText(addSupplier.this, "��ӳɹ�", Toast.LENGTH_LONG).show();
						seCursor.close();


					}
				}			
			}
		});
		bt2.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("username",st1);
				intent.putExtras(bundle);
				intent.setClass(addSupplier.this, Menu.class);
				startActivity(intent);
				
			}
		});

	}


}
