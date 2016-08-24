package com.example.marko.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Time;

public class CreateActivity extends AppCompatActivity {

    Button addWork;
    EditText warmUp, streach, nOfRounds, prepare, rest, round, cooldown, name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        final DBHelper db = new DBHelper(this);
        addWork = (Button)findViewById(R.id.addWork);
        warmUp = (EditText)findViewById(R.id.warmUp);
        streach = (EditText)findViewById(R.id.streach);
        nOfRounds = (EditText)findViewById(R.id.nOfRounds);
        prepare = (EditText)findViewById(R.id.prepare);
        rest = (EditText)findViewById(R.id.rest);
        round = (EditText)findViewById(R.id.round);
        cooldown = (EditText)findViewById(R.id.cooldown);
        name = (EditText)findViewById(R.id.workid);
        addWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String WorkoutName = name.getText().toString();
                Time WarmUp = (Time) warmUp.getText();
                Time Stretch = (Time) streach.getText();
                Number NofRounds = (Number) nOfRounds.getText();
                Time Prepare = (Time) prepare.getText();
                Time Rest = (Time) rest.getText();
                Time Round = (Time) round.getText();
                Time Cooldown = (Time) cooldown.getText();
                Workout w = new Workout(WorkoutName,WarmUp,Stretch,NofRounds,Prepare,Rest,Round,Cooldown);
                db.addWorkout(w);
                Toast.makeText(CreateActivity.this,"DataSaved",Toast.LENGTH_LONG).show();
            }
        });
    }

}
