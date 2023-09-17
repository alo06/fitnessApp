package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Back extends AppCompatActivity {
    Button upperback,lowerback,overallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        upperback = findViewById(R.id.upperback);
        lowerback = findViewById(R.id.lowerback);
        overallback = findViewById(R.id.overallback);
        upperback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Back.this, upperback.class));
            }
        });
        lowerback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Back.this, lowerback.class));
            }
        });
        overallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Back.this, overallback.class));
            }
        });
    }
}