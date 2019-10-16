package com.generationgirl.kantin

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class Kantin2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu);
        setTitle("Tante Geprek")

        supportActionBar?. setDisplayHomeAsUpEnabled(true)
        supportActionBar?. setDisplayShowHomeEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if (item.itemId == android.R.id.home) {
           this.finish()
       }
        return super.onOptionsItemSelected(item)
    }
}