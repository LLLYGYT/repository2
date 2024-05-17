package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends AppCompatActivity {
    int i = 0;
    ProgressBar progressBar;
    TextView textView;
    Button button1;
    private int j;
    ArrayList<String> shenglvehao=new ArrayList<String>();
    String element=".";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        shenglvehao.add(".");
        shenglvehao.add("..");
        shenglvehao.add("...");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //页面的跳转
        button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,nextActivity.class);
                startActivity(intent);
            }
        });

        //progressBar = findViewById(R.id.progressBar);//初始化
        /*textView = findViewById(R.id.text);*/


        final Timer timer = new Timer();//设置计时器，不懂可以去学一下线程

        timer.schedule(new TimerTask() {
            int j;
            @Override

            public void run() {
                runOnUiThread(new Runnable() {//将子线程传回到主线程更新到UI
                    @Override
                    public void run() {
                        i++;//i++;//每进行一次循环，i自增
                        if (i == 4) {
                            i=0;
                        } else {
                            //progressBar.setProgress(i);//随i显示进度
                            if(i==0){
                                i=i+1;
                            }

                            element=shenglvehao.get(i-1);
                            button1.setText("领域展开" + shenglvehao.get(i-1) );//显示当前进度

                        }
                    }
                });
            }
        }
        , 100, 100);//每一秒循环一次

        Intent intent1=new Intent(this,nextActivity.class);
        intent1.putExtra("ELEMENT",element);
        startActivity(intent1);



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
}

