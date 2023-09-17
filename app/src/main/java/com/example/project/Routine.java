package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Routine extends AppCompatActivity {
    RadioGroup routine;
    RadioButton routineRadioButton;
    String mail,name,password,gender,weight,height;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);
        routine = findViewById(R.id.routineg);
        submit=findViewById(R.id.submits);
        Intent i=getIntent();
        name=i.getStringExtra("Name");
        getSupportActionBar().hide();
        mail=i.getStringExtra("Email");
        password=i.getStringExtra("Password");
        gender=i.getStringExtra("Gender");
        weight=i.getStringExtra("Weight");
        height=i.getStringExtra("Height");
      //  Toast.makeText(getApplicationContext(),name+mail+password+gender,Toast.LENGTH_SHORT).show();

        if (routine != null) {
            routine.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    routineRadioButton = findViewById(i);
                    // Toast.makeText(Signup_activity.this, routineRadioButton.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
     //   Toast.makeText(getApplicationContext(),mail,Toast.LENGTH_LONG).show();
       // Toast.makeText(getApplicationContext(),name+email+password+gender,Toast.LENGTH_SHORT).show();
        submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
            //    int w=Integer.parseInt(weight);
               // int h=Integer.parseInt(height);
                UserModel   userModel = new UserModel(-1, mail, name, password, gender, 65, 180, routineRadioButton.getText().toString());

                DataBase dataBase = new DataBase(Routine.this);
               boolean success = dataBase.addOne(userModel);
               boolean yes = dataBase.inse();
                Toast.makeText(Routine.this, "Success= " + success, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
              //  Toast.makeText(getApplicationContext(),name+mail+password+gender+height+weight+routineRadioButton.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}