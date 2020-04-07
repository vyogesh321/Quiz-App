package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class final_activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_activity);
        setData();
        Button btn1 = findViewById(R.id.replay);
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        Button btn2 = findViewById(R.id.exit);
        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finishAffinity();
            }
        });
    }

    int finalScore, maxScore;
    String userName;
    public void setData(){
        Intent intent = getIntent();
        finalScore = intent.getIntExtra("score", 0);
        maxScore = intent.getIntExtra("maxScore", 0);
        userName = intent.getStringExtra("name");
        TextView t = findViewById(R.id.user);
        t.setText(userName);
        t = findViewById(R.id.score);
        t.setText(Integer.toString(finalScore)+"/");
        t = findViewById(R.id.max);
        t.setText(Integer.toString(maxScore));
    }
}
