package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class WebViewActivity extends AppCompatActivity {
    public WebView webView1;
    public TextView tvTitle1;
    public long exitTime1=0;
    public int dialog_flag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewactivity_page);

        tvTitle1=findViewById(R.id.tvtitle_1);
        webView1=findViewById(R.id.webview_1);
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
                if("https://www.baidu.com/s?wd=%E4%B9%A0%E8%BF%91%E5%B9%B3%E5%90%8C%E8%B5%A4%E9%81%93%E5%87%A0%E5%86%85%E4%BA%9A%E6%80%BB%E7%BB%9F%E4%BC%9A%E8%B0%88&sa=fyb_n_homepage&rsv_dl=fyb_n_homepage&from=super&cl=3&tn=baidutop10&fr=top1000&rsv_idx=2&hisfilter=1".equals(url)&&dialog_flag==1){
                    new AlertDialog.Builder(WebViewActivity.this)
                            .setTitle("对话框")
                            .setMessage("这是text")
                            .setPositiveButton("这是button", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    webView1.reload();
                                    dialog_flag=2;
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
