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

        val bakso = findViewById<View>(R.id.bakso)
        val tante = findViewById<View>(R.id.tante)
        val cililis = findViewById<View>(R.id.cililis)

        setKantinDescription(bakso,"Bakso Kuah", "Bakso kuah terenak se-TarQ 1 (karena emang cuma satu hehe)")
        setKantinDescription(tante,"Tante Geprek", "Pilihan terbaik kalo lagi pengen makanan rumahan kaya masakan emak")
        setKantinDescription(cililis,"Ci Lilis", "Makanan enak buat kalian semua yang lagi banyak duid")
        bakso.setOnClickListener {
            val intent = Intent(this, BaksoKantinActivity::class.java)
            startActivity(intent)
        }

        tante.setOnClickListener {
            val intent = Intent(this, TanteKantinActivity::class.java)
            startActivity(intent)

        }

        cililis.setOnClickListener {
            val intent = Intent(this, CililisKantinActivity::class.java)
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
        if (item.itemId == R.id. id_transaction){
            val intent=Intent(this, PesananActivity::class.java)
            startActivity(intent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
