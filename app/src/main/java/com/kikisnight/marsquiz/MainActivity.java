package com.kikisnight.marsquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    int [] rightAnswers = {R.id.option_1_2, R.id.option_2_1, R.id.option_3_3, R.id.option_4_3, R.id.option_5_4};
    String rightAnswerQuestionSix = "Discovery";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submitAnswers (View view) {

        int score = 0;

        for (int arrayValue : rightAnswers) {
            RadioButton obtainValue = (RadioButton) findViewById(arrayValue);
            boolean answersCheck = obtainValue.isChecked();

            if (answersCheck) {
                score += 1;
            }
        }

        /**
         * Question 6: Checking EditText
         */
        EditText answerQuestionSix = (EditText) findViewById(R.id.questionSixText);
        String valueEditText = answerQuestionSix.getText().toString().trim();

        if (valueEditText.equals(rightAnswerQuestionSix)) {
            score += 1;
        }

        /**
         * Question 7: Checking CheckBox
         */
        CheckBox checkAnswer1 = (CheckBox) findViewById(R.id.checkAnswer1);
        boolean isCheckAnswer1 = checkAnswer1.isChecked();
        CheckBox checkAnswer2 = (CheckBox) findViewById(R.id.checkAnswer2);
        boolean isCheckAnswer2 = checkAnswer2.isChecked();
        CheckBox checkAnswer3 = (CheckBox) findViewById(R.id.checkAnswer3);
        boolean isCheckAnswer3 = checkAnswer3.isChecked();
        CheckBox checkAnswer4 = (CheckBox) findViewById(R.id.checkAnswer4);
        boolean isCheckAnswer4 = checkAnswer4.isChecked();

        if (!isCheckAnswer2 && !isCheckAnswer4 && isCheckAnswer1 && isCheckAnswer3){
            score += 1;
        }

        String toastMessage = "Total score " + score;

        Toast totalScore = Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG);
        totalScore.setGravity(Gravity.CENTER_VERTICAL,0,0);
        totalScore.show();
    }
}
