package com.example.project;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class upperchest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upperchest);
        VideoView vv= findViewById(R.id.vv);
        vv.setVideoURI(Uri.parse("android.resource://"+getPackageName() + "/"+ R.raw.inclinepushup));
        vv.start();
    }
}