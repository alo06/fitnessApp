package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CalorieCounter extends AppCompatActivity {
    ProgressBar pb;
    Button add,clear;
  //  ArrayAdapter<String> adapter;
   // ArrayList<String> arrayList;
//   ListView listView;
    TextView required,till,meals;
    EditText food,grams;
    int ans=0;
    int count=1;
    DataBase dataBase=new DataBase(CalorieCounter.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_counter);
        pb=(ProgressBar)findViewById(R.id.progressBar2);
        add=findViewById(R.id.caloriebtn);
        food=findViewById(R.id.foodText);
        grams=findViewById(R.id.gmsText);
        required=findViewById(R.id.requiredText);
        till=findViewById(R.id.tillText);
        meals=findViewById(R.id.Meals);
     // listView=  findViewById(R.id.list);
      // arrayList=new ArrayList<String>();
   //   adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.activity_list_item,arrayList);
   //   listView.setAdapter(adapter);
        clear=findViewById(R.id.clearcal);
        till.setText("Till Now - "+ans);
        required.setText("Required - 2023");
        getSupportActionBar().hide();
        pb.setMax(2303);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String f=food.getText().toString();
                    count = dataBase.calorie(f);
                    ans += count;
                  //  arrayList.add(f+" - "+count);
             //       adapter.notifyDataSetChanged();
                    pb.setProgress(ans);
                    count = 0;
                    till.setText("Till Now - " + ans);

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb.setProgress(0);
                ans=0;
                count=0;
                till.setText("Till Now - "+ans);
            }
        });
        meals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Meals.class);
                startActivity(i);
            }
        });
    }
}