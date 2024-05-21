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
       Button button1 = findViewById(R.id.button2);
       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent1=new Intent(NextActivity.this,MainActivity.class);
               intent1.putExtra("name2",button1.getText().toString());
               setResult(1001,intent1);
               finish();
           }
        });
           TextView textView=(TextView)findViewById(R.id.text5);
           Intent intent2=new Intent();
           Bundle bundle1=getIntent().getExtras();
           String element=bundle1.getString("button-text");
           if(element!=null){
               textView.setText(element);
           }
           else{
               textView.setText(" ");
           }
       }
}


