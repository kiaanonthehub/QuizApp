package com.kiaan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

        // instantiate button obj
        Button btnSubmit = findViewById(R.id.btnSubmit);

        // instantiate radio button obj
        RadioButton rbtn1 = findViewById(R.id.rbtn1);
        RadioButton rbtn2 = findViewById(R.id.rbtn2);
        RadioButton rbtn3 = findViewById(R.id.rbtn3);
        RadioButton rbtn4 = findViewById(R.id.rbtn4);
        RadioButton rbtn5 = findViewById(R.id.rbtn5);
        RadioButton rbtn6 = findViewById(R.id.rbtn6);
        RadioButton rbtn7 = findViewById(R.id.rbtn7);
        RadioButton rbtn8 = findViewById(R.id.rbtn8);

        // set a button onclick event
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // declare and initialise fields
                int score = 0;

                // logical statement
                // question 1
                if (rbtn1.isChecked())
                {
                    score = score + 1;
                }

                // question 2
                if (rbtn3.isChecked())
                {
                    score = score + 1;
                }

                // question 3
                if (rbtn6.isChecked())
                {
                    score = score + 1;
                }

                // question 4
                if (rbtn8.isChecked())
                {
                    score = score + 1;
                }

                // display the score to the user

                // display an error message to the user
                Context context = getApplicationContext();
                String text = "Congratulations!!! You have got a score of "+score+".";
                int duration = Toast.LENGTH_LONG;

                // show the error message
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();

            }
        });


    }
}