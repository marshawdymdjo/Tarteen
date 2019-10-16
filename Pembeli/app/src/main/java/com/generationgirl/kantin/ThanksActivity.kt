package com.generationgirl.kantin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ThanksActivity : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R. layout. activity_thanks)
        val btnPesanan= findViewById<Button>(R.id. btn_pesanan)
        btnPesanan. setOnClickListener {
            val intent= Intent(this, PesananActivity::class.java)
            startActivity(intent)
        }
    }
}
