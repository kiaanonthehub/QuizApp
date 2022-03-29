package com.kiaan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    // declare variables
    String firstName, lastName, course, module, phoneNumber,role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // you need to have a list of data that you want the spinner to display
        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Student");
        spinnerArray.add("Teacher");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spnRole);
        sItems.setAdapter(adapter);

        // declare and initialise java properties
        Button btnUserSubmit = findViewById(R.id.btnUserSubmit);
        EditText EdtFirstname = findViewById(R.id.txtuFirstName);
        EditText EdtLastname = findViewById(R.id.txtuLastName);
        EditText Ecourse = findViewById(R.id.txtuCourse);
        EditText EmoduleCode = findViewById(R.id.txtuModuleCode);
        EditText EphoneNumber = findViewById(R.id.txtuPhoneNumber);

        // when the button is clicked
       btnUserSubmit.setOnClickListener(view -> {

           // initialise class fields
           firstName = EdtFirstname.getText().toString();
           lastName = EdtLastname.getText().toString();
           course = Ecourse.getText().toString();
           module = EmoduleCode.getText().toString();
           phoneNumber = EphoneNumber.getText().toString();

           // instantiate user object
           User user = new User(firstName,lastName,course,module,phoneNumber);

           // write to the database
           DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
           mDatabase.child("User").child(user.getFirstName()+' '+user.getLastName()).setValue(user);

           // display a message
           Toast.makeText(Register.this, "Details have been saved",
                   Toast.LENGTH_SHORT).show();

           // go to a new view
           Intent in = new Intent(Register.this,QuizPage.class);
           startActivity(in);
       });

    }

}
/*
Author: WIllJBD
Topic: Android : Fill Spinner From Java Code Programmatically
Code : L34 - 44
Link: https://stackoverflow.com/questions/11920754/android-fill-spinner-from-java-code-programmatically
 */