package com.example.a1final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //creating button
        Button start = findViewById(R.id.start);
        //making button visible
        start.setVisibility(View.VISIBLE);
        //switches from StartActivity to CalculateActivity
        //int count = -1;
        //count++;
        //if (count == 0) {
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(StartActivity.this, CalculateActivity.class));
                }
            });
        //} else {
        //    startActivity(new Intent(this, CalculateActivity.class));
        //}

    }
}
