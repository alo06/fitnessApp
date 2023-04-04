package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Signup_activity extends AppCompatActivity {
    EditText email, signPassword,name,weight,height;
    Button submit;
    RadioGroup gender;
    RadioButton genderRadioButton;
    RadioGroup routine;
    RadioButton routineRadioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        getSupportActionBar().hide();
        email=findViewById(R.id.email);
        signPassword =findViewById(R.id.signUppassword);
        name=findViewById(R.id.name);
        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);
        submit=findViewById(R.id.submit);
        gender=findViewById(R.id.gender);
        routine=findViewById(R.id.routine);
        if(gender!=null) {
            gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    genderRadioButton = findViewById(i);
                   // Toast.makeText(Signup_activity.this, genderRadioButton.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        if(routine!=null) {
            routine.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    routineRadioButton = findViewById(i);
                   // Toast.makeText(Signup_activity.this, routineRadioButton.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel userModel = null;
                try{
                    userModel=new UserModel(-1,email.getText().toString(),name.getText().toString(),signPassword.getText().toString(),genderRadioButton.getText().toString(),Integer.parseInt(weight.getText().toString()),Integer.parseInt(height.getText().toString()),routineRadioButton.getText().toString());

                }catch (Exception e){
                    Toast.makeText(Signup_activity.this,"Please fill all the details",Toast.LENGTH_SHORT).show();

                }
                DataBase dataBase=new DataBase(Signup_activity.this);
                boolean success = dataBase.addOne(userModel);
                Toast.makeText(Signup_activity.this,"Success= "+success,Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}