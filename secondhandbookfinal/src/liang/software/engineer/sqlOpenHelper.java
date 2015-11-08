package liang.software.engineer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlOpenHelper extends SQLiteOpenHelper{
	/*
	 * �������
	 */
	// �����û���
	String createUserTable = "create table user_info(_id int auto_increment,username char(20),"
			+ "password char(20),num char(20),primary key('_id'));";
	// ������Ʒ��
	String creatproductsTable = "create Table products(_id int auto_increment,"
			+ "pname char(40),pguige char(20),pdanwei char(20),primary key('_id'));";
	// �����˿ͱ�
	String createguke = "create table guke(_id int auto_increment,"
			+ "comname char(40),pername char(40),addr char(40),"
			+ "city char(20),diqu char(40),youbian char(20),tel char(20),"
			+ "chuangzhen char(20),web char(40),primary key('_id'));";
	// ������Ӧ�̱�
	String creategongyings = "create table gongys(_id int auto_increment,"
			+ "comname char(40),pername char(40),addr char(40),"
			+ "city char(20),diqu char(40),youbian char(20),tel char(20),"
			+ "chuangzhen char(20),web char(40),primary key('_id'));";
	//���������
	String createruku = "create table ruku(_id int auto_increment,"
			+ "comname char(40),pername char(40),tel char(40),"
			+ "products char(40),guige char(40),danwei char(20),danjia int,"
			+ "num int,date char(40),primary key('_id'));";
	//��������
	String createchuku = "create table chuku(_id int auto_increment,"
			+ "comname char(40),pername char(40),tel char(40),"
			+ "products char(40),guige char(40),danwei char(20),danjia int,"
			+ "num int,date char(40),primary key('_id'));";
	//��������
	String createkucun = "create Table kucun(_id int auto_increment,"
			+ "pname char(40),pguige char(20),pdanwei char(20),num int,primary key('_id'));";
	// �����û���������
	String insertStr = "insert into user_info(_id,username,password,num) values(?,?,?,?)";
	// ������Ʒ��������
	String insertproducts = "insert into products values(?,?,?,?);";
	// ����˿ͱ�������
	String insertguke = "insert into guke values(?,?,?,?,?,?,?,?,?,?);";
	// ���幩Ӧ�̱�������
	String insertgys = "insert into gongys values(?,?,?,?,?,?,?,?,?,?);";
	//��������������
	String insertruku = "insert into ruku values(?,?,?,?,?,?,?,?,?,?);";
	//��������������
	String insertchuku = "insert into chuku values(?,?,?,?,?,?,?,?,?,?);";
	//�������������
	String insertkucun = "insert into kucun values(?,?,?,?,?);";


	public sqlOpenHelper(Context context, String name, CursorFactory factory,
			int version)
	{
		super(context, name, factory, version);

	}

	@Override
	public void onCreate(SQLiteDatabase arg0)
	{
		// ����ID
		// �����û�������Ʒ���˿ͱ����������
		arg0.execSQL(createUserTable);
		arg0.execSQL(creatproductsTable);
        arg0.execSQL(createguke);
        arg0.execSQL(creategongyings);
        arg0.execSQL(createruku);
        arg0.execSQL(createchuku);
        arg0.execSQL(createkucun);

		// �������data
		String[] insertValue1 = { "0", "liang", "liang", "3112",};
		String[] insertValue2 = { "1", "ke", "ke", "3113", };
		String[] insertValue3 = { "2", "zeng", "zeng", "3114", };
		String[] insertValue5 = { "0", "�������", "��е������", "���İ�"};
	//	String[] insguke={"1","������","2012","����304","������","�㹤","13611155211","666666","49771212","485579781"};
	//	String[] insmaijia={"1","��ͤ","","����421","","�㹤","13600000000","611111","497712121","48554312"};
	//	String[] insshougou={"1","��ͤ","","13600000000","","611111","���ݽṹ","��","12","�㹤","100","2012-2-2"};
	//	String[] inschuku={"1","С��","","13600000000","","611111","�����߼�","��","20","�㹤","1","2015-10-2"};
		arg0.execSQL(insertStr, insertValue1);
	//	arg0.execSQL(insertUser, insertValue2);
	//	arg0.execSQL(insertUser, insertValue3);
		arg0.execSQL(insertproducts, insertValue5);
	//	arg0.execSQL(insertBuyer, insguke);
	//	arg0.execSQL(insertSeller, insmaijia);
	//	arg0.execSQL(insertBuyout, insshougou);
	//	arg0.execSQL(insertSellBooks, inschuku);	
			}

	@Override
	public void onUpgrade(SQLiteDatabase book, int oldVersion, int newVersion) {
		System.out.println("update a Database"); 
	}


}