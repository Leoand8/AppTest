package com.baichuan.apptest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.baichuan.fragment.FragmentActivity2;
import com.baichuan.fragment.FragmentActivity3;
import com.baichuan.fragment.FragmentActivity4;
import com.baichuan.fragment.MyFragment2;


/**
 * Created by Administrator on 2016/3/16.
 */
public class FragmentActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup group;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        group = (RadioGroup) findViewById(R.id.radiogroup);
        group.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radioButton1:
                Intent intent=new Intent(this, FragmentActivity2.class);
                startActivity(intent);
                break;

            case R.id.radioButton2:
                MyFragment2 fragment2=new MyFragment2();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                beginTransaction.add(R.id.frame,fragment2);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;

            case R.id.radioButton3:
                Intent intent1=new Intent(FragmentActivity.this,FragmentActivity3.class);
                startActivity(intent1);
                break;

            case R.id.radioButton4:
                Intent intent2=new Intent(FragmentActivity.this,FragmentActivity4.class);
                startActivity(intent2);
                break;

            default:
                break;
        }
    }
}
