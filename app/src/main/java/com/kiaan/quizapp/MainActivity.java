package com.kiaan.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG = "EmailPassword";


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }
    private void reload() { }

    private void updateUI(FirebaseUser user) { }

    // firebase - method to sign in
    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            // instantiate intent obj to open a new activity
                            Intent in = new Intent(MainActivity.this,QuizPage.class);
                            startActivity(in);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    // method to sign up
    private void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            // instantiate intent obj to open a new activity
                            Intent in = new Intent(MainActivity.this,QuizPage.class);
                            startActivity(in);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate a button obj
        Button btnLogin =  findViewById(R.id.btnLogin);
        Button btnSignup =  findViewById(R.id.btnSignUp);
        // instantiate edit text objects to reference the components
        EditText edtUser =  findViewById(R.id.txtUsername);
        EditText edtPass =  findViewById(R.id.txtPassword);

        // sign up
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // declare and initialise variables
                String username = edtUser.getText().toString(), password = edtPass.getText().toString();
                createAccount(username,password);
            }});

        // login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // declare and initialise variables
                String username = edtUser.getText().toString(), password = edtPass.getText().toString();
                signIn(username,password);
            }});





/*        // set button onclick action
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
        });*/

    }
}