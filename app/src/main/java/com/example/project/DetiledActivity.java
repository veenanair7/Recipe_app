package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DetiledActivity extends AppCompatActivity implements View.OnClickListener {

     Spanned Text;
    TextView HyperLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detiled);
//        HyperLink = (TextView) findViewById(R.id.textView1);
//
//        Text = Html.fromHtml("<a href='https://www.indianhealthyrecipes.com/kadai-chicken/'>Kadai Chicken Recipe URL</a>");
//
//        HyperLink.setMovementMethod(LinkMovementMethod.getInstance());
//        HyperLink.setText(Text);


        Button btn5 = (Button) findViewById(R.id.button);
        btn5.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onClick(View view) {

        Fragment fragment = null;


        int i =0;
        switch (view.getId()) {
            case R.id.button:

                fragment = new Fragment_one();
                i = 0;
                break;


        }
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.output, fragment,"Fragment_one");



//        transaction.addToBackStack(fragment.toString());
        transaction.commit();


        Log.d("fragmentManager", String.valueOf(manager.getBackStackEntryCount()));
    }
    public void ActivityLoad(View view) {
        Intent i = new Intent(DetiledActivity.this, DetailedActivityOne.class);
        startActivity(i);
    }


}
