package com.baichuan.apptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/3/1.
 */
public class JumpActivity extends Activity {

	private Button btn1;
	private String content = "你好";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jump);

		btn1 = (Button) findViewById(R.id.button_jump);
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("data", content);
				setResult(2,data);

				finish();
			}
		});
	}
}
