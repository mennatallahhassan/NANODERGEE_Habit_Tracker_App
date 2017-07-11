package com.ntl.eighth.habittrackerapp;

import android.provider.BaseColumns;

/**
 * Created by boody 2 on 11/07/2017.
 */

public class DBContract {
    public static final int DB_version = 1;
    public static final String DB_name = "database.db";

    public class Habit_Table implements BaseColumns {

        public static final String Table_Name = "habit";
        public static final String Id = "id";
        public static final String Task = "task";
        public static final String Type = "type";


        public static final String createTable = "Create table " + Table_Name + "(" + Id + " integer primary key," + Task + " Text," + Type + " integer)";
        public static final String deleteTable = "Drop table if exists " + Table_Name;
    }

}
