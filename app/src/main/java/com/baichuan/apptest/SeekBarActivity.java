package com.baichuan.apptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/3/22.
 */
public class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar seekBar;
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        seekBar = (SeekBar) findViewById(R.id.seekbar);
        tv1 = (TextView) findViewById(R.id.seekbar_text1);
        tv2 = (TextView) findViewById(R.id.seekbar_text2);

        seekBar.setOnSeekBarChangeListener(this);

    }

    //在数值改变的时候调用
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tv1.setText("正在拖动");
        tv2.setText("当前数值：" + progress);
    }

    //开始拖动时调用
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        tv1.setText("开始拖动");
    }

    //停止拖动时调用
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        tv1.setText("停止拖动");
    }
}
