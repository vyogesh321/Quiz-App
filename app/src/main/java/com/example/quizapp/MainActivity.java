package com.example.quizapp;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start_quiz (View view){
        EditText name = findViewById(R.id.name_text);
        String s = name.getText().toString();
        Intent intent = new Intent(MainActivity.this, quiz_activity.class);
        intent.putExtra("user", s);
        startActivity(intent);
    }
}
