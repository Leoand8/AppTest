package com.baichuan.apptest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/3/28.
 */
public class SharedPreferencesActivity extends AppCompatActivity {

    EditText etUserName, etUserPass;
    CheckBox chk;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);
//        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(SharedPreferencesActivity.this);
//        SharedPreferences pref = getSharedPreferences("myPref", MODE_PRIVATE);
//        SharedPreferences.Editor edit = pref.edit();
//        edit.putString("name", "张三");
//        edit.putInt("age", 30);
//        edit.putLong("time", System.currentTimeMillis());
//        edit.putBoolean("default", true);
//        edit.commit();
//        edit.remove("default");
//        edit.commit();
//        System.out.println(pref.getString("name", ""));

        etUserName = (EditText) findViewById(R.id.sp_user_name);
        etUserPass = (EditText) findViewById(R.id.sp_user_password);
        chk = (CheckBox) findViewById(R.id.sp_checkbox);
        pref = getSharedPreferences("UserInfo", MODE_PRIVATE);
        editor = pref.edit();
        String name = pref.getString("userName", "");
        if (name == null) {
            chk.setChecked(false);
        } else {
            chk.setChecked(true);
            etUserName.setText(name);
        }
    }

    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.sp_btn_login:
                String name = etUserName.getText().toString().trim();
                String pass = etUserPass.getText().toString().trim();
                if ("admin".equals(name) && "123456".equals(pass)) {
                    //进行登陆操作
                    Toast.makeText(SharedPreferencesActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    //如果勾选保存用户名则进行保存
                    if (chk.isChecked()) {
                        editor.putString("userName", name);
                        editor.commit();
                        Toast.makeText(SharedPreferencesActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                    } else {
                        //不勾选则移除用户名
                        editor.remove("userName");
                        editor.commit();
                    }
                } else {
                    //如果用户名或密码不匹配
                    Toast.makeText(SharedPreferencesActivity.this, "禁止登陆", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
