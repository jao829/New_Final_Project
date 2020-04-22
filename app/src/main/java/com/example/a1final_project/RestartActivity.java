package com.example.a1final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RestartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart);
        Button restart = findViewById(R.id.restart);
        restart.setVisibility(View.VISIBLE);
        startActivity(new Intent(this, StartActivity.class));
        restart.setVisibility(View.GONE);
        finish();
    }
}
