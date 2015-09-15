package liang.software.engineer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlOpenHelper extends SQLiteOpenHelper{
	/*
	 * 创建语句
	 */
	// 创建用户表
	String createUserTable = "create table user_info(_id int auto_increment,username char(20),"
			+ "password char(20),num char(20),primary key('_id'));";
	// 创建商品表
	String creatproductsTable = "create Table products(_id int auto_increment,"
			+ "pname char(40),pguige char(20),pdanwei char(20),primary key('_id'));";
	// 创建顾客表
	String createguke = "create table guke(_id int auto_increment,"
			+ "comname char(40),pername char(40),addr char(40),"
			+ "city char(20),diqu char(40),youbian char(20),tel char(20),"
			+ "chuangzhen char(20),web char(40),primary key('_id'));";
	// 创建供应商表
	String creategongyings = "create table gongys(_id int auto_increment,"
			+ "comname char(40),pername char(40),addr char(40),"
			+ "city char(20),diqu char(40),youbian char(20),tel char(20),"
			+ "chuangzhen char(20),web char(40),primary key('_id'));";
	//创建出库表
	String createruku = "create table ruku(_id int auto_increment,"
			+ "comname char(40),pername char(40),tel char(40),"
			+ "products char(40),guige char(40),danwei char(20),danjia int,"
			+ "num int,date char(40),primary key('_id'));";
	//创建入库表
	String createchuku = "create table chuku(_id int auto_increment,"
			+ "comname char(40),pername char(40),tel char(40),"
			+ "products char(40),guige char(40),danwei char(20),danjia int,"
			+ "num int,date char(40),primary key('_id'));";
	//创建库存表
	String createkucun = "create Table kucun(_id int auto_increment,"
			+ "pname char(40),pguige char(20),pdanwei char(20),num int,primary key('_id'));";
	// 定义用户表插入语句
	String insertStr = "insert into user_info(_id,username,password,num) values(?,?,?,?)";
	// 定义商品表插入语句
	String insertproducts = "insert into products values(?,?,?,?);";
	// 定义顾客表插入语句
	String insertguke = "insert into guke values(?,?,?,?,?,?,?,?,?,?);";
	// 定义供应商表插入语句
	String insertgys = "insert into gongys values(?,?,?,?,?,?,?,?,?,?);";
	//定义入库表插入语句
	String insertruku = "insert into ruku values(?,?,?,?,?,?,?,?,?,?);";
	//定义出库表插入语句
	String insertchuku = "insert into chuku values(?,?,?,?,?,?,?,?,?,?);";
	//定义库存表插入语句
	String insertkucun = "insert into kucun values(?,?,?,?,?);";


	public sqlOpenHelper(Context context, String name, CursorFactory factory,
			int version)
	{
		super(context, name, factory, version);

	}

	@Override
	public void onCreate(SQLiteDatabase arg0)
	{
		// 设置ID
		// 创建用户表，用商品表，顾客表，入库表。出库表
		arg0.execSQL(createUserTable);
		arg0.execSQL(creatproductsTable);
        arg0.execSQL(createguke);
        arg0.execSQL(creategongyings);
        arg0.execSQL(createruku);
        arg0.execSQL(createchuku);
        arg0.execSQL(createkucun);

		// 插入测试data
		String[] insertValue1 = { "0", "liang", "liang", "3112",};
		String[] insertValue2 = { "1", "ke", "ke", "3113", };
		String[] insertValue3 = { "2", "zeng", "zeng", "3114", };
		String[] insertValue5 = { "0", "软件工程", "机械出版社", "第四版"};
	//	String[] insguke={"1","柯煜铭","2012","西九304","物联网","广工","13611155211","666666","49771212","485579781"};
	//	String[] insmaijia={"1","南亭","","西八421","","广工","13600000000","611111","497712121","48554312"};
	//	String[] insshougou={"1","南亭","","13600000000","","611111","数据结构","无","12","广工","100","2012-2-2"};
	//	String[] inschuku={"1","小花","","13600000000","","611111","数据逻辑","无","20","广工","1","2015-10-2"};
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