package com.baichuan.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baichuan.apptest.R;

/**
 * Created by Administrator on 2016/3/18.
 */
public class FragmentActivity4 extends AppCompatActivity implements MyFragment5.MyListener {
    private EditText editText;
    private Button send;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment4);
        editText = (EditText) findViewById(R.id.fragment4_editText);
        send = (Button) findViewById(R.id.fragment4_button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                MyFragment5 fragment5 = new MyFragment5();
                Bundle bundle = new Bundle();
                bundle.putString("name", text);
                fragment5.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                beginTransaction.add(R.id.frag, fragment5, "fragment5");
                beginTransaction.commit();
                Toast.makeText(FragmentActivity4.this, "向Fragment发送数据" + text, Toast.LENGTH_SHORT).show();
            }
        });
        FragmentManager fragmentManager = getFragmentManager();
        Fragment findFragmentById = fragmentManager.findFragmentById(R.id.frag);
        MyFragment frag = (MyFragment) findFragmentById;
        frag.setAaa("fragment静态传值");
    }

    @Override
    public void thank(String code) {
        Toast.makeText(FragmentActivity4.this, "已成功接收到" + code + "，客气了！", Toast.LENGTH_SHORT).show();
    }
}
