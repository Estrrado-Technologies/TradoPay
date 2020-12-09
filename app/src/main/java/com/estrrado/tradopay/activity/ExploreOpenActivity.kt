package com.estrrado.tradopay.ui.modules.explore

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.estrrado.tradopay.helpers.ActivityUtils

import com.example.tradopay.R

class ExploreOpenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore_open)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        ActivityUtils.set_back_button(this@ExploreOpenActivity, true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        //Toast.makeText(ExploreOpenActivity.this,"getIntent_getComponent="+getIntent().,Toast.LENGTH_LONG).show();
    }
}