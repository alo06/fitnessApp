package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Abs extends AppCompatActivity {
    Button upperabs,lowerabs,overallabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs);
        upperabs = findViewById(R.id.upperabs);
        lowerabs = findViewById(R.id.lowerabs);
        overallabs = findViewById(R.id.overallabs);
        upperabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Abs.this, upperabs.class));
            }
        });
        lowerabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Abs.this, lowerabs.class));
            }
        });
        overallabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Abs.this, overallabs.class));
            }
        });
    }
}