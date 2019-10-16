package com.generationgirl.kantin

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class PesananActivity :AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Daftar Pesanan"

        setContentView(R.layout.activity_pesanan)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
}