package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class HomeScreen extends AppCompatActivity {
    String name,conclusion;
    Button update;
    TextView userName,userWeight,userHeight,userBMI,userSteps;
    DataBase dataBase=new DataBase(HomeScreen.this);
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Intent i = getIntent();
        name = i.getStringExtra("Name");

        getSupportActionBar().hide();
        userName = findViewById(R.id.username);
        update=findViewById(R.id.updateBtn);
        CardView myCardView5 = findViewById(R.id.my_cardview5);
        myCardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, CalorieCounter.class);
                startActivity(intent);
            }
        });

        CardView my_cardView4 = findViewById(R.id.my_cardview4);
        my_cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, StepTracker.class);
                startActivity(intent);
            }
        });

        CardView myCardView6 = findViewById(R.id.my_cardview6);
        myCardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, exercise.class);
                startActivity(intent);
            }
        });

        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(" Hey, "+" "+name);

// Get the start and end index of the name
        int startIndex = stringBuilder.toString().indexOf(name);
        int endIndex = startIndex + name.length();

// Apply bold and increased font size to the name
        stringBuilder.setSpan(new StyleSpan(Typeface.BOLD), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringBuilder.setSpan(new AbsoluteSizeSpan(38, true), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

// Set the text of the TextView to the SpannableStringBuilder
        userName.setText(stringBuilder);


        List<UserModel> user = dataBase.information(name);
        userHeight = findViewById(R.id.userheight);
        userWeight = findViewById(R.id.userweight);
        userBMI = findViewById(R.id.userbmi);
        userSteps=findViewById(R.id.StepsTaken);
        for (final UserModel it : user) {
            Integer weight = it.getWeight();
            userWeight.setText(weight.toString()+"kg");
            Integer height = it.getHeight();
            userHeight.setText(height.toString()+"cms");
            Integer bmi = (10000 * weight) / (height * height);
            if (bmi <= 18.5) {
                conclusion = " UnderWeight";
            } else if (bmi > 18.5 && bmi <= 24.9) {
                conclusion = " Normal";
            } else if (bmi > 25 && bmi <= 29.9) {
                conclusion = " OverWeight";
            } else {
                conclusion = " Obesity ";
            }
            userBMI.setText(String.valueOf(bmi));

            CardView myCardView = findViewById(R.id.my_cardview2);
            int color;

            if (bmi>25) {
                color = Color.parseColor("#FF0000"); // red
            } else if (bmi > 18.5 && bmi <= 24.9) {
                color = Color.parseColor("#00FF00"); // green
            } else {
                color = Color.parseColor("#0000FF"); // blue
            }

            myCardView.setCardBackgroundColor(color);

        }
        Intent intent = getIntent();
        int totalSteps = intent.getIntExtra("TotalSteps", 0); // 0 is the default value if TotalSteps is not found in the intent
        userSteps.setText(String.valueOf(totalSteps));
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Update.class);
                i.putExtra("Name",name);
                startActivity(i);
                recreate();
            }
        });
    }


      }
