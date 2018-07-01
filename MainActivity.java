package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set layout of this activity
        setContentView(R.layout.activity_main);
        //Initialize the button view object and attach a listener to it to listen for click events
        Button start = findViewById(R.id.start_btn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuestionsActivity();
            }
        });
    }
    //Callback method to be executed by the onClick method of the onClickListener
    private void startQuestionsActivity() {
        Intent launchQuestions = new Intent(this, QuestionsActivity.class);
        startActivity(launchQuestions);
    }
}
