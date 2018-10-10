package com.example.pruebacs.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.pruebacs.R;
import com.example.pruebacs.fragmentsAndAdapters.BreedFragment;
import com.example.pruebacs.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BreedActivity extends AppCompatActivity {
    private static final String BREED_NAME = "breedName";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static Intent get(Context context, String breedName){
        Intent intent = new Intent(context, BreedActivity.class);
        intent.putExtra(BREED_NAME, breedName);
        return intent;
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_breed);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String breed = getIntent().getStringExtra(BREED_NAME);


        if(savedInstanceState == null && breed != null){
            Fragment fragment = getFragment(breed);

            if(fragment != null)
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.breed_content, fragment).commit();
        }
    }

    @Override public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private @Nullable
    Fragment getFragment(@NonNull String breed){
        return BreedFragment.newInstance(breed);

    }
}
