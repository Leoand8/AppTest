package com.baichuan.apptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.baichuan.fragment.FragmentActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    /**
     * 按钮点击事件，根据ID获取
     *
     * @param v
     */
    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_handler:
                mStartActivity(HandlerActivity.class);
                break;
            case R.id.btn_main_gesturedetector:
                mStartActivity(GestureDetectorActivity.class);
                break;
            case R.id.btn_main_systemService:
                mStartActivity(SystemServiceActivity.class);
                break;
            case R.id.btn_main_service:
                mStartActivity(ServiceActivity.class);
                break;
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
            case R.id.btn_main_file:
                mStartActivity(FileActivity.class);
                break;
            case R.id.btn_main_contentProvider:
                mStartActivity(ContentProviderActivity.class);
                break;
            case R.id.btn_main_broadcastreceiver:
                mStartActivity(BroadcastReceiverActivity.class);
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
