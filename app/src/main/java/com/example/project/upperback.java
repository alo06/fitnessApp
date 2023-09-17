
package com.example.project;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class upperback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upperback);
        VideoView v3= findViewById(R.id.v3);
        v3.setVideoURI(Uri.parse("android.resource://"+getPackageName() + "/"+ R.raw.pullups));
        v3.start();
    }
}