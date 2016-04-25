package com.udacity.gradle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private final static String EXTRA_QUESTION = "com.udacity.gradle.QUESTION";
    private final static String EXTRA_ANSWER = "com.udacity.gradle.ANSWER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent receivedIntent = getIntent();
        String receivedQuestion = receivedIntent.getStringExtra(EXTRA_QUESTION);
        String receivedAnswer = receivedIntent.getStringExtra(EXTRA_ANSWER);

        TextView questionText = (TextView) findViewById(R.id.question);
        questionText.setText(receivedQuestion);

        TextView answerText = (TextView) findViewById(R.id.answer);
        answerText.setText(receivedAnswer);
    }

    public void showAnswer(View view){
        TextView answerText = (TextView) findViewById(R.id.answer);
        answerText.setVisibility(View.VISIBLE);
    }


}
