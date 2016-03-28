package com.baichuan.apptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.baichuan.fragment.FragmentActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 初始化
     */
    Button btn_main_calculator;
    Button btn_main_listview;
    Button btn_main_picker;
    Button btn_main_gridview;
    Button btn_main_spinner;
    Button btn_main_progressbar;
    Button btn_main_webview;
    Button btn_main_fragment;
    Button btn_main_viewpager;
    Button btn_main_viewflipper;
    Button btn_main_scrollview;
    Button btn_main_gallery;
    Button btn_main_seekbar;
    Button btn_main_listview2;
    Button btn_main_asynctask;
    Button btn_main_news;
    Button btn_main_sharedpreferences;
    Button btn_main_sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        /**
         * 实例化
         */
        btn_main_calculator = (Button) findViewById(R.id.btn_main_calculator);
        btn_main_listview = (Button) findViewById(R.id.btn_main_listview);
        btn_main_picker = (Button) findViewById(R.id.btn_main_picker);
        btn_main_gridview = (Button) findViewById(R.id.btn_main_gridview);
        btn_main_spinner = (Button) findViewById(R.id.btn_main_spinner);
        btn_main_progressbar = (Button) findViewById(R.id.btn_main_progressbar);
        btn_main_webview = (Button) findViewById(R.id.btn_main_webview);
        btn_main_fragment = (Button) findViewById(R.id.btn_main_fragment);
        btn_main_viewpager = (Button) findViewById(R.id.btn_main_viewpager);
        btn_main_viewflipper = (Button) findViewById(R.id.btn_main_viewflipper);
        btn_main_scrollview = (Button) findViewById(R.id.btn_main_scrollview);
        btn_main_gallery = (Button) findViewById(R.id.btn_main_gallery);
        btn_main_seekbar = (Button) findViewById(R.id.btn_main_seekbar);
        btn_main_listview2 = (Button) findViewById(R.id.btn_main_listview2);
        btn_main_asynctask = (Button) findViewById(R.id.btn_main_asynctask);
        btn_main_news = (Button) findViewById(R.id.btn_main_news);
        btn_main_sharedpreferences = (Button) findViewById(R.id.btn_main_sharedpreferences);
        btn_main_sqlite = (Button) findViewById(R.id.btn_main_sqlite);

        /**
         * 设置点击事件
         */
        btn_main_calculator.setOnClickListener(this);
        btn_main_listview.setOnClickListener(this);
        btn_main_picker.setOnClickListener(this);
        btn_main_gridview.setOnClickListener(this);
        btn_main_spinner.setOnClickListener(this);
        btn_main_progressbar.setOnClickListener(this);
        btn_main_webview.setOnClickListener(this);
        btn_main_fragment.setOnClickListener(this);
        btn_main_viewpager.setOnClickListener(this);
        btn_main_viewflipper.setOnClickListener(this);
        btn_main_scrollview.setOnClickListener(this);
        btn_main_gallery.setOnClickListener(this);
        btn_main_seekbar.setOnClickListener(this);
        btn_main_listview2.setOnClickListener(this);
        btn_main_asynctask.setOnClickListener(this);
        btn_main_news.setOnClickListener(this);
        btn_main_sharedpreferences.setOnClickListener(this);
        btn_main_sqlite.setOnClickListener(this);
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
            case R.id.btn_main_gridview:
                mStartActivity(GridViewActivity.class);
                break;
            case R.id.btn_main_spinner:
                mStartActivity(SpinnerActivity.class);
                break;
            case R.id.btn_main_progressbar:
                mStartActivity(ProgressBarActivity.class);
                break;
            case R.id.btn_main_webview:
                mStartActivity(WebViewActivity.class);
                break;
            case R.id.btn_main_fragment:
                mStartActivity(FragmentActivity.class);
                break;
            case R.id.btn_main_viewpager:
                mStartActivity(ViewPagerActivity.class);
                break;
            case R.id.btn_main_viewflipper:
                mStartActivity(ViewFlipperActivity.class);
                break;
            case R.id.btn_main_scrollview:
                mStartActivity(ScrollViewActivity.class);
                break;
            case R.id.btn_main_gallery:
                mStartActivity(GalleryActivity.class);
                break;
            case R.id.btn_main_seekbar:
                mStartActivity(SeekBarActivity.class);
                break;
            case R.id.btn_main_listview2:
                mStartActivity(ListViewActivity2.class);
                break;
            case R.id.btn_main_asynctask:
                mStartActivity(AsyncTaskActivity.class);
                break;
            case R.id.btn_main_news:
                mStartActivity(NewsActivity.class);
                break;
            case R.id.btn_main_sharedpreferences:
                mStartActivity(SharedPreferencesActivity.class);
                break;
            case R.id.btn_main_sqlite:
                mStartActivity(SQLiteActivity.class);
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
