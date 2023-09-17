package com.example.project;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class lowerback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lowerback);
        VideoView v5= findViewById(R.id.v5);
        v5.setVideoURI(Uri.parse("android.resource://"+getPackageName() + "/"+ R.raw.lowerback));
        v5.start();
    }
}