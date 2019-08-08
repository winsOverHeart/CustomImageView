package com.example.abhishek.customimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        CustomImageView customImageView = new CustomImageView(this);
        CustomImageView myView = new CustomImageView(getApplicationContext());
        System.out.println("Setting the view");
        myView.invalidate();
        setContentView(myView);
        System.out.println("Calling invalidate");

    }
}
