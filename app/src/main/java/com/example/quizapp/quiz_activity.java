package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class quiz_activity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);
        setUpQuizData();
    }
    int maxScore=10, currentScore=0, selectedOption, currentQues=0, maxQues=4, scorePerQues=2;
    int[] answers_array = new int [5];
    String userName;
    RadioButton b;
    public void setUpQuizData(){
        answers_array[0] = R.id.opt_2;
        answers_array[1] = R.id.opt_1;
        answers_array[2] = R.id.opt_4;
        answers_array[3] = R.id.opt_1;
        answers_array[4] = R.id.opt_3;
        userName = getIntent().getExtras().getString("user");
    }

    public void select_option(View view){
        int id = view.getId();
        RadioButton r = findViewById(id);
        selectedOption = id;
    }

    public void next_ques(View view){
        if(selectedOption == answers_array[currentQues]){
            currentScore += scorePerQues;
        }
        if(currentQues <= maxQues) {
            currentQues += 1;
        }
        setNextQues();
    }

    public void setNextQues(){
            RadioGroup group = findViewById(R.id.ques_options);
            group.clearCheck();
            selectedOption = -1;
            TextView t = findViewById(R.id.current_ques);
            if(currentQues <= maxQues){
                t.setText(Integer.toString(currentQues+1)+"/");
            }
            t = findViewById(R.id.ques_text);
            RadioButton opt1, opt2, opt3, opt4;
            opt1 = findViewById(R.id.opt_1);
            opt2 = findViewById(R.id.opt_2);
            opt3 = findViewById(R.id.opt_3);
            opt4 = findViewById(R.id.opt_4);

            if(currentQues <= maxQues) {
                switch (currentQues) {
                    case 0:
                        break;
                    case 1:
                        t.setText(R.string.ques_2);
                        opt1.setText(R.string.ques_2_opt_1);
                        opt2.setText(R.string.ques_2_opt_2);
                        opt3.setText(R.string.ques_2_opt_3);
                        opt4.setText(R.string.ques_2_opt_4);
                        break;
                    case 2:
                        t.setText(R.string.ques_3);
                        opt1.setText(R.string.ques_3_opt_1);
                        opt2.setText(R.string.ques_3_opt_2);
                        opt3.setText(R.string.ques_3_opt_3);
                        opt4.setText(R.string.ques_3_opt_4);
                        break;
                    case 3:
                        t.setText(R.string.ques_4);
                        opt1.setText(R.string.ques_4_opt_1);
                        opt2.setText(R.string.ques_4_opt_2);
                        opt3.setText(R.string.ques_4_opt_3);
                        opt4.setText(R.string.ques_4_opt_4);
                        break;
                    case 4:
                        t.setText(R.string.ques_5);
                        opt1.setText(R.string.ques_5_opt_1);
                        opt2.setText(R.string.ques_5_opt_2);
                        opt3.setText(R.string.ques_5_opt_3);
                        opt4.setText(R.string.ques_5_opt_4);
                        break;
                    default:
                        finalScreen();
                }
            }
            else{
                finalScreen();
            }
    }
    public void finalScreen(){
        Intent intent = new Intent(quiz_activity.this, final_activity.class);
        intent.putExtra("name", userName);
        intent.putExtra("score", currentScore);
        intent.putExtra("maxScore", maxScore);
        startActivity(intent);
    }
}
