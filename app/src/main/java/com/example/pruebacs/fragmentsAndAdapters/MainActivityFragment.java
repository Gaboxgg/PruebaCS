package com.example.pruebacs.fragmentsAndAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pruebacs.R;
import com.example.pruebacs.activities.BreedActivity;
import com.example.pruebacs.database.BreedUtils;
import com.example.pruebacs.interfaces.BreedCardViewClick;
import com.example.pruebacs.utils.GeneralUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements BreedCardViewClick{

    private BreedCardAdapter breedCardAdapter;

    private int position;
//    private TabCallback tabCallback;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String [] breedList;

//    private int lastSize;
//
    private final static String BREED_NAME = "breedName";
    private final static String POSITION_KEY = "position";

    public MainActivityFragment() { }

    public static MainActivityFragment newInstance() {
        MainActivityFragment fragment = new MainActivityFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() == null){

            BreedUtils.getBreedList(BreedList -> {
                String [] breedList = GeneralUtils.decodeResponse(BreedList);

                breedCardAdapter = new BreedCardAdapter(breedList,
                        breedCard -> startActivity(BreedActivity.get(getActivity(), breedList[0])));

                RecyclerView recyclerView = swipeRefreshLayout.findViewById(R.id.list);
                recyclerView.removeAllViews();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(breedCardAdapter);
                breedCardAdapter.notifyDataSetChanged();



            });
            }

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_list_content, container, false);

        Context context = view.getContext();
        swipeRefreshLayout = (SwipeRefreshLayout) view;
        RecyclerView recyclerView = swipeRefreshLayout.findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(breedCardAdapter);

        return view;
    }

    @SuppressWarnings("WeakerAccess")
    public static Bundle createTabArguments(String [] breedList, int position){
        Bundle bundle = new Bundle();

        bundle.putString(BREED_NAME, breedList[position]);
        bundle.putInt(POSITION_KEY, position);
        return bundle;
    }

    public void updateItems(@Nullable String [] breedList){
        if(breedList == null)
            return;

        this.breedList=breedList;

        if(breedCardAdapter != null)
            breedCardAdapter.notifyDataSetChanged();

    }

    @Override public void OnBreedCardViewClick (String breedName) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(
                R.id.BreedContainer,
                BreedFragment.newInstance(breedName)
        ).commit();
    }

}
