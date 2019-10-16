package com.generationgirl.kantin

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.item_menu.*

class KantinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_bakso);
        setTitle("Bakso Kuah")

        supportActionBar?. setDisplayHomeAsUpEnabled(true)
        supportActionBar?. setDisplayShowHomeEnabled(true)

        val viewMenu1= findViewById<View>(R.id.menu_1)
        val viewMenu2= findViewById<View>(R.id.menu_2)
        val viewMenu3= findViewById<View>(R.id.menu_3)
        val viewMenu4= findViewById<View>(R.id.menu_4)
        val viewMenu5= findViewById<View>(R.id.menu_5)

        functionClickTambah(viewMenu1)
        functionClickTambah(viewMenu2)
        functionClickTambah(viewMenu3)
        functionClickTambah(viewMenu4)
        functionClickTambah(viewMenu5)

        setMenuKantin(viewMenu1, "Bihun", "5000");
        setMenuKantin(viewMenu2, "Tahu", "1000");
        setMenuKantin(viewMenu3, "Batagor", "2000");
        setMenuKantin(viewMenu4, "Mi", "5000");
        setMenuKantin(viewMenu5, "Bakso", "2000");
    }

    fun functionClickTambah (view: View) {
        val btnTambah= view.findViewById<Button>(R.id.btn_tambah)
        btnTambah.setOnClickListener {
        val intent = Intent(this, BayarActivity::class.java)
            startActivity(intent)
        }
    }

    fun setMenuKantin(view: View, namaMenu: String, hargaMenu: String) {
    val menu = view. findViewById<TextView>(R.id. nama_menu)
        val harga = view. findViewById<TextView>(R.id.harga_menu)
        menu.text = namaMenu
        harga.text = hargaMenu
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if (item.itemId == android.R.id.home) {
           this.finish()
       }
        return super.onOptionsItemSelected(item)
    }
}