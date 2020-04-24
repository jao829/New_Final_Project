package com.example.a1final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final MediaPlayer cheering = MediaPlayer.create(this, R.raw.cheering);
        final MediaPlayer booing = MediaPlayer.create(this, R.raw.booing);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        //creates buttons
        Button calculate = findViewById(R.id.calculate);
        findViewById(R.id.goal).setVisibility(View.VISIBLE);
        calculate.setVisibility(View.VISIBLE);
        final EditText goal = findViewById(R.id.goal);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int goalpace = Integer.parseInt(goal.getText().toString());
                Intent intent = new Intent(CalculateActivity.this, RestartActivity.class);
                intent.putExtra("goalPace", goalpace);
                startActivity(intent);
//                if (goalpace > distance divided by time) {
//                    booing.start();
//                } else {
//                    cheering.start();
//                }
                finish();
            }
        });

    }
}
