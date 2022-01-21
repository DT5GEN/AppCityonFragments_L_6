package com.example.appcityonfragments_l_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // CitiesFragment citiesFragment = CitiesFragment.newInstance(); для большей наглядности

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.cities, CitiesFragment.newInstance())
                .commit();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.coat_of_arms, CoatOfArmsFragment.newInstance())
                    .commit();
        }
    }
}