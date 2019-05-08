package com.example.pruebacs.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.example.pruebacs.R;
import com.example.pruebacs.fragmentsAndAdapters.BreedRandomFragment;
import com.example.pruebacs.fragmentsAndAdapters.MainActivityFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.boton_list)
    Button boton_list;
    @BindView(R.id.boton_random)
    Button boton_random;
    @BindView(R.id.boton_incendio)
    Button boton_incendio;
    @BindView(R.id.boton_exit)
    Button boton_exit;

    @BindView(R.id.tableLayout)
    public TableLayout tableLayout;
    @BindView(R.id.fragmentLayout)
    public LinearLayout fragmentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragmentLayout.setVisibility(View.GONE);
        tableLayout.setVisibility(View.VISIBLE);
        boton_random.setOnClickListener(this);
        boton_incendio.setOnClickListener(this);
        boton_exit.setOnClickListener(this);
        boton_list.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.boton_list:
                fragmentLayout.setVisibility(View.VISIBLE);
                tableLayout.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.BreedContainer,
                        MainActivityFragment.newInstance()
                ).commit();
                break;
            case R.id.boton_random:
                fragmentLayout.setVisibility(View.VISIBLE);
                tableLayout.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.BreedContainer,
                        BreedRandomFragment.newInstance()
                ).commit();
                break;
            case R.id.boton_incendio:
                break;
            case R.id.boton_exit:
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                break;
        }
    }

    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        this.getSupportActionBar().setTitle("Prueba Cs");
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            fragmentLayout.setVisibility(View.GONE);
            tableLayout.setVisibility(View.VISIBLE);
            //additional code
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }
}
