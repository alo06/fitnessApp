package com.example.project;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class lowerchest extends AppCompatActivity {
 VideoView vv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lowerchest);
         vv1 = findViewById(R.id.vv1);
        vv1.setVideoURI(Uri.parse("android.resource://"+getPackageName() + "/"+ R.raw.declinepushups));
        vv1.start();
    }
}