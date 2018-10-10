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

    @BindView(R.id.priorityBar) View priorityBar;
    @BindView(R.id.requestType)
    TextView requestType;
    @BindView(R.id.request_number) TextView requestNumber;
    @BindView(R.id.requestDate) TextView requestDate;
    @BindView(R.id.client_name) TextView clientName;
    @BindView(R.id.row1) TextView equipmentPhi;
    @BindView(R.id.row2) TextView equipmentDescription;
    @BindView(R.id.equipment_container)
    LinearLayout equipmentContainer;
    @BindView(R.id.client_container) LinearLayout clientContainer;

    ViewHolder(View view) {
        super(view);
        this.view = view;
        ButterKnife.bind(this, view);
    }
}
