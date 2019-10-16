package com.generationgirl.kantin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class BayarActivity : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R. layout. activity_bayar)

        val btnBayar = findViewById<Button>(R.id.btn_bayar)
        btnBayar. setOnClickListener {
            val intent = Intent(this, ThanksActivity::class.java)
            startActivity(intent)
        }
    }
}
