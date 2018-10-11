package com.example.pruebacs.fragmentsAndAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pruebacs.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewHolder extends RecyclerView.ViewHolder  {
    public final View view;

    @BindView(R.id.request_code) TextView requestCode;
    @BindView(R.id.requestDate) TextView requestDate;
    @BindView(R.id.breedName) TextView breedName;

    ViewHolder(View view) {
        super(view);
        this.view = view;
        ButterKnife.bind(this, view);
    }
}
