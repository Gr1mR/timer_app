package com.example.marko.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class WorkoutsActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener{

    ListView list;
    DBHelper db = new DBHelper(this);
    ArrayList<Workout> workouts;
    ArrayAdapter<Workout> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_workouts);
        list = (ListView)findViewById(R.id.workoutsList);
        workouts = db.getWorkouts();
        adapter = new ArrayAdapter<Workout>(this,android.R.layout.simple_list_item_1,workouts);
        list.setAdapter(adapter);
        list.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        db.deleteWorkout(adapter.getItem(position));
        workouts.remove(position);
        adapter.notifyDataSetChanged();
        return false;
    }
}
