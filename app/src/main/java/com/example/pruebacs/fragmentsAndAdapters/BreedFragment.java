package com.example.pruebacs.fragmentsAndAdapters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pruebacs.R;
import com.example.pruebacs.database.BreedUtils;
import com.example.pruebacs.utils.GeneralUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BreedFragment extends Fragment {
    private static final String BREED_NAME = "breedName";
    private static final boolean hasOptionsMenu = true;

    private AppCompatActivity activity;
    private String breedName;

    @BindView(R.id.list) ListView listView;

    public BreedFragment() { }

    public static BreedFragment newInstance(String breedName) {
        BreedFragment fragment = new BreedFragment();
        Bundle args = new Bundle();
        args.putString(BREED_NAME, breedName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            breedName = getArguments().getString(BREED_NAME);

        BreedUtils.getBreedPics(breedName,BreedList -> {

            if ( BreedList!=null ) {

                String[] decodedBreedPics = GeneralUtils.decodeResponse(BreedList);
                List<String> listPics = GeneralUtils.arrayToList(decodedBreedPics);
                BreedPicsAdapter adapter = new BreedPicsAdapter(getActivity().getApplicationContext(),
                        R.layout.breed_list_pics, listPics

                );
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

        });



        setHasOptionsMenu(hasOptionsMenu);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_breed_photos, container, false);
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        activity = (AppCompatActivity) getActivity();

        if (activity != null && breedName != null) {
            String title = "Raza : "+breedName;

            if(activity.getSupportActionBar() != null)
                activity.getSupportActionBar().setTitle(title);


        }
    }

    @Override public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
