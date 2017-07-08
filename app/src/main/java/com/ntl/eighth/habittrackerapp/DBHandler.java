package com.ntl.eighth.habittrackerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by boody 2 on 08/07/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final String Table_Name = "habit";
    private static final String Id = "id";
    private static final String Task = "task";
    private static final String Type = "type";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "Create table " + Table_Name + "(" + Id + " INTEGER PRIMARY KEY," + Task + " Text," + Type + " text)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion)
            db.execSQL("Drop table if exists " + Table_Name);
        onCreate(db);
    }


    // Adding new Habit
    public void insertHabit(Habit habit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Task, habit.getTask());

        db.insert(Table_Name, null, contentValues);
        db.close();
    }

    // Getting single Habit
    public Habit readHabit(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Table_Name, new String[]{Id, Task, Type}, Id + "=?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Habit habit = new Habit(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)));
        return habit;
    }


}
