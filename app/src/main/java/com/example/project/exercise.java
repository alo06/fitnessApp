package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class exercise extends AppCompatActivity {
    CardView Chest,Back,Arms,Abs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Chest = findViewById(R.id.chest);
        Back = findViewById(R.id.back);
        Arms = findViewById(R.id.arms);
        Abs =  findViewById(R.id.abs);
        Chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(exercise.this, Chest.class));
            }
        });
       Back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(exercise.this, Back.class));
           }
       });

       Arms.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(exercise.this,Arms.class));
           }
       });
       Abs.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(exercise.this, Abs.class));
           }
       });

    }
}