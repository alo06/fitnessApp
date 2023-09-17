package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    TextView signup;
    EditText username,password;
    DataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        username=findViewById(R.id.UserName);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);

        dataBase=new DataBase(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=username.getText().toString();
                String pass=password.getText().toString();

                if(name.equals("")||pass.equals("")){
                    Toast.makeText(MainActivity.this,"Fill the required Fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean checkCredentials = dataBase.checkNamePassword(name, pass);
                    if (checkCredentials == true) {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), HomeScreen.class);
                        i.putExtra("Name",name);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Login UnSuccessful", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Signup_activity.class);
                startActivity(i);
            }
        });
    }
}