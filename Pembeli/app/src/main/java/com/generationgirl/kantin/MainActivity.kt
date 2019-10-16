package com.generationgirl.kantin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kantin1 = findViewById<View>(R.id.kantin1)
        val kantin2 = findViewById<View>(R.id.kantin2)
        val kantin3 = findViewById<View>(R.id.kantin3)

        setKantinDescription(kantin1,"Bakso Kuah", "Bakso kuah terenak se-TarQ 1 (karena emang cuma satu hehe)")
        setKantinDescription(kantin2,"Tante Geprek", "Pilihan terbaik kalo lagi pengen makanan rumahan kaya masakan emak")
        setKantinDescription(kantin3,"Ci Lilis", "Makanan enak buat kalian semua yang lagi banyak duid")
        kantin1.setOnClickListener {
            val intent = Intent(this, KantinActivity::class.java)
            startActivity(intent)

        }

        kantin2.setOnClickListener {
            val intent = Intent(this, Kantin2Activity::class.java)
            startActivity(intent)

        }

        kantin3.setOnClickListener {
            val intent = Intent(this, Kantin3Activity::class.java)
            startActivity(intent)

        }
    }

    fun setKantinDescription(view: View, namaKantin: String, descKantin: String) {
        val titleKantin = view. findViewById<TextView>(R.id.nama_kantin)
        val deskripsiKantin = view. findViewById<TextView>(R.id.deskripsi_kantin)

        titleKantin.text = namaKantin
        deskripsiKantin.text = descKantin
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_transaction, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id. id_transaction){
            val intent=Intent(this, PesananActivity::class.java)
            startActivity(intent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
