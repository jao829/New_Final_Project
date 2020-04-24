package com.example.a1final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        final EditText distance = findViewById(R.id.distance);
        final EditText time = findViewById((R.id.time));
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goalpace1 = goal.getText().toString();
                String distanceRan = distance.getText().toString();
                String timeRan = time.getText().toString();
                if (goalpace1.contains(":") && !(timeRan.contains(":"))) {
                    String[] goalpace2 = goalpace1.split(":");
                    //gets the time in minutes as a double
                    double goalpace = Double.parseDouble(goalpace2[0]) + (Double.parseDouble(goalpace2[1]) / 60);
                    //creates intent and puts user's input values
                    Intent intent = new Intent(CalculateActivity.this, RestartActivity.class);
                    intent.putExtra("goalPace", goalpace);
                    intent.putExtra("distance", Double.parseDouble(distanceRan));
                    intent.putExtra("time", Double.parseDouble(timeRan));
                    //starts the next activity
                    startActivity(intent);
//                if (goalpace > distance divided by time) {
//                    booing.start();
//                } else {
//                    cheering.start();
//                }
                    finish();
                } else if (goalpace1.contains(":") && timeRan.contains(":")) {
                    String[] goalpace2 = goalpace1.split(":");
                    String[] timeRan1 = timeRan.split(":");
                    //gets the goalpace in minutes as a double
                    double goalpace = Double.parseDouble(goalpace2[0]) + (Double.parseDouble(goalpace2[1]) / 60);
                    //gets the time in minutes as a double
                    double timeRan2 = Double.parseDouble(timeRan1[0]) + (Double.parseDouble(timeRan1[1]) / 60);
                    //creates intent and puts user's input values
                    System.out.println(goalpace);
                    System.out.println(timeRan);
                    Intent intent = new Intent(CalculateActivity.this, RestartActivity.class);
                    intent.putExtra("goalPace", goalpace);
                    intent.putExtra("distance", Double.parseDouble(distanceRan));
                    intent.putExtra("time", timeRan2);
                    //starts the next activity
                    startActivity(intent);
//                if (goalpace > distance divided by time) {
//                    booing.start();
//                } else {
//                    cheering.start();
//                }
                    finish();
                } else if (!(goalpace1.contains(":")) && timeRan.contains(":")) {
                    String[] timeRan1 = timeRan.split(":");
                    //gets the goalpace in minutes as a double
                    //gets the time in minutes as a double
                    double timeRan2 = Double.parseDouble(timeRan1[0]) + (Double.parseDouble(timeRan1[1]) / 60);
                    //creates intent and puts user's input values
                    Intent intent = new Intent(CalculateActivity.this, RestartActivity.class);
                    intent.putExtra("goalPace", Double.parseDouble(goalpace1));
                    intent.putExtra("distance", Double.parseDouble(distanceRan));
                    intent.putExtra("time", timeRan2);
                    //starts the next activity
                    startActivity(intent);
//                if (goalpace > distance divided by time) {
//                    booing.start();
//                } else {
//                    cheering.start();
//                }
                    finish();
                } else {
                    double goalpace = Double.parseDouble(goalpace1);
                    Intent intent = new Intent(CalculateActivity.this, RestartActivity.class);
                    intent.putExtra("goalPace", goalpace);
                    intent.putExtra("distance", Double.parseDouble(distanceRan));
                    intent.putExtra("time", Double.parseDouble(timeRan));
                    startActivity(intent);
                    //                if (goalpace > distance divided by time) {
                    //                    booing.start();
                    //                } else {
                    //                    cheering.start();
                    //                }
                    finish();
                }
            }
        });
    }
}
