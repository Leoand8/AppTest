package com.baichuan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baichuan.apptest.R;

/**
 * Created by Administrator on 2016/3/18.
 */
public class FragmentActivity2 extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment2);

        Button button = (Button) findViewById(R.id.fragmentButton);
        tv= (TextView) findViewById(R.id.fragmentText);
        button.setText("改变");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("TextView改变了");
            }
        });
    }
}
