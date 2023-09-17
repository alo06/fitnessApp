package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Chest extends AppCompatActivity {
    Button upperchest,lowerchest,overallchest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);
        upperchest = findViewById(R.id.upperchest);
        lowerchest = findViewById(R.id.lowerchest);
        overallchest = findViewById(R.id.overallchest);
        upperchest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Chest.this,upperchest.class));
            }
        });
        lowerchest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Chest.this, lowerchest.class));
            }
        });
        overallchest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Chest.this,overallchest.class));
            }
        });



    }
}