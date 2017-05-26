package com.example.shoo.gptrial2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = SaveSharedPreference.getSharedPreferences(HomeActivity.this).edit();
                editor.clear(); //clear all stored data
                editor.commit();

                Snackbar.make(view, "logout", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
                finish();

            }
        });
        HomeActivityFragment HomeFragment = new HomeActivityFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.homeActivityLayout,HomeFragment);
        fragmentTransaction.commit();


    }

}
