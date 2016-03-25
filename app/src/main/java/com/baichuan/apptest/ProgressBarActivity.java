package com.baichuan.apptest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/3/7.
 */
public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {

    MenuItem mProgressMenu;
    private ProgressBar progress;
    private Button add;
    private Button reduce;
    private Button reset;
    private TextView text;
    private ProgressDialog progressDialog;
    private Button showDialog;
    private Button btn_viewstub;
    private ViewStub viewStub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //启用窗口特征，启用带进度和不带进度的进度条
//        requestWindowFeature(Window.FEATURE_PROGRESS);
//        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_progressbar);
        //显示两种进度条
//        setProgressBarVisibility(true);
//        setProgressBarIndeterminateVisibility(true);
//        setProgress(6000);
        init();
    }

    private void init() {
        progress = (ProgressBar) findViewById(R.id.progressBar4);
        add = (Button) findViewById(R.id.add);
        reduce = (Button) findViewById(R.id.reduce);
        reset = (Button) findViewById(R.id.reset);
        text = (TextView) findViewById(R.id.text111);
        showDialog = (Button) findViewById(R.id.showDialog);
        btn_viewstub = (Button) findViewById(R.id.viewstub_btn);
        viewStub = (ViewStub) findViewById(R.id.viewstub);

        //获取第一进度条的进度
        int first = progress.getProgress();
        //获取第二进度条的进度
        int second = progress.getSecondaryProgress();
        //获取进度条的最大进度
        int max = progress.getMax();
        text.setText("第一进度百分比：" + (int) (first / (float) max * 100) + "%" + "第二进度百分比：" + (int) (second / (float) max * 100) + "%");
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        reset.setOnClickListener(this);
        showDialog.setOnClickListener(this);
        btn_viewstub.setOnClickListener(this);
    }

    //创建Menu，在标题栏显示加载进度
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getSupportMenuInflater().inflate(R.menu.share_public,menu);
        getMenuInflater().inflate(R.menu.share_public, menu);
        mProgressMenu = menu.findItem(R.id.refresh_loading);
        return true;
    }

    //设置加载状态
    public void setLoadingState(boolean refreshing) {
        if (mProgressMenu != null) {
            if (refreshing) {
                mProgressMenu.setActionView(R.layout.actionbar_indeterminate_progress);
                mProgressMenu.setVisible(true);
            } else {
                mProgressMenu.setVisible(false);
                mProgressMenu.setActionView(null);
            }
        }
    }

    //设置点击事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case MotionEvent.ACTION_MOVE:
                setLoadingState(true);
                return true;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add: {
                progress.incrementProgressBy(10);
                progress.incrementSecondaryProgressBy(10);

            }
            break;
            case R.id.reduce:
                progress.incrementProgressBy(-10);
                progress.incrementSecondaryProgressBy(-10);
                break;
            case R.id.reset:
                progress.setProgress(50);
                progress.setSecondaryProgress(80);
                break;
            case R.id.showDialog:
                //新建对象
                progressDialog = new ProgressDialog(ProgressBarActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("百川教育");
                progressDialog.setMessage("欢迎大家支持百川教育");
                progressDialog.setIcon(R.mipmap.ic_launcher);
                //设置进度条的属性
                progressDialog.setMax(100);
                progressDialog.incrementProgressBy(50);
                progressDialog.setIndeterminate(false);
                //设置确定按钮
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProgressBarActivity.this, "确定点击百川教育", Toast.LENGTH_SHORT).show();
                    }
                });
                //是否可以通过返回按钮退出对话框
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            case R.id.viewstub_btn:
//                viewStub.inflate();
                viewStub.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
        text.setText("第一进度百分比：" + (int) (progress.getProgress() / (float) progress.getMax() * 100) + "%" + "第二进度百分比：" + (int) (progress.getSecondaryProgress() / (float) progress.getMax() * 100) + "%");
    }
}
