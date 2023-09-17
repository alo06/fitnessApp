package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Gender extends AppCompatActivity {
    ImageView male,female;
    String gender,name,email,password;
    Button next;
    int f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        male=findViewById(R.id.maleimg);
        female=findViewById(R.id.femaleimg);
        getSupportActionBar().hide();
        next=findViewById(R.id.btntoweight);
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender="Male";
                f=0;
                Toast.makeText(getApplicationContext(),"Male",Toast.LENGTH_SHORT).show();
                    male.setBackgroundColor(Color.rgb(173, 216, 230));
                    female.setBackgroundColor(0x00000000);
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender="Female";
                Toast.makeText(getApplicationContext(),"Female",Toast.LENGTH_SHORT).show();
                female.setBackgroundColor(Color.rgb(255, 182, 193));
                male.setBackgroundColor(0x00000000);
            }
        });
        Intent i=getIntent();
        name=i.getStringExtra("Name");
        email=i.getStringExtra("Email");
        password=i.getStringExtra("Password");
        Toast.makeText(getApplicationContext(),name+email+password,Toast.LENGTH_SHORT).show();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getApplicationContext(),WeightHeight.class);
                it.putExtra("Gender",gender);
                it.putExtra("Name",name);
                it.putExtra("Email",email);
                it.putExtra("Password",password);
                startActivity(it);
            }
        });
    }
}