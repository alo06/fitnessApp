package com.example.project;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class overallback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overallback);
        VideoView v6= findViewById(R.id.v6);
        v6.setVideoURI(Uri.parse("android.resource://"+getPackageName() + "/"+ R.raw.overallback));
        v6.start();
    }
}