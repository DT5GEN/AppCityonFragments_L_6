package com.example.appcityonfragments_l_6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class CitiesFragment extends Fragment {

    City currentCity;
    boolean isLandScape;

    public static CitiesFragment newInstance() {
        return new CitiesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewCitiesFragment = inflater.inflate(R.layout.fragment_cities, container, false);

        LinearLayout linearLayoutOfCitiesFragment = (LinearLayout) viewCitiesFragment;
        String[] citiesList = getResources().getStringArray(R.array.cities_names);


        for (int i = 0; i < citiesList.length; i++) {
            String nameCity = citiesList[i];
            TextView textViewFromCitiesFragment = new TextView(getContext());
            textViewFromCitiesFragment.setText(nameCity);
            textViewFromCitiesFragment.setTextSize(33);
            linearLayoutOfCitiesFragment.addView(textViewFromCitiesFragment);
            int finalI = i;
            textViewFromCitiesFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentCity = new City(finalI,
                            (getResources().getStringArray(R.array.cities_names)[finalI]));
                    isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
                    showCoatOfArms();
                }
            });
        }

        return viewCitiesFragment;
    }

    private void showCoatOfArms() {
        if (isLandScape) { // альбомная ориентация
            showCoatOfArmsLand();
        } else { // портретная ориентация
            showCoatOfArmsPort();
        }
    }

    private void showCoatOfArmsPort() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.cities_container, CoatOfArmsFragment.newInstance(currentCity))
                .addToBackStack("")
                .commit();
    }

    private void showCoatOfArmsLand() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.coat_of_arms_container, CoatOfArmsFragment.newInstance(currentCity))
                .commit();
    }


}


