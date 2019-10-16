package com.generationgirl.kantin

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.generationgirl.kantin.model.Makanan

class BayarActivity : AppCompatActivity () {

    private var daftarPesanan: ArrayList<Makanan>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R. layout. activity_bayar)
        title = "Pesanan"

        supportActionBar?. setDisplayHomeAsUpEnabled(true)
        supportActionBar?. setDisplayShowHomeEnabled(true)

        daftarPesanan = intent.getParcelableArrayListExtra("daftarpesanan")

        val btnBayar = findViewById<Button>(R.id.btn_bayar)
        btnBayar. setOnClickListener {
            val intent = Intent(this, ThanksActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
}