package com.baichuan.apptest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	private Button btn1;
	private Button btn2;
	private TextView tv;
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		tv = (TextView) findViewById(R.id.textView);
		mContext = this;

		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, JumpActivity.class);
				startActivity(intent);
			}
		});

		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mContext, JumpActivity.class);
				startActivityForResult(intent, 1);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode==1 && resultCode==2){
			String content = data.getStringExtra("data");
			tv.setText(content);
		}
	}
}
