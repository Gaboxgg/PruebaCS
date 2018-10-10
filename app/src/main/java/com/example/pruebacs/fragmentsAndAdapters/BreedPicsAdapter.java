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

import java.util.List;

public class BreedPicsAdapter extends ArrayAdapter<String> {

    int resource;
    String response;
    Context context;

    public BreedPicsAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LinearLayout photosView;
        String url = getItem(position);
        Uri myUri = Uri.parse(url);
        if(convertView==null) {
            photosView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater)getContext().getSystemService(inflater);
            vi.inflate(resource, photosView, true);
        } else {
            photosView = (LinearLayout) convertView;
        }
        ImageView pic = convertView.findViewById(R.id.breed_img);
        pic.setImageURI(myUri);
        return photosView;
    }
}
