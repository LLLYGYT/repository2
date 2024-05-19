package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class nextActivity extends AppCompatActivity {
    int flag_next_1=1;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);

        String element2 = new String();
        String element3=new String();

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            element2=bundle.getString("ELEMENT");
        }
        TextView textView = (TextView) findViewById(R.id.next_page);
        if (element2!=null){
            textView.setText("领域展开"+element2);
            element3=element2;

        }


        Button next_button_fanhui= findViewById(R.id.next_button_fanhui);

        final String[] finalElement = {element3};
        next_button_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                flag_next_1=2;
                Intent intent_next_1=new Intent(nextActivity.this,MainActivity.class);
                if(finalElement[0] ==null){
                    finalElement[0] ="!";
                }
                if(flag_next_1==2&& finalElement[0] !=null){
                    intent_next_1.putExtra("EMEMENT3", finalElement[0]);
                    startActivity(intent_next_1);
                }
            }

        });


    }

}
