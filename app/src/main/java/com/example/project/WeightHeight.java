package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WeightHeight extends AppCompatActivity {
    EditText height,weight;
    String Height,Weight;
    String gender,name,email,password;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_height);
        height=findViewById(R.id.HeightText);
        next=findViewById(R.id.btntoroutine);
        weight=findViewById(R.id.weightText);
        Height=height.getText().toString();
        Weight=weight.getText().toString();
        getSupportActionBar().hide();
        Intent i=getIntent();
        name=i.getStringExtra("Name");
        email=i.getStringExtra("Email");
        password=i.getStringExtra("Password");
        gender=i.getStringExtra("Gender");
      //  Toast.makeText(getApplicationContext(),name+email+password+gender,Toast.LENGTH_SHORT).show();
       // Toast.makeText(getApplicationContext(),name+email+password+gender+Height+Weight,Toast.LENGTH_SHORT).show();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getApplicationContext(),Routine.class);
                it.putExtra("Height",Height);
                it.putExtra("Weight",Weight);
                it.putExtra("Gender",gender);
                it.putExtra("Name",name);
                it.putExtra("Email",email);
                it.putExtra("Password",password);
                //Toast.makeText(getApplicationContext(),name+email+password+gender+Height+Weight,Toast.LENGTH_SHORT).show();
                startActivity(it);
            }
        });
    }
}