package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    int flag=0;

   @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.next);




       Button next_button_fanhui = findViewById(R.id.next_button_fanhui);

       next_button_fanhui.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               Intent intent=new Intent(NextActivity.this,MainActivity.class);
               intent.putExtra("name2",next_button_fanhui.getText().toString());
               setResult(1001,intent);
               finish();
               flag=1;



           }



        });

           Intent intent=getIntent();
           Bundle bundle=getIntent().getExtras();
           String textname=bundle.getString("button-text");
           TextView textView=(TextView)findViewById(R.id.next_page);
           String element=bundle.getString("button-text");
           if(element!=null){
               textView.setText(element);
           }
           else{
               textView.setText(" ");
           }

       }

}
