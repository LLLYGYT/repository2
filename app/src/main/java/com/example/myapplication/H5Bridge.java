package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import androidx.appcompat.app.AlertDialog;

public class H5Bridge {
    WebView webView1;
    Context context1;
    H5Bridge(Context context1){
        context1=this.context1;
    }

    @JavascriptInterface
    public void showWindow(){
        AlertDialog.Builder builder1=new AlertDialog.Builder(context1);
        builder1.setTitle("对话框");
        builder1.setMessage("正文");
        builder1.setPositiveButton("按钮", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder1.show();
    }

}
