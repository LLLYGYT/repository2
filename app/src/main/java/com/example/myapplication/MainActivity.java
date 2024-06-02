package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    int Flag_1 = 0;
    Button button1;
    Button button2;
//    ProgressBar progressBar;
//   TextView textView;
    ArrayList<String> shenglvehao = new ArrayList<String>();
    String element1 = ".";
    String name3 = "aaa";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shenglvehao.add(".");
        shenglvehao.add("..");
        shenglvehao.add("...");
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(v -> {//传参数给next页面
            String dataToSend = button1.getText().toString();
            Intent intent1 = new Intent(MainActivity.this, NextActivity.class);
            intent1.putExtra("data", dataToSend);
            startActivityForResult(intent1, 1000);
        });
        //变化的按钮文字
        Timer timer = new Timer();//设置计时器，学一下线程
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //将子线程传回到主线程更新到UI
                runOnUiThread(() -> {
                    i++;//i++;//每进行一次循环，i自增
                    if (i == 4) {
                        i = 0;
                    } else {//progressBar.setProgress(i);//随i显示进度
                        if (i == 0) {
                            i = i + 1;
                        }
                        if (Flag_1 == 0) {
                            element1 = shenglvehao.get(i - 1);
                            button1.setText("领域展开" + shenglvehao.get(i - 1));//显示当前进度
                        }
                        if (Flag_1 == 1) {
                            button1.setText(name3);
                        }
                    }
                });
            }
        }, 1000, 1000);//每一秒循环一次


        button2=findViewById(R.id.button_2);
        button2.setOnClickListener(v -> {
            Intent intent2=new Intent(MainActivity.this,WebViewActivity.class);
            startActivity(intent2);
        });

        //按下按钮 页面的跳转
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, NextActivity.class);
//                intent.putExtra("ELEMENT",button1.getText());
//                startActivity(intent);
//            }
//        });
//
//
        //progressBar = findViewById(R.id.progressBar);//初始化
        /*textView = findViewById(R.id.text);*/
        /*  展示网页图片
        ImageView imageView = findViewById(R.id.imageview1);
        String imageUrl = "https://i1.hdslb.com/bfs/archive/b70ae1c92ab59156dcbaedcd61dbf566f7c27eab.jpg";
        Picasso.get().load(imageUrl).into(imageView);
         */
         /*
        ImageView imageView = findViewById(R.id.imageView);
        String imageUrl = "https://i1.hdslb.com/bfs/archive/b70ae1c92ab59156dcbaedcd61dbf566f7c27eab.jpg";
        Glide.with(this).load(imageUrl).into(imageView);
        */

      /*  进度条
        progressBar = findViewById(R.id.progressBar);//初始化
        textView = findViewById(R.id.text);
        final Timer timer = new Timer();//设置计时器，不懂可以去学一下线程
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {//将子线程传回到主线程更新到UI
                    @Override
                    public void run() {
                        i++;
                        //i++;//每进行一次循环，i自增
                        if (i == 100) {
                            timer.cancel();//当i=100时，停止增加
                        } else {
                            progressBar.setProgress(i);//随i显示进度
                            textView.setText("进度条值为：" + i + "%");//显示当前进度
                        }
                    }
                });
            }
        }, 100, 100);//每一秒循环一次*/
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        MainActivity.super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == 1001 && data != null) {
                name3 = data.getStringExtra("dataFromNext");
                Flag_1 = 1;
            }
        }
    }
}



