package com.example.marko.timer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.StreamHandler;

/**
 * Created by Marko on 22.8.2016..
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "workoutsDB";
    static final String TABLE_WORKOUTS = "workouts";
    static final String KEY_NAME = "name";
    static final String KEY_WARM_UP = "warmUp";
    static final String KEY_STRETCH = "stretch";
    static final String KEY_N_OF_ROUNDS = "nOfRounds";
    static final String KEY_PREPARE = "prepare";
    static final String KEY_REST = "rest";
    static final String KEY_ROUND = "round";
    static final String KEY_COOLDOWN = "cooldown";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_WORKOUTS_TABLE = "CREATE TABLE " + TABLE_WORKOUTS
                + "("
                + KEY_NAME + " TEXT PRIMARY KEY, " + KEY_WARM_UP + " INTEGER,"
                + KEY_STRETCH + " TIME, " + KEY_N_OF_ROUNDS + " INTEGER, "
                + KEY_PREPARE + " TIME, " + KEY_REST + " TIME, "
                + KEY_ROUND + " TIME, " + KEY_COOLDOWN + " TIME"
                + ")";
        db.execSQL(CREATE_WORKOUTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_IF = "DROP TABLE IF EXISTS " + TABLE_WORKOUTS;
        onCreate(db);
    }

    // Umetanje
    public void addWorkout(Workout workout) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, workout.getName());
        values.put(KEY_WARM_UP, String.valueOf(workout.getWarmUp()));
        values.put(KEY_STRETCH, String.valueOf(workout.getStretch()));
        values.put(KEY_N_OF_ROUNDS, (Integer) workout.getnOfRounds());
        values.put(KEY_PREPARE, String.valueOf(workout.getPrepare()));
        values.put(KEY_REST, String.valueOf(workout.getRest()));
        values.put(KEY_ROUND, String.valueOf(workout.getRound()));
        values.put(KEY_COOLDOWN, String.valueOf(workout.getCooldown()));
        db.insert(TABLE_WORKOUTS, KEY_NAME, values);
        db.close();
    }

    // Dohvaćanje liste
    public ArrayList<Workout> getWorkouts() {
        ArrayList<Workout> workouts = new ArrayList<Workout>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_WORKOUTS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Workout workout = new Workout(
                        cursor.getString(0), cursor.get), cursor.getString(2),
                        cursor.getString(3), cursor.getInt(4), cursor.getInt(5),
                        cursor.getInt(6), cursor.getInt(7));
                workouts.add(workout);
            } while (cursor.moveToNext());
        }
        db.close();
        return workouts;
    }

    // Brisanje po ID-u
    public void deleteWorkout(Workout workout) {
        String id = workout.getName();
        String[] arg = new String[]{String.valueOf(id)};
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_WORKOUTS, KEY_NAME + "=?", arg);
        db.close();
    }
}
