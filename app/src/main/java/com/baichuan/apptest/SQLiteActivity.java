package com.baichuan.apptest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Administrator on 2016/3/28.
 */
public class SQLiteActivity extends AppCompatActivity {

    public static final String TABLENAME = "stutb";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

//        //外部类处理数据库
//        DBOpenHelper helper = new DBOpenHelper(SQLiteActivity.this, "stu.db");
//        helper.getReadableDatabase();//获取一个只读的数据库
//        SQLiteDatabase db = helper.getWritableDatabase();
//        Cursor c = db.rawQuery("select * from stutb", null);
//        if (c != null) {
//            String[] cols = c.getColumnNames();
//            while (c.moveToNext()) {
//                for (String ColumnName : cols) {
//                    Log.i("info", "onCreate: "+ColumnName+":"+c.getString(c.getColumnIndex(ColumnName)));
//                }
//            }
//            c.close();
//        }
//        db.close();


        //每个程序的数据库都是唯一的，每个程序都有自己的数据库，默认情况下是各自互相不干扰
        //创建一个数据库并且打开
        SQLiteDatabase db = openOrCreateDatabase("stu.db", MODE_PRIVATE, null);
        db.execSQL("create table if not exists "+TABLENAME+" (_id integer primary key autoincrement, name text not null, sex text not null, age integer not null)");
//        db.execSQL("insert into usertb(name, sex, age) values('张三','女',18)");
//        db.execSQL("insert into usertb(name, sex, age) values('李四','女',19)");
//        db.execSQL("insert into usertb(name, sex, age) values('王五','男',20)");
        ContentValues values = new ContentValues();
        values.put("name","张三");
        values.put("sex","男");
        values.put("age",19);
        long rowId = db.insert(TABLENAME, null, values);
        values.clear();

        values.put("name","张三丰");
        values.put("sex","男");
        values.put("age",99);
        db.insert(TABLENAME, null, values);
        values.clear();

        values.put("name","张三疯");
        values.put("sex","男");
        values.put("age",59);
        db.insert(TABLENAME, null, values);
        values.clear();

        values.put("name","张三峰");
        values.put("sex","男");
        values.put("age",39);
        db.insert(TABLENAME, null, values);
        values.clear();

        values.put("name","张三封");
        values.put("sex","男");
        values.put("age",29);
        db.insert(TABLENAME, null, values);

        values.put("sex","女");

        //将全部id>3的人的性别改成女
        db.update(TABLENAME,values,"_id>?",new String[]{"3"});
        //删除所有名字中带有丰的人
        db.delete(TABLENAME, "name like ?", new String[]{"%丰%"});
        //查询结果按名字排序
        Cursor c = db.query(TABLENAME, null, "_id>?", new String[]{"0"}, null, null, "name");
        if (c != null) {
            String[] colums = c.getColumnNames();
            while (c.moveToNext()) {
                for (String columnName : colums) {
                    Log.i("info", "onCreate: "+c.getString(c.getColumnIndex(columnName)));
                }
            }
            c.close();
        }
        db.close();

//        Cursor cursor = db.rawQuery("select * from usertb", null);
//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//                Log.i("sqlite", "_id: " + cursor.getInt(cursor.getColumnIndex("_id")));
//                Log.i("sqlite", "name: " + cursor.getString(cursor.getColumnIndex("name")));
//                Log.i("sqlite", "age: " + cursor.getInt(cursor.getColumnIndex("age")));
//                Log.i("sqlite", "sex: " + cursor.getString(cursor.getColumnIndex("sex")));
//            }
//        }
    }
}
