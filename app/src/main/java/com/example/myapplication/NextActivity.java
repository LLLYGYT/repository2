package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
   @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.next);

       //将首页传过来的数据设置为页面文字
       TextView textView=(TextView)findViewById(R.id.text5);
       Bundle bundle1=getIntent().getExtras();
       String element=bundle1.getString("data");
       if(element!=null){
           textView.setText(element);
       }
       else{
           textView.setText(" ");
       }


       Button button1 = findViewById(R.id.button2);
       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent resultIntent=new Intent(NextActivity.this,MainActivity.class);
               resultIntent.putExtra("dataFromNext","我回来了"+element);
               startActivity(resultIntent);
               setResult(1001,resultIntent);
               finish();



//               Intent intent1=new Intent(NextActivity.this,MainActivity.class);
//               intent1.putExtra("name2","我回来了"+button1.getText().toString());
//               setResult(1001,intent1);
//               finish();
           }
        });


   }
}


