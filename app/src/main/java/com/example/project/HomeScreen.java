package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class HomeScreen extends AppCompatActivity {
    String name,conclusion;
    TextView userName,userWeight,userHeight,userBMI;
    DataBase dataBase=new DataBase(HomeScreen.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Intent i=getIntent();
        name=i.getStringExtra("Name");
        getSupportActionBar().hide();
        userName=findViewById(R.id.username);
        userName.setText(" Hi "+name);
        List<UserModel> user=dataBase.information(name);
        userHeight=findViewById(R.id.userheight);
        userWeight=findViewById(R.id.userweight);
        userBMI=findViewById(R.id.userbmi);
        for(final UserModel it:user){
            Integer weight=it.getWeight();
            userWeight.setText("Weight :"+weight.toString());
            Integer height=it.getHeight();
            userHeight.setText("Height :"+height.toString());
            Integer bmi=(10000*weight)/(height*height);
            if(bmi<=18.5){
                conclusion=" UnderWeight";
            }
            else if(bmi>18.5 && bmi<=24.9){
                conclusion=" Normal";
            }
            else if(bmi>25 && bmi<=29.9){
                conclusion=" OverWeight";
            }
            else{
                conclusion=" Obesity ";
            }
            userBMI.setText("Your BMI is "+bmi+"\nThus you are "+conclusion);
        }
        Toast.makeText(HomeScreen.this,user.toString(),Toast.LENGTH_LONG).show();

    }
}