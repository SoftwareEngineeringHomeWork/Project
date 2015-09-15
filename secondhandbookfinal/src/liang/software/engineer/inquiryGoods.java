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


public class inquiryGoods extends Activity {
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
		setTitle("查询二手书");
		book = new sqlOpenHelper(getApplicationContext(), "store.db", null, 1);
		sDatabase = book.getWritableDatabase();
		listview = (ListView) findViewById(R.id.lv1);
		List<Map<String, Object>> slist = new ArrayList<Map<String, Object>>();
		String selectStr = "select _id,pname,pguige,pdanwei  from products";
		Cursor cursor = sDatabase.rawQuery(selectStr, null);

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
						"无数据", Toast.LENGTH_SHORT).show();
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

	}

}
