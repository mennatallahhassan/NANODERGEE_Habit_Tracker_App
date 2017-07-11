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


    public DBHandler(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DBContract.DB_name, factory, DBContract.DB_version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DBContract.Habit_Table.createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion)
            db.execSQL(DBContract.Habit_Table.deleteTable);
        onCreate(db);
    }


    // Adding new Habit
    public void insertHabit(Habit habit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBContract.Habit_Table.Task, habit.getTask());
        contentValues.put(DBContract.Habit_Table.Type, habit.getType());
        db.insert(DBContract.Habit_Table.Table_Name, null, contentValues);
        db.close();
    }

    public Cursor getHabit(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DBContract.Habit_Table.Table_Name, new String[]{DBContract.Habit_Table.Id, DBContract.Habit_Table.Task, DBContract.Habit_Table.Type}, DBContract.Habit_Table.Id + "=?", new String[]{String.valueOf(id)}, null, null, null, null);

        return cursor;
    }


}
