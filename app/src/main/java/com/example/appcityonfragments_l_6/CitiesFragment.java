package com.example.appcityonfragments_l_6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;


public class CitiesFragment extends Fragment {

    public static CitiesFragment newInstance(){
        return new CitiesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View viewCitiesFragment = inflater.inflate(R.layout.fragment_cities , container, false);
        return viewCitiesFragment;
    }
}


