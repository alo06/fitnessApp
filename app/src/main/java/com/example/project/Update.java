package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Update extends AppCompatActivity {
    DataBase dataBase=new DataBase(Update.this);
    TextView updateName;
    EditText updateWeight,updateHeight;
    String name;
    Button updateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        getSupportActionBar().hide();
        updateName=findViewById(R.id.update_Name);
        updateHeight=findViewById(R.id.update_Height);
        updateWeight=findViewById(R.id.update_Weight);
        updateButton=findViewById(R.id.update_Button);
        Intent i=getIntent();
        name=i.getStringExtra("Name");
        updateName.setText(name);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    boolean isUpdate = dataBase.update(name,Integer.parseInt(updateWeight.getText().toString()),Integer.parseInt(updateHeight.getText().toString()));
                    if(isUpdate == true){
                        Toast.makeText(Update.this,"Successfully Updated",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Update.this,"Could Not Update",Toast.LENGTH_SHORT).show();
                    }
                    Intent i=new Intent(getApplicationContext(),HomeScreen.class);
                    i.putExtra("Name",name);
                    startActivity(i);
            }
        });
    }
}