package com.example.project;
/**
 * Created by Amit Modak.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class  DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "FavoriteList";
    // Table columns
    public static final String _ID = "_id";
    public static final String SUBJECT = "Recipe_name";
    public static final String ADDED = "Added_to_favorites";
    public static final String NOTADDED = "Not_added";
    // Database Information
    static final String DB_NAME = "Recipe_name.DB";
    // database version
    static final int DB_VERSION = 1;

    // Creating table queryDBManager
    private static final String CREATE_TABLE = "create table "
            + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + SUBJECT + " TEXT NOT NULL, "
            + ADDED + " INTEGER, "
            + NOTADDED + " INTEGER );";

//    create table `COUNTRIES` ( `_id` integer primary autoincrement,
//            `subkect` text not null,
//            `desc` text);


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


//    create table COUNTRIES(_id INTEGER PRIMARY KEY AUTOINCREMENT, subject TEXT NOT NULL description TEXT );
//    create table COUNTRIES(_id INTEGER PRIMARY KEY AUTOINCREMENT, subject TEXT NOT NULL, description TEXT );
// One time method through out application life.....once -----

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//2 == 3
        if (oldVersion == newVersion) {
            // no change in DB
        } else {

            // changes in DB

            // Add table which are new....

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

            onCreate(db);


        }
        /* alter table or new tables */
    }


}