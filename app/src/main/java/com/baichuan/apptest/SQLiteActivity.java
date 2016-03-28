package com.baichuan.apptest;

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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        //每个程序的数据库都是唯一的，每个程序都有自己的数据库，默认情况下是各自互相不干扰
        //创建一个数据库并且打开
        SQLiteDatabase db = openOrCreateDatabase("user.db", MODE_PRIVATE, null);
        db.execSQL("create table if not exists usertb (_id integer primary key autoincrement, name text not null, age integer not null, sex text not null)");
        db.execSQL("insert into usertb(name, sex, age) values('张三','女',18)");
        db.execSQL("insert into usertb(name, sex, age) values('李四','女',19)");
        db.execSQL("insert into usertb(name, sex, age) values('王五','男',20)");

        Cursor cursor = db.rawQuery("select * from usertb", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Log.i("sqlite", "_id: " + cursor.getInt(cursor.getColumnIndex("_id")));
                Log.i("sqlite", "name: " + cursor.getString(cursor.getColumnIndex("name")));
                Log.i("sqlite", "age: " + cursor.getInt(cursor.getColumnIndex("age")));
                Log.i("sqlite", "sex: " + cursor.getString(cursor.getColumnIndex("sex")));
            }
        }
    }
}
