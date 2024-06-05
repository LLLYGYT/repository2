package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


public class WebViewActivity extends AppCompatActivity {
    public WebView webView1;
    public H5Bridge h5Bridge1;

    public TextView tvTitle1;
    public long exitTime1=0;
    public int dialog_flag=1;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewactivity_page);

        tvTitle1=findViewById(R.id.tvtitle_1);
        webView1=findViewById(R.id.webview_1);
        webView1.setWebContentsDebuggingEnabled(true);

        webView1.getSettings().setJavaScriptEnabled(true);
        h5Bridge1=new H5Bridge(this);
        webView1.addJavascriptInterface(h5Bridge1,"桥接");
        h5Bridge1.context1=this;
        //h5Bridge1.showWindow();



        webView1.setWebChromeClient(new WebChromeClient(){
         //设置获取到的网站title
         @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                tvTitle1.setText(title);
            }
        });
        webView1.setWebViewClient(new WebViewClient(){
            //设置在webview点击打开的新闻网页在当前页面显示，而不跳转到新的浏览器
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView1.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if("https://bbs.twinkstar.com/forum.php?mod=viewthread&tid=8724".equals(url)&&dialog_flag==1){
                    new AlertDialog.Builder(WebViewActivity.this)
                            .setTitle("对话框")
                            .setMessage("这是text")
                            .setPositiveButton("这是button", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    webView1.reload();
                                    dialog_flag=2;
                                    webView1.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            webView1.evaluateJavascript("javascriptFunction()", null);
                                        }
                                    });
                                }
                            })
                            .show();

                }
            }
        });

        WebSettings settings=webView1.getSettings();
        settings.setUseWideViewPort(true);//设定支持viewport
        settings.setLoadWithOverviewMode(true);//自适应屏幕
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(true);//支持缩放
        settings.setJavaScriptEnabled(true);//设置webview属性，运行执行js脚本
        webView1.loadUrl("https://123.twinkstar.cn/");

    }
    
    @Override
    public void onBackPressed() {
        if(webView1.canGoBack()){//判断网页是否能回退
            webView1.goBack();
        }
        else{
            if(System.currentTimeMillis()-exitTime1>=2000){
                Toast.makeText(getApplicationContext(),"再按一次退出程序",Toast.LENGTH_SHORT).show();
                exitTime1=System.currentTimeMillis();
            }
            else{
                super.onBackPressed();
            }
        }
    }

}
