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
        Intent intent = getIntent();
        int x = intent.getIntExtra("goalPace", 0);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RestartActivity.this, StartActivity.class));
                finish();
            }
        });
        //startActivity(new Intent(this, StartActivity.class));
    }
}
