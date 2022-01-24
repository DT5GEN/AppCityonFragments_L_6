package com.example.appcityonfragments_l_6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class CitiesFragment extends Fragment {

    private static final String CURRENT_CITY = "CurrentCity";
    City currentCity;
    boolean isLandScape;
    public static final String KEY_CITY = "KEY_CITY";

    public static CitiesFragment newInstance() {
        return new CitiesFragment();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(KEY_CITY, currentCity);
        super.onSaveInstanceState(outState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewCitiesFragment = inflater.inflate(R.layout.fragment_cities, container, false);

        LinearLayout linearLayoutOfCitiesFragment = (LinearLayout) viewCitiesFragment;
        createTextViewList(linearLayoutOfCitiesFragment);

        return viewCitiesFragment;
    }

    private void createTextViewList(LinearLayout linearLayoutOfCitiesFragment) {
        String[] citiesList = getResources().getStringArray(R.array.cities_names);

        LayoutInflater layoutInflater = getLayoutInflater();

        for (int i = 0; i < citiesList.length; i++) {
            String nameCity = citiesList[i];
            TextView textViewFromCitiesFragment = (TextView) layoutInflater.inflate(R.layout.item, linearLayoutOfCitiesFragment, false);
//            TextView textViewFromCitiesFragment = new TextView(getContext());
            textViewFromCitiesFragment.setText(nameCity);
//            textViewFromCitiesFragment.setTextSize(33);
            linearLayoutOfCitiesFragment.addView(textViewFromCitiesFragment);
            int finalI = i;
            textViewFromCitiesFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showCoatOfArms(finalI);
                }
            });
        }
    }

    private void showCoatOfArms(int index) {

        currentCity = new City(index,

                (getResources().getStringArray(R.array.cities_names)[index]));
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


