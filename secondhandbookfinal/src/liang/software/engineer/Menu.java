package liang.software.engineer;

import java.util.ArrayList;
import liang.software.engineer.R;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;


public class Menu extends TabActivity {

	private RadioButton rb4;

	private RadioButton rb6;

	private RadioButton rb5;

	private RadioButton rb7;

	private RadioButton rb8;

	private RadioButton rb10;

	private RadioButton rb9;

	private RadioButton rb11;

	private RadioButton rb12;

	private RadioButton rb14;

	private RadioButton rb13;

	private RadioButton rb15;

	private RadioButton rb19;

	private RadioButton rb21;

	private RadioButton rb20;

	private RadioButton rb22;

	private RadioButton rb24;

	private RadioButton rb23;

	private RadioButton rb25;
	String names=null;
	private String[] grade;
	private String[] major;
	private Spinner sp1;
	private Spinner sp2;
	private Button bt1;
	private ListView lv1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    TabHost tab=getTabHost();
	    tab.setPadding(0, -20, 0, 0);
	    tab.setBackgroundColor(111111);
	    tab.setDrawingCacheBackgroundColor(Color.BLUE);
	    TabWidget tw = tab.getTabWidget(); 	    
	    LayoutInflater inf=getLayoutInflater();
	    inf.inflate(R.layout.menu1, tab.getTabContentView());
	  
	    Bundle name=getIntent().getExtras();
	    names=name.getString("username");

	   setViews();

	    final TabHost.TabSpec tabs1 = tab.newTabSpec("������Ϣ");
	    tabs1.setContent(R.id.li1);
		tabs1.setIndicator("������Ϣ", getResources().getDrawable(R.color.red));
		final TabHost.TabSpec tabs2 = tab.newTabSpec("����������");
		   tabs2.setContent(R.id.li2);
		tabs2.setIndicator("����������", getResources().getDrawable(R.color.red));

		 final TabHost.TabSpec tabs4 = tab.newTabSpec("�γ̲�ѯ");
	   	    tabs4.setContent(R.id.li4);	   	     
	   	    tabs4.setIndicator("�γ̲�ѯ", getResources().getDrawable(R.color.red));
		final TabHost.TabSpec tabs5 = tab.newTabSpec("�û�������");
		    tabs5.setContent(R.id.li5);
			tabs5.setIndicator("�û�������", getResources().getDrawable(R.color.red));
	
		tab.addTab(tabs1);
	//	tab.addTab(tabs3);
		tab.addTab(tabs4);
		tab.addTab(tabs5);
		for(int i = 0; i < tw.getChildCount(); i++){  
          View view = tw.getChildTabViewAt(i);  
	           view.setBackgroundDrawable(getResources().getDrawable(R.drawable.p1));  
	            TextView textView = (TextView)view.findViewById(android.R.id.title);  
	            textView.setGravity(BIND_AUTO_CREATE);  
	            if(i==0||i==1||i==2||i==3||i==4){  
	                textView.setTextColor(getResources().getColor(android.R.color.black));  
	            }
	            textView.setTextSize(20);  
	       }  
		setData();
		setView();
		setListeners();
		
	}

	private void setViews() {
		 rb4=(RadioButton) findViewById(R.id.rb4);
		    rb6=(RadioButton) findViewById(R.id.rb6);
		    rb5=(RadioButton) findViewById(R.id.rb5);
		    rb7=(RadioButton) findViewById(R.id.rb7);
		    rb8=(RadioButton) findViewById(R.id.rb8);
		    rb10=(RadioButton) findViewById(R.id.rb10);
		    rb9=(RadioButton) findViewById(R.id.rb9);
		    rb11=(RadioButton) findViewById(R.id.rb11);
		    rb12=(RadioButton) findViewById(R.id.rb12);
		    rb14=(RadioButton) findViewById(R.id.rb14);
		    rb13=(RadioButton) findViewById(R.id.rb13);
		    rb15=(RadioButton) findViewById(R.id.rb15);
		    rb19=(RadioButton) findViewById(R.id.rb19);
		    rb21=(RadioButton) findViewById(R.id.rb21);
		    rb20=(RadioButton) findViewById(R.id.rb20);
		    rb22=(RadioButton) findViewById(R.id.rb22);
		    rb24=(RadioButton) findViewById(R.id.rb24);
		    rb24=(RadioButton) findViewById(R.id.rb24);
		    rb23=(RadioButton) findViewById(R.id.rb23);
		    rb25=(RadioButton) findViewById(R.id.rb25);
		    bt1 =(Button)findViewById(R.id.bt1);
		
	}



	public void ershoushu(View v){
		rb4.setVisibility(View.VISIBLE);
		rb6.setVisibility(View.VISIBLE);
		rb5.setVisibility(View.VISIBLE);
		rb7.setVisibility(View.VISIBLE);
		rb8.setVisibility(View.INVISIBLE);
		rb10.setVisibility(View.INVISIBLE);
		rb9.setVisibility(View.INVISIBLE);
		rb11.setVisibility(View.INVISIBLE);
		rb12.setVisibility(View.INVISIBLE);
		rb14.setVisibility(View.INVISIBLE);
		rb13.setVisibility(View.INVISIBLE);
		rb15.setVisibility(View.INVISIBLE);
	}
	

	public void seller(View v){
		rb12.setVisibility(View.VISIBLE);
		rb14.setVisibility(View.VISIBLE);
		rb13.setVisibility(View.VISIBLE);
		rb15.setVisibility(View.VISIBLE);
		rb8.setVisibility(View.INVISIBLE);
		rb10.setVisibility(View.INVISIBLE);
		rb9.setVisibility(View.INVISIBLE);
		rb11.setVisibility(View.INVISIBLE);
		rb4.setVisibility(View.INVISIBLE);
		rb6.setVisibility(View.INVISIBLE);
		rb5.setVisibility(View.INVISIBLE);
		rb7.setVisibility(View.INVISIBLE);
	}

	public void buyer(View v){
		rb8.setVisibility(View.VISIBLE);
		rb10.setVisibility(View.VISIBLE);
		rb9.setVisibility(View.VISIBLE);
		rb11.setVisibility(View.VISIBLE);
		rb4.setVisibility(View.INVISIBLE);
		rb6.setVisibility(View.INVISIBLE);
		rb5.setVisibility(View.INVISIBLE);
		rb7.setVisibility(View.INVISIBLE);
		rb12.setVisibility(View.INVISIBLE);
		rb14.setVisibility(View.INVISIBLE);
		rb13.setVisibility(View.INVISIBLE);
		rb15.setVisibility(View.INVISIBLE);
	}


	public void buyoutBooks(View v){
		rb19.setVisibility(View.VISIBLE);
		rb21.setVisibility(View.VISIBLE);
		rb20.setVisibility(View.VISIBLE);
		rb22.setVisibility(View.VISIBLE);
		rb24.setVisibility(View.INVISIBLE);
		rb24.setVisibility(View.INVISIBLE);
		rb23.setVisibility(View.INVISIBLE);
		rb25.setVisibility(View.INVISIBLE);
		
	}


	public void sellBooks(View v){
		rb24.setVisibility(View.VISIBLE);
		rb24.setVisibility(View.VISIBLE);
		rb23.setVisibility(View.VISIBLE);
		rb25.setVisibility(View.VISIBLE);
		rb19.setVisibility(View.INVISIBLE);
		rb21.setVisibility(View.INVISIBLE);
		rb20.setVisibility(View.INVISIBLE);
		rb22.setVisibility(View.INVISIBLE);
		
	}

	public void addSeller(View v){
		Intent intent=new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("username",names);
		intent.putExtras(bundle);
		intent.setClass(getApplicationContext(), addSupplier.class);
		startActivity(intent);
	
	}

	public void inquirySeller(View v){
		Intent intent=new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("username",names);
		intent.putExtras(bundle);
		intent.setClass(getApplicationContext(), inquirySupplier.class);
		startActivity(intent);
	
	}

	public void addBuyout(View v){
		
		Intent intent=new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("username",names);
		intent.putExtras(bundle);
		intent.setClass(getApplicationContext(), addInput.class);
		startActivity(intent);
		
	}

	public void inquiryBuyout(View v){
		
		
		Intent intent=new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("username",names);
		intent.putExtras(bundle);
		intent.setClass(getApplicationContext(), inquiryInput.class);
		startActivity(intent);
		
	}

	public void addBooks(View v){
		Intent intent=new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("username",names);
		intent.putExtras(bundle);
		intent.setClass(getApplicationContext(), addGoods.class);
		startActivity(intent);
		
	}

	public void addBuyer(View v){
		Intent intent=new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("username",names);
		intent.putExtras(bundle);
		intent.setClass(getApplicationContext(), addCustomer.class);
		startActivity(intent);
	
	}

	public void inquiryBuyer(View v){
		Intent intent=new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("username",names);
		intent.putExtras(bundle);
		intent.setClass(getApplicationContext(), inquiryCustomer.class);
		startActivity(intent);
	
	}

	public void addSellBooks(View v){
		Intent intent=new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("username",names);
		intent.putExtras(bundle);
		intent.setClass(getApplicationContext(), addOutput.class);
		startActivity(intent);
	}

	public void inquirySellBooks(View v){
		Intent intent=new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("username",names);
		intent.putExtras(bundle);
		intent.setClass(getApplicationContext(), inquiryOutput.class);
		startActivity(intent);
	}

	public void password(View v){
		Intent intent=new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("username",names);
		intent.putExtras(bundle);
		intent.setClass(getApplicationContext(),revisePassword.class);
		startActivity(intent);
	}


	public void user(View v){
		
		Intent intent=new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("username",names);
		intent.putExtras(bundle);
		intent.setClass(getApplicationContext(),user.class);
		startActivity(intent);
	}

	public void deleteBooks(View v){
		Intent intent=new Intent();
		intent.setClass(Menu.this, deleteGoods.class);
		startActivity(intent);
	}

	public void deleteBuyer(View v){
		Intent intent=new Intent();
		intent.setClass(Menu.this, deleteCustomer.class);
		startActivity(intent);
	}

	public void inquiryBooks(View v){
		Intent intent=new Intent();
		intent.setClass(Menu.this, inquiryGoods.class);
		startActivity(intent);
	}

	public void deleteSeller(View v){
		Intent intent=new Intent();
		intent.setClass(Menu.this, deleteSupplier.class);
		startActivity(intent);
	}

	public void reviseBooks(View v){
		Intent intent=new Intent();
		intent.setClass(Menu.this, reviseGoods.class);
		startActivity(intent);
	}

	public void reviseBuyer(View v){
		Intent intent=new Intent();
		intent.setClass(Menu.this, reviseCustomer.class);
		startActivity(intent);
	}

	public void reviseSeller(View v){
		Intent intent=new Intent();
		intent.setClass(Menu.this, reviseSupplier.class);
		startActivity(intent);
	}

	public void deleteSellBooks(View v){
		Intent intent=new Intent();
		intent.setClass(Menu.this, deleteOutput.class);
		startActivity(intent);
	}

	public void deleteBuyout(View v){
		Intent intent=new Intent();
		intent.setClass(Menu.this, deleteInput.class);
		startActivity(intent);
	}

	public void reviseBuyout(View v){
		Intent intent=new Intent();
		intent.setClass(Menu.this, reviseInput.class);
		startActivity(intent);
	}

	public void reviseSellBooks(View v){
		Intent intent=new Intent();
		intent.setClass(Menu.this, reviseOutput.class);
		startActivity(intent);
	}

	public void allowance(View v){
		Intent intent=new Intent();
		intent.setClass(Menu.this, storage.class);
		startActivity(intent);
	}
	//�γ̲�ѯ
	
	private void setListeners() {
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				classEnquiry();
				
			}
		});
}
	public void classEnquiry(){
		String grade =
				(String) sp1.getSelectedItem();
		String major = (String) sp2.getSelectedItem();
		
		ArrayList<String> a = new ArrayList<String>();
		a = classList.getClassList(grade,major);
		ArrayAdapter<String> adapter3 = 
				new ArrayAdapter<String>
		(this, android.R.layout.simple_list_item_1,
				a);
		lv1.setAdapter(adapter3);
		
	}
	private void setData() {
		grade = new String[]{
				"��һ(��)","��һ(��)","���(��)","���(��)","����(��)","����(��)","����(��)","����(��)"
		};
		major = new String[]{
				"����������","�Զ���","�������̼����Զ���(����)","�������̼����Զ���(����)","������Ϣ��ѧ�뼼��"
		};
		
	}
	private void setView() {
			sp1 = (Spinner) findViewById(R.id.sp1);
			sp2 = (Spinner) findViewById(R.id.sp2);
			bt1 = (Button) findViewById(R.id.bt1);
			lv1 = (ListView) findViewById(R.id.lv1);
			ArrayAdapter<String> adapter1 = 
					new ArrayAdapter<String>(this,
							android.R.layout.simple_spinner_item,
							grade);
			ArrayAdapter<String> adapter2 = 
					new ArrayAdapter<String>(this,
							android.R.layout.simple_spinner_item,
							major);
			adapter1.setDropDownViewResource
			(android.R.layout.simple_dropdown_item_1line);
			adapter2.setDropDownViewResource
			(android.R.layout.simple_dropdown_item_1line);
			sp1.setAdapter(adapter1);
			sp2.setAdapter(adapter2);
		
	}
	
}
