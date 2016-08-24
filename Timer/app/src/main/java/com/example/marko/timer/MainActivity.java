package com.example.marko.timer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button createButton;
    private Button workoutsButton;
    private Button mapButton;
    private Button settingsButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Settings();
        Create();
        Workouts();
        Map();

    }

    public void Settings() {
        settingsButton = (Button) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent settings = new Intent("com.example.marko.timer.SettingActivity");
                        startActivity(settings);
                    }
                }
        );
    }

    public void Create() {
        createButton = (Button) findViewById(R.id.createButton);
        createButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent create = new Intent("com.example.marko.timer.CreateActivity");
                        startActivity(create);
                    }
                }
        );
    }

    public void Workouts() {
         workoutsButton= (Button) findViewById(R.id.workoutsButton);
        workoutsButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent workouts = new Intent("com.example.marko.timer.WorkoutsActivity");
                        startActivity(workouts);
                    }
                }
        );
    }

    public void Map() {
        mapButton= (Button) findViewById(R.id.mapButton);
        mapButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent map = new Intent("com.example.marko.timer.WorkoutsActivity");
                        startActivity(map);
                    }
                }
        );
    }

}

