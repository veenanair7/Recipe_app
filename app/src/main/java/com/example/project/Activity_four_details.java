package com.example.project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Activity_four_details extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private TextView mLoadingText;
    private TextView mLoadingText1;
    private TextView mLoadingText2;

    private DBManager dbManager;
    private ArrayList<Database> FavList;
    int mProgressStatus = 0;
    EditText edit;
    CheckBox check;
    Button button1;
    Button button2;
    private Handler mHandler = new Handler();
    SharedPreferences sharedpreferences;

    public static final String mypreference = "mypref";

    public static final String Comment = "nameKey";
    View v;




    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_details);
        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mLoadingText = (TextView) findViewById(R.id.textView);
        mLoadingText1 = (TextView) findViewById(R.id.textView1);
        mLoadingText2 = (TextView) findViewById(R.id.textView3);
        edit = (EditText) findViewById(R.id.edittext);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button1);
        check = (CheckBox) findViewById(R.id.checkBox);
        if (cursor != null) {
            for (int i = 0; i < cursor.getCount(); i++) {
                Database p = new Database(cursor.getLong(cursor.getColumnIndex(DatabaseHelper._ID)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.SUBJECT)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.ADDED)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.NOTADDED)));
                //  FavList.add(p);
                cursor.moveToNext();
                p = null;
            }
            // personAdapter.notifyDataSetChanged();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100) {
                    mProgressStatus++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoadingText.setVisibility(View.VISIBLE);
                        mLoadingText1.setVisibility(View.VISIBLE);
                        mLoadingText2.setVisibility(View.VISIBLE);
                        edit.setVisibility(View.VISIBLE);
                        button1.setVisibility(View.VISIBLE);
                        button2.setVisibility(View.VISIBLE);
                        check.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();


        check = findViewById(R.id.checkBox);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }

        });
        v = findViewById(android.R.id.content);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Successfully saved", Snackbar.LENGTH_LONG).show();
            }
        });

    }

    private void showAlertDialog () {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Activity_four_details.this);
        alertDialog.setTitle("AlertDialog");
        String[] items = {"Add to favourite", "Do not add to favourite"};
        boolean[] checkedItems = {false, false,};
        alertDialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                switch (which) {
                    case 0:
                        if (isChecked) {
                            Toast.makeText(Activity_four_details .this, "Done", Toast.LENGTH_LONG).show();
                            final Database p = new Database((long) 0, "Paneer Masala", "yes", "no");
                            // FavList.add(p);
                            dbManager.insert(p);

                        }
                        break;
                    case 1:
                        if (isChecked) {
                            Toast.makeText(Activity_four_details .this, "Not Added", Toast.LENGTH_LONG).show();
                            final Database p = new Database((long) 0, "Paneer Masala", "no", "yes");
                            dbManager.insert(p);



                        }
                        break;
                }

            }
        });

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);

        alert.show();
        //alert.dismiss();


    }
    public void Get (View view){

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        String n = edit.getText().toString();
        //String e = email.getText().toString();

        SharedPreferences.Editor editor =
                sharedpreferences.edit();
        // editor === edit mypref file
        editor.putString(Comment, n);
        //editor.putString(Email, e);
        editor.commit();


        if (sharedpreferences.contains(Comment)) {
            mLoadingText2.setText(sharedpreferences.getString(Comment, ""));
        }

    }
}

