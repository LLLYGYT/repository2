package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    int i = 0;
















    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        /*
        ImageView imageView = findViewById(R.id.imageview1);
        String imageUrl = "https://i1.hdslb.com/bfs/archive/b70ae1c92ab59156dcbaedcd61dbf566f7c27eab.jpg";
        Picasso.get().load(imageUrl).into(imageView);


         */


        ImageView imageView = findViewById(R.id.imageView);
        String imageUrl = "https://example.com/image.jpg";
        Glide.with(this).load(imageUrl).into(imageView);




      /*  super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

