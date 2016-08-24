package com.example.marko.timer;

import java.sql.Time;

/**
 * Created by Marko on 22.8.2016..
 */
public class Workout {
    Time warmUp;
    Time streach;
    Time prepare;
    Time rest;
    Time round;
    Time cooldown;
    Number nOfRounds;
    String name;

    public Workout(String name, Time warmUp, Time stretch, Number nOfRounds, Time prepare, Time rest, Time round, Time cooldown) {
        super();
        this.warmUp = warmUp;
        this.name = name;
        this.streach = stretch;
        this.nOfRounds = nOfRounds;
        this.prepare = prepare;
        this.rest = rest;
        this.round = round;
        this.cooldown = cooldown;
    }


    public String getName() {
        return name;
    }

    public Time getWarmUp() {
        return warmUp;
    }

    public Time getStretch() {
        return streach;
    }

    public Number getnOfRounds() {
        return nOfRounds;
    }

    public Time getPrepare() {
        return prepare;
    }

    public Time getRest() {
        return rest;
    }

    public Time getRound() {
        return round;
    }

    public Time getCooldown() {
        return cooldown;
    }
}
