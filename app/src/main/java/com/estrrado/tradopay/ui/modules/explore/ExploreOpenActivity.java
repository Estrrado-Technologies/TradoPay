package com.estrrado.tradopay.ui.modules.explore;

import android.os.Bundle;

import com.estrrado.tradopay.ui.modules.MainActivity;
import com.estrrado.tradopay.ui.utilities.ActivityUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.tradopay.R;

public class ExploreOpenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_open);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActivityUtils.set_back_button(ExploreOpenActivity.this,true);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Toast.makeText(ExploreOpenActivity.this,"getIntent_getComponent="+getIntent().,Toast.LENGTH_LONG).show();
    }
}