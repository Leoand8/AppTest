package com.baichuan.apptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 初始化
     */
    Button btn_main_calculator;
    Button btn_main_listview;
    Button btn_main_picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 实例化
         */
        btn_main_calculator = (Button) findViewById(R.id.btn_main_calculator);
        btn_main_listview = (Button) findViewById(R.id.btn_main_listview);
        btn_main_picker = (Button) findViewById(R.id.btn_main_picker);
        /**
         * 设置点击事件
         */
        btn_main_calculator.setOnClickListener(this);
        btn_main_listview.setOnClickListener(this);
        btn_main_picker.setOnClickListener(this);
    }

    /**
     * 按钮点击事件，根据ID获取
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_calculator:
                mStartActivity(CalculatorActivity.class);
                break;
            case R.id.btn_main_listview:
                mStartActivity(ListViewActivity.class);
                break;
            case R.id.btn_main_picker:
                mStartActivity(PickerActivity.class);
                break;
            default:
                break;
        }
    }

    /**
     * 界面跳转方法，无返回值
     *
     * @param cla
     */
    public void mStartActivity(Class cla) {
        Intent intent = new Intent(this, cla);
        startActivity(intent);
    }

}
