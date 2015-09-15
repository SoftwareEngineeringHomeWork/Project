package liang.software.engineer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import liang.software.engineer.R;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;



public class inquiryCustomer extends Activity {
	private ListView listview;

	String id[];
	String cname[];
	String pname[];
	String add[];
	String city[];
	String diqu[];
	String youbian[];
	String tel[];
	String chuanzhen[];
	String web[];

	sqlOpenHelper book;
	int i = 0;
	SQLiteDatabase sDatabase = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inquirycustomer);
		setTitle("查询买家");
		book = new sqlOpenHelper(getApplicationContext(), "store.db", null, 1);
		sDatabase = book.getWritableDatabase();
		listview = (ListView) findViewById(R.id.lv1);
		List<Map<String, Object>> slist = new ArrayList<Map<String, Object>>();
		String selectStr = "select _id,comname,pername,addr,city,diqu,youbian,tel,chuangzhen,web  from guke";
		Cursor cursor = sDatabase.rawQuery(selectStr, null);
		cursor.moveToFirst();
		int count = cursor.getCount();
		id = new String[count];
		cname = new String[count];
		pname= new String[count];
		add= new String[count];
		city= new String[count];
		diqu = new String[count];
		youbian= new String[count];
		tel= new String[count];
		chuanzhen= new String[count];
		web = new String[count];
		do {
			try {
				id[i] = cursor.getString(0);
				cname[i] = cursor.getString(1);
				pname[i] = cursor.getString(2);
				add[i] = cursor.getString(3);
				city[i] = cursor.getString(4);
				diqu[i] = cursor.getString(5);
				youbian[i] = cursor.getString(6);
				tel[i] = cursor.getString(7);
				chuanzhen[i] = cursor.getString(8);
				web[i] = cursor.getString(9);

				i++;

			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), 
						"无数据", Toast.LENGTH_SHORT).show();
				e.printStackTrace();

			}

		} while (cursor.moveToNext());

		for (int i = 0; i < id.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id[i]);
			map.put("cname", cname[i]);
			map.put("pname", pname[i]);
			map.put("add", add[i]);
			map.put("city", city[i]);
			map.put("diqu", diqu[i]);
			map.put("youbian", youbian[i]);
			map.put("tel", tel[i]);
			map.put("chuanzhen", chuanzhen[i]);
			map.put("web", web[i]);
			slist.add(map);
		}
		SimpleAdapter simple = new SimpleAdapter(this, slist,
				R.layout.outputinformationadp, new String[] { "id", "cname", "pname",
				"add" ,"city","diqu","youbian","tel","chuanzhen","web"}, new int[] { R.id.tv1, R.id.tv2, R.id.tv3,
				R.id.tv4, R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9,R.id.tv10,});
		listview.setAdapter(simple);

	}

}
