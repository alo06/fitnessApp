package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup_activity extends AppCompatActivity {
    EditText email, signPassword,name,weight,height;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        getSupportActionBar().hide();
        email=findViewById(R.id.emailTxt);
        signPassword =findViewById(R.id.signUppassword);
        name=findViewById(R.id.name);
        next=findViewById(R.id.btntogender);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((signPassword.getText().toString()).length()<6){
                    Toast.makeText(getApplicationContext(),"Password Not Strong ",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i=new Intent(getApplicationContext(),Gender.class);
                    i.putExtra("Name",name.getText().toString());
                    i.putExtra("Email",email.getText().toString());
                    i.putExtra("Password",signPassword.getText().toString());
                    startActivity(i);
                }

            }
        });
    }
}