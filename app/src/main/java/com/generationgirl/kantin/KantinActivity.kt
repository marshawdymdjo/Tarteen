package com.generationgirl.kantin

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class KantinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu);
        setTitle("Bakso Kuah")

        supportActionBar?. setDisplayHomeAsUpEnabled(true)
        supportActionBar?. setDisplayShowHomeEnabled(true)

        val viewMenu1= findViewById<View>(R.id.menu_1)
        val viewMenu2= findViewById<View>(R.id.menu_2)
        val viewMenu3= findViewById<View>(R.id.menu_3)

        functionClickTambah(viewMenu1)
        functionClickTambah(viewMenu2)
        functionClickTambah(viewMenu3)
    }

    fun functionClickTambah (view: View) {
        val btnTambah= view.findViewById<Button>(R.id.btn_tambah)
        btnTambah.setOnClickListener {
        val intent = Intent(this, BayarActivity::class.java)
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