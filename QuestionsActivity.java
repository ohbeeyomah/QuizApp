package com.example.android.quizapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {
    //Declare variables for the score and the submit and answer buttons
    int score = 0;
    Button submitButton;
    Button answerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Hide keyboard to prevent focus on the first EditText on start of activity
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //Set the layout for this activity
        setContentView(R.layout.activity_questions);
        //Initialize the submit and answer buttons and attach click event listeners to them
        submitButton = findViewById(R.id.submit_btn);
        answerButton = findViewById(R.id.answer_btn);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    checkAllAnswers();
                    if(score==10) {
                        Toast.makeText(QuestionsActivity.this, "Excellent! \n You scored " + score + " /10", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(QuestionsActivity.this, " You scored " + score + " /10 \n Try again ", Toast.LENGTH_SHORT).show();
                    }
                    resetAnswers();
            }
        });
        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswers();
            }
        });

    }

    //Method to get answer to question 1
    private void checkForAnswerToQuestionOne() {
 RadioButton radioButtonTrue = findViewById(R.id.qtn1_btn_true);
if (radioButtonTrue.isChecked()) {
            score += 1;
        }

    }

    //Method to get answer to question 2
    private void checkForAnswerToQuestionTwo() {

        CheckBox criminalLaw = findViewById(R.id.qtn2_criminal_law);
        CheckBox marketLaw = findViewById(R.id.qtn2_market_law);
        CheckBox familyLaw = findViewById(R.id.qtn2_family_law);
        CheckBox groundLaw = findViewById(R.id.qtn2_ground_law);
if((criminalLaw.isChecked()&& familyLaw.isChecked())&&!marketLaw.isChecked()&& !groundLaw.isChecked()){
    score+=1;
    }
        }

    //Method to get answer to question 3
    private void checkForAnswerToQuestionThree() {
        EditText answerThree = findViewById(R.id.qtn3_edit_txt);
        String name = answerThree.getText().toString();
        if (name.trim().equalsIgnoreCase("not guilty")) {
            score += 1;
        }
    }

    //Method to get answer to question 4
    private void checkForAnswerToQuestionFour() {
        RadioButton radioButtonLaymen = findViewById(R.id.qtn4_btn_laymen);
if (radioButtonLaymen.isChecked()) {
            score += 1;
        }
    }

    //Method to get answer to question 5
    private void checkForAnswerToQuestionFive() {
        EditText answerFive = findViewById(R.id.qtn5_edit_txt);
        String name = answerFive.getText().toString();
        if (name.trim().equalsIgnoreCase("bench")) {
            score += 1;
        }
    }

    //Method to get answer to question 6
    private void checkForAnswerToQuestionSix() {
        RadioButton radioButtonTheFacts = findViewById(R.id.qtn6_btn_facts_speak);
        if (radioButtonTheFacts.isChecked()) {
            score += 1;
        }
    }

    //Method to get answer to question 7
    private void checkForAnswerToQuestionSeven() {
        RadioButton radioButtonCourt = findViewById(R.id.qtn7_btn_court);
        if (radioButtonCourt.isChecked()) {
            score += 1;
        }
    }


    //Method to get answer to question 8
    private void checkForAnswerToQuestionEight() {
        RadioButton radioButtonPlaintiff = findViewById(R.id.qtn8_plaintiff);
         if (radioButtonPlaintiff.isChecked()) {
            score += 1;
        }
    }


    //Method to get answer to question 9
    private void checkForAnswerToQuestionNine() {
        CheckBox liar = findViewById(R.id.qtn9_liar);
        CheckBox legalPractitioner = findViewById(R.id.qtn9_legal_practitioner);
        CheckBox chatterBox = findViewById(R.id.qtn9_chatterbox);
        CheckBox advocate = findViewById(R.id.qtn9_advocate);
        if ((legalPractitioner.isChecked() && advocate.isChecked()) && !liar.isChecked() && !chatterBox.isChecked()) {
            score += 1;
        }
    }

    //Method to get answer to question 10
    private void checkForAnswerToQuestionTen() {
        EditText answerTen = findViewById(R.id.qtn10_edit_txt);
        String name = answerTen.getText().toString();
        if (name.trim().equalsIgnoreCase("case dismissed")) {
            score += 1;
        }
    }

    //Method to check all answers and update score
    private void checkAllAnswers() {
        checkForAnswerToQuestionOne();
        checkForAnswerToQuestionTwo();
        checkForAnswerToQuestionThree();
        checkForAnswerToQuestionFour();
        checkForAnswerToQuestionFive();
        checkForAnswerToQuestionSix();
        checkForAnswerToQuestionSeven();
        checkForAnswerToQuestionEight();
        checkForAnswerToQuestionNine();
        checkForAnswerToQuestionTen();
    }

    //Method to reset answers after the score has been displayed
    private void resetAnswers() {
        score = 0;
    }
    //Method to display the correct answers
    public void showAnswers(){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(QuestionsActivity.this);
        alertDialog.setMessage("ANSWERS \n  \n 1. True\n 2. Criminal law , Family law \n 3. Not guilty \n 4. Laymen \n 5. Bench \n 6. The facts speak for themselves \n 7. Court \n 8. Plaintiff \n 9. Legal Practitioner \n 10. Case dismissed ");
        alertDialog.setPositiveButton("OK", null);
        AlertDialog dialog = alertDialog.create();
        dialog.show();
    }
}