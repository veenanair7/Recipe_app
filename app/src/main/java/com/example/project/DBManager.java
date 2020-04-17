package com.example.project;

/**
 * Created by Amit Modak.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
//        boolean isWritable
//        try {
        dbHelper = new DatabaseHelper(context);
//        if(isWritable)
        database = dbHelper.getWritableDatabase();
//        else
//            database = dbHelper.getReadableDatabase();
//        }catch (SQLException ex)
//        {
//            // do operations.
//        }
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(Database person) {//String message, boolean sent, boolean received) {

        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.SUBJECT, person.getSubject());
        contentValue.put(DatabaseHelper.ADDED, person.getSent());
        contentValue.put(DatabaseHelper.NOTADDED, person.getReceived());

        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);

    }

    public Cursor fetch() {
        String[] columns = new String[]{DatabaseHelper._ID, DatabaseHelper.SUBJECT, DatabaseHelper.ADDED, DatabaseHelper.NOTADDED};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);


        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, boolean sent, boolean rcvd) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.SUBJECT, name);
        contentValues.put(DatabaseHelper.ADDED, sent);
        contentValues.put(DatabaseHelper.NOTADDED, rcvd);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        //update contact set subject = name, description = desc where id =1
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);

    }

}
