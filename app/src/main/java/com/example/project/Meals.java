package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class Meals extends AppCompatActivity {
    CardView salad,ricebowl,vegchili,peanut;
    Dialog saladialog,ricebowldialog,vegchilidialog,peanutdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        getSupportActionBar().hide();
        salad=findViewById(R.id.cardView6);
        saladialog= new Dialog(this);
        ricebowl=findViewById(R.id.cardview);
        ricebowldialog=new Dialog(this);
        vegchili=findViewById(R.id.cardView2);
        vegchilidialog=new Dialog(this);
        peanut=findViewById(R.id.cardView5);
        peanutdialog=new Dialog(this);
        salad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saladialog.setContentView(R.layout.salad);
                saladialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                saladialog.show();
            }
        });
        ricebowl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ricebowldialog.setContentView(R.layout.ricebowl);
                ricebowldialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                ricebowldialog.show();
            }
        });
        vegchili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vegchilidialog.setContentView(R.layout.vegchili);
                vegchilidialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                vegchilidialog.show();
            }
        });
        peanut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peanutdialog.setContentView(R.layout.peanutbutter);
                peanutdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                peanutdialog.show();
            }
        });
    }
}