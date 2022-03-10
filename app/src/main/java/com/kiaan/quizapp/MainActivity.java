package com.kiaan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declare and initialise variables
        String username = "User", password = "Password1";

        // instantiate a button obj
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        // instantiate edit text objects to reference the components
        EditText edtUser = (EditText) findViewById(R.id.txtUsername);
        EditText edtPass = (EditText) findViewById(R.id.txtPassword);

        // set button onclick action
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // instantiate intent obj to open a new activity
                Intent in = new Intent(MainActivity.this,QuizPage.class);

                // logical structure to determine if the user has entered the correct credentials
                if (edtUser.getText().toString().equals(username) && edtPass.getText().toString().equals(password))
                {
                    // start the intent to move to the next activity
                    startActivity(in);

                }else{

                    // display an error message to the user
                    Context context = getApplicationContext();
                    String text = "Invalid Credentials. Please try again.";
                    int duration = Toast.LENGTH_LONG;

                    // show the error message
                    Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}