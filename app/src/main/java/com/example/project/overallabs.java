package com.example.project;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class overallabs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overallabs);
        VideoView v12= findViewById(R.id.v12);
        v12.setVideoURI(Uri.parse("android.resource://"+getPackageName() + "/"+ R.raw.plank));
        v12.start();
    }
}