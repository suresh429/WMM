package com.example.wmm.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.wmm.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    View rootView;
    @BindView(R.id.txtworks)
    TextView txtworks;
    @BindView(R.id.txtWorkCount)
    TextView txtWorkCount;
    @BindView(R.id.txtInProgress)
    TextView txtInProgress;
    @BindView(R.id.txtProgreeCount)
    TextView txtProgreeCount;
    @BindView(R.id.txtComplete)
    TextView txtComplete;
    @BindView(R.id.txtCompletedCount)
    TextView txtCompletedCount;
    @BindView(R.id.txtPercentage)
    TextView txtPercentage;
    @BindView(R.id.circular_progress)
    ProgressBar circularProgress;
    @BindView(R.id.chart)
    BarChart chart;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        circularProgress.setMax(50);
        circularProgress.setProgress(20);
        circularProgress.setProgress(0); // <--
        circularProgress.setMax(20);
        circularProgress.setProgress(20);
        txtPercentage.setText("75%");


        BarDataSet bardataset = new BarDataSet(getData(), "No Of Employee");
        chart.animateY(5000);
        BarData data = new BarData(bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
       // bardataset.setBarBorderWidth(10f);
       // bardataset.setBarBorderColor(Color.parseColor("#FA9611"));
        bardataset.setValueTextColor(Color.WHITE);
        bardataset.setHighLightColor(Color.WHITE);
        chart.setData(data);

        return view;
    }

    private ArrayList getData(){
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry (1, 5));
        entries.add(new BarEntry (3, 7));
        entries.add(new BarEntry (5,3));
        entries.add(new BarEntry (7,4));
        entries.add(new BarEntry (9,1));
        return entries;
    }
}
