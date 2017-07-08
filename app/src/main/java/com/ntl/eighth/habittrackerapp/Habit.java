package com.ntl.eighth.habittrackerapp;

/**
 * Created by boody 2 on 08/07/2017.
 */

public class Habit {
    public Habit(int id, String task, int type) {
        this.id = id;
        this.task = task;
        this.type = type;
    }

    public Habit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    int id;
    String task;
    int type;





}
