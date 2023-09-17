package com.example.project;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class upperabs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upperabs);
        VideoView v10= findViewById(R.id.v10);
        v10.setVideoURI(Uri.parse("android.resource://"+getPackageName() + "/"+ R.raw.upperabs));
        v10.start();
    }
}