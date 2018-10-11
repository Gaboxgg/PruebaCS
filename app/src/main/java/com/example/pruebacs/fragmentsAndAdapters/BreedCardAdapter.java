package com.example.pruebacs.fragmentsAndAdapters;

import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pruebacs.R;
import com.example.pruebacs.interfaces.BreedCardViewClick;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BreedCardAdapter extends RecyclerView.Adapter<ViewHolder> {

    private String [] breedList;
    private final BreedCardViewClick breedCardViewClick;

    public BreedCardAdapter(@NonNull String[] breedList,@Nullable BreedCardViewClick breedCardViewClick) {
        this.breedList = breedList;
        this.breedCardViewClick = breedCardViewClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.breed_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String breed = breedList[position];


        holder.requestCode.setText(String.valueOf(position));

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        holder.requestDate.setText(format1.format(cal.getTime()));
        holder.breedName.setText(breedList[position]);


        if(breedCardViewClick != null)
            holder.view.setOnClickListener(v -> {
                breedCardViewClick.OnBreedCardViewClick(breed);
            });

    }

    @Override
    public int getItemCount() {
        return breedList.length;
    }
}
