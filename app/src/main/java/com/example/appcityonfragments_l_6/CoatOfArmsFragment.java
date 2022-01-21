package com.example.appcityonfragments_l_6;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CoatOfArmsFragment extends Fragment {

    public static final String ARG_CITY = "city";
    private City cityFromCoatOfArmsFragment;


    public static CoatOfArmsFragment newInstance(City cityFromCoatOfArmsFragment) {
        CoatOfArmsFragment fragmentCoatOfArmsFragment = new CoatOfArmsFragment();
        Bundle bundleCoatOfArmsFragment = new Bundle();
        bundleCoatOfArmsFragment.putParcelable(ARG_CITY, cityFromCoatOfArmsFragment);
        fragmentCoatOfArmsFragment.setArguments(bundleCoatOfArmsFragment);
        return fragmentCoatOfArmsFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.cityFromCoatOfArmsFragment = getArguments().getParcelable(ARG_CITY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View coatFragmentView = inflater.inflate(R.layout.fragment_coat_of_arms, container, false);
        ImageView imageFromCoatOfArmsFragment = coatFragmentView.findViewById(R.id.fragment_cities__image_view);
        TypedArray arrayFromCoatOfArmsFragment = getResources().obtainTypedArray(R.array.coat_of_arms_images);
        imageFromCoatOfArmsFragment.setImageResource(arrayFromCoatOfArmsFragment
                .getResourceId(this.cityFromCoatOfArmsFragment.getImageIndex(), -1));

        TextView textFromCoatOfArmsFragment = coatFragmentView.findViewById(R.id.fragment_cities__text_view);
        textFromCoatOfArmsFragment.setText(this.cityFromCoatOfArmsFragment.getName());
        return coatFragmentView;
    }


}
