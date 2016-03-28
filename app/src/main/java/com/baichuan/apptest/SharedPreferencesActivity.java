package com.baichuan.apptest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/3/28.
 */
public class SharedPreferencesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);
//        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(SharedPreferencesActivity.this);
        SharedPreferences pref = getSharedPreferences("myPref", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString("name", "张三");
        edit.putInt("age", 30);
        edit.putLong("time", System.currentTimeMillis());
        edit.putBoolean("default", true);
        edit.commit();
        edit.remove("default");
        edit.commit();
        System.out.println(pref.getString("name", ""));
    }
}
