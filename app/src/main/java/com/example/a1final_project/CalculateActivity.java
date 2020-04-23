package com.example.a1final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        //creates buttons
        Button calculate = findViewById(R.id.calculate);
        findViewById(R.id.goal).setVisibility(View.VISIBLE);
        calculate.setVisibility(View.VISIBLE);
    }
}
