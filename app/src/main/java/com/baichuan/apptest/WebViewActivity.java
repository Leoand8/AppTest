package com.baichuan.apptest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/3/14.
 */
public class WebViewActivity extends AppCompatActivity {

    private String url = "http://www.youku.com/";
    private WebView webView;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
//        Uri uri = Uri.parse(url);
//        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
//        startActivity(intent);
//        finish();
        init();
    }

    private void init() {
        webView = (WebView) findViewById(R.id.webView);
        //WebView加载本地资源
//        webView.loadUrl("file:///android_asset/example.html");
        //WebView加载Web资源
        webView.loadUrl(url);
        //覆盖第三方，使得在WebView中打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值为true的时候在WebView中打开，false调用第三方
                view.loadUrl(url);
                return true;
//                return super.shouldOverrideUrlLoading(view, url);
            }

        });
        //启用支持JavaScript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //优先使用缓存加载
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    //网页加载完毕,关闭
                    closeDialog();
                } else {
                    //网页正在加载，打开Dialog
                    openDialog(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

            private void closeDialog() {
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                    dialog = null;
                }
            }

            private void openDialog(int newProgress) {
                if (dialog == null) {
                    dialog = new ProgressDialog(WebViewActivity.this);
                    dialog.setTitle("正在加载");
                    dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    dialog.setProgress(newProgress);
                    dialog.show();
                }
            }
        });
    }

    //改写物理按键返回的逻辑
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                Toast.makeText(this, webView.getUrl(), Toast.LENGTH_SHORT).show();
                webView.goBack();
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
