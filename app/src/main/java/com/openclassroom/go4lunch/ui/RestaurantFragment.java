package com.openclassroom.go4lunch.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassroom.go4lunch.R;
import com.openclassroom.go4lunch.models.DetailsPlaces;
import com.openclassroom.go4lunch.models.Example;

import java.util.ArrayList;

/**
 * Created by de Meeûs Augustin on 2020-01-20
 **/
public class RestaurantFragment extends Fragment {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;
    private Example nearbyPlaces;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<DetailsPlaces> detailsPlaces;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.restaurants_fragment, container, false);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = rootView.findViewById(R.id.rv_restaurants);
        progressBar = rootView.findViewById(R.id.pr_restaurants);


        nearbyPlaces = getArguments().getParcelable("NearbyPlaces");
        detailsPlaces = getArguments().getParcelableArrayList("DetailsPlaces");

        progressBar.setVisibility(View.GONE);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyRestaurantAdapter(nearbyPlaces);
        recyclerView.setAdapter(mAdapter);


        return rootView;

    }


}