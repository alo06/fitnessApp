
package com.example.project;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class overallchest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overallchest);
        VideoView v4= findViewById(R.id.v4);
        v4.setVideoURI(Uri.parse("android.resource://"+getPackageName() + "/"+ R.raw.pushups));
        v4.start();
    }
}