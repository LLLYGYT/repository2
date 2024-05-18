package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class nextActivity extends AppCompatActivity {
    Button button1;




    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);


        String element2 = new String();
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            element2=bundle.getString("ELEMENT");
        }

        TextView textView = (TextView) findViewById(R.id.next_page);

        if (element2!=null){
            textView.setText("领域展开"+element2);
        }

        Button next_button_fanhui= findViewById(R.id.next_button_fanhui);
        next_button_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(nextActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });





    }

}
