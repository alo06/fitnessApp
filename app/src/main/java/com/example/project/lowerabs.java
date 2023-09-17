package com.example.project;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class lowerabs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lowerabs);
        VideoView v11= findViewById(R.id.v11);
        v11.setVideoURI(Uri.parse("android.resource://"+getPackageName() + "/"+ R.raw.lowerabs));
        v11.start();
    }
}