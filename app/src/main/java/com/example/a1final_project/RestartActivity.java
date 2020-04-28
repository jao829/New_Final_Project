package com.example.a1final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.Button;
import android.widget.TextView;

public class RestartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart);
        Button restart = findViewById(R.id.restart);
        restart.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        //in minutes and miles
        double goal = intent.getDoubleExtra("goalPace", 0);
        double distance = intent.getDoubleExtra("distance", 0);
        double time = intent.getDoubleExtra("time", 0);
        //user pace as a double (need to convert into time)
        double userPace = time / distance;
        String pace = String.valueOf(userPace);
        //pace = pace.substring(0, 4) + " min/mile";
        //TextView setpace = findViewById(R.id.avgPace);
        //setpace.setText(pace);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RestartActivity.this, StartActivity.class));
                finish();
            }
        });

    }
}
