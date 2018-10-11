package com.example.pruebacs.fragmentsAndAdapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pruebacs.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BreedPicsAdapter extends ArrayAdapter<String> {

    int resource;
    Context context;

    public BreedPicsAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.resource=resource;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        String url = getItem(position);
        Uri myUri = Uri.parse(url);
        if( convertView == null ) {
            LayoutInflater inflater2 = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater2.inflate(resource, null);
        }
        ImageView pic = convertView.findViewById(R.id.breed_img);
        Picasso.get().load(myUri).into(pic);

        return convertView;

    }
}
