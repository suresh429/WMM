package com.example.wmm.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.wmm.R;
import com.example.wmm.activities.MainActivity;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckMeasurementFragment extends Fragment {

    View rootView;
    public CheckMeasurementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check, container, false);

        return  view;
    }


}
