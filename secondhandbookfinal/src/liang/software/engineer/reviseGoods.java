package liang.software.engineer;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import liang.software.engineer.R;


import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;



public class reviseGoods extends Activity {
	private ListView listview;

	String id[];
	String name[];
	String pass[];
	String num[];
	sqlOpenHelper book;
	int i = 0;
	SQLiteDatabase sDatabase = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deletegoods);
		setTitle("修改二手书");
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		book = new sqlOpenHelper(getApplicationContext(), "store.db", null, 1);
		sDatabase = book.getWritableDatabase();
		listview = (ListView) findViewById(R.id.lv1);
		List<Map<String, Object>> slist = new ArrayList<Map<String, Object>>();
		Cursor cursor = sDatabase.rawQuery("select _id,pname,pguige,pdanwei  from products", null);
		cursor.moveToFirst();
		int count = cursor.getCount();
		pass = new String[count];
		num = new String[count];
		id = new String[count];
		name = new String[count];
		do {
			try {
				id[i] = cursor.getString(0);
				name[i] = cursor.getString(1);
				pass[i] = cursor.getString(2);
				num[i] = cursor.getString(3);
				i++;

			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), 
						"有异常", Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}

		} while (cursor.moveToNext());

		for (int i = 0; i < id.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("did", id[i]);
			map.put("dname", name[i]);
			map.put("dpass", pass[i]);
			map.put("dnum", num[i]);
			slist.add(map);
		}
		SimpleAdapter simple = new SimpleAdapter(this, slist,
				R.layout.useradap, new String[] { "did", "dname", "dpass",
						"dnum" }, new int[] { R.id.tv1, R.id.tv2, R.id.tv3,
						R.id.tv4, });
		listview.setAdapter(simple);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				for(int i=0;i<name.length;i++){
					if(arg2==i){
						
						builder.setTitle("确认消息");
						builder.setMessage("确定要修改该二手书吗？");
						final int j=i;
						builder.setPositiveButton("确定", new OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {					
					
								Intent intent=new Intent();
								Bundle bundle = new Bundle();
								bundle.putString("comname",name[j]);
								intent.putExtras(bundle);
								intent.setClass(reviseGoods.this, reviseGoodsInformation.class);
								startActivity(intent);
								finish();
								
							}
						});
						builder.setNegativeButton("取消", new OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Toast.makeText(getApplicationContext(), 
										"你按了取消", Toast.LENGTH_SHORT).show();	
								
								
							}
						});
						builder.create().show();
						
					}
					
				}
				
			}
		});
	}

}
