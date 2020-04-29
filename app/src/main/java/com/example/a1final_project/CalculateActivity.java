package com.example.a1final_project;

import androidx.appcompat.app.AlertDialog;
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
                String goalPace = goal.getText().toString();
                String distanceRan = distance.getText().toString();
                String timeRan = time.getText().toString();
                if (goalPace.contains(":") && timeRan.contains(":")) {
                    String[] goalPACE = goalPace.split(":");
                    String[] timeRan1 = timeRan.split(":");
                    //gets the goalpace in minutes as a double

                    if (goalPACE.length != 2 || timeRan1.length != 2) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(CalculateActivity.this);
                        builder.setMessage("Please enter valid entry for Time and Goal Pace: input must only contain 1 colon (EX: 7:00)");
                        builder.create().show();
                        return;
                    }
                    if (goalPACE[1].length() != 2 ||  timeRan1[1].length() != 2) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(CalculateActivity.this);
                        builder.setMessage("Please enter valid entry for Time and Goal Pace: seconds must only contain 2 digits (EX: 7:00)");
                        builder.create().show();
                        return;
                    }
                    if (Integer.parseInt(goalPACE[1] ) >= 60 || Integer.parseInt(timeRan1[1]) >= 60) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(CalculateActivity.this);
                        if (Integer.parseInt(goalPACE[1] ) >= 60) {
                            builder.setMessage("Please enter valid entry for Time and Goal Pace: " + goalPACE[1] + " is not a valid entry for seconds");
                            builder.create().show();
                            return;
                        }
                        builder.setMessage("Please enter valid entry for Time and Goal Pace: " + timeRan1[1] + " is not a valid entry for seconds");
                        builder.create().show();
                        return;
                    }
                    double goalpace = Double.parseDouble(goalPACE[0]) + (Double.parseDouble(goalPACE[1]) / 60);
                    //gets the time in minutes as a double
                    double timeRan2 = Double.parseDouble(timeRan1[0]) + (Double.parseDouble(timeRan1[1]) / 60);
                    //creates intent and puts user's input values
                    Intent intent = new Intent(CalculateActivity.this, RestartActivity.class);
                    intent.putExtra("goalPace", goalpace);
                    intent.putExtra("distance", Double.parseDouble(distanceRan));
                    intent.putExtra("time", timeRan2);
                    //starts the next activity
                    startActivity(intent);
                    if (goalpace < timeRan2 / Double.parseDouble(distanceRan)) {
                        booing.start();
                    } else {
                        cheering.start();
                    }
                    finish();

                } else {
                    if (goalPace.isEmpty()|| distanceRan.isEmpty() || timeRan.isEmpty()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(CalculateActivity.this);
                        builder.setMessage("Please enter values for all sections");
                        builder.create().show();
                        return;
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(CalculateActivity.this);
                        builder.setMessage("Please enter valid entry for Time and Goal Pace: input must contain a colon (EX: 7:00)");
                        builder.create().show();
                    }
                }

            }
        });
    }
}
