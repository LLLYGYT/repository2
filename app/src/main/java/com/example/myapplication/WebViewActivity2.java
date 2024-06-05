package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity2 extends AppCompatActivity {
    WebView webView2;
    Button button2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewactivity_page_two);

        button2=(Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView2.post(new Runnable() {
                    @Override
                    public void run() {
                        webView2.loadUrl("javascript:callJS()");
                    }
                });
            }
        });


        webView2=(WebView) findViewById(R.id.webview_2);
        WebSettings webSettings=webView2.getSettings();

        webSettings.setJavaScriptEnabled(true);//设置与js交互的权限
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);//设置允许js弹窗

        webView2.loadUrl("file:///android_asset/javascript.html");

        webView2.setWebChromeClient(new WebChromeClient(){

            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder builder=new AlertDialog.Builder(WebViewActivity2.this);
                builder.setTitle("Alert");
                builder.setMessage(message);
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
                builder.setCancelable(false);
                builder.create().show();
                return true;
            }
        });




    }
}
