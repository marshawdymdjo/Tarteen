package com.generationgirl.kantin

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThanksActivity : AppCompatActivity () {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thanks)
        title = "Terima Kasih"

        val btnPesanan = findViewById<Button>(R.id.btn_pesanan)
        btnPesanan.setOnClickListener {
            val intent = Intent(this, PesananActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        val kode = intent.getStringExtra("kode")

        val kodeMakanan = findViewById<TextView>(R.id.kode_makanan)
        kodeMakanan.text = kode

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
