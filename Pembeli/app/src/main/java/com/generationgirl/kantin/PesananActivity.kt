package com.generationgirl.kantin

import android.os.Bundle
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.generationgirl.kantin.model.Makanan
import com.generationgirl.kantin.model.Pesanan

class PesananActivity :AppCompatActivity () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Daftar Pesanan"

        setContentView(R.layout.activity_pesanan)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        val layoutDaftarPesanan = findViewById<LinearLayout>(R.id.daftar_pesanan_parent)

        val daftarPesanan = SharedPreferences(this).getPesanan()
        daftarPesanan.forEach {
            generatePesanan(layoutDaftarPesanan, it)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun generatePesanan(container: ViewGroup, pesanan: Pesanan) {
        val parentView = layoutInflater.inflate(R.layout.item_detail_pesanan, null)
        val total = parentView.findViewById<TextView>(R.id.total)
        val kode = parentView.findViewById<TextView>(R.id.kode_makanan)
        val daftarMakanan = parentView.findViewById<LinearLayout>(R.id.daftar_pesanan)

        total.text = "Total Harga: ${pesanan.total}"
        kode.text = "Kode Pesanan: ${pesanan.kode}"

        pesanan.daftarMakanan?.forEachIndexed{ index, makanan ->
            generateMakanan(daftarMakanan, makanan, index+1)
        }

        container.addView(parentView)
    }

    private fun generateMakanan(container: ViewGroup, makanan: Makanan, count: Int) {
        val parentView = layoutInflater.inflate(R.layout.item_pesanan, null)
        val namaMakanan = parentView.findViewById<TextView>(R.id.nama_makanan)
        val hargaMakanan = parentView.findViewById<TextView>(R.id.harga_makanan)

        namaMakanan.text = "$count. ${makanan.namaMakanan}"
        hargaMakanan.text = makanan.harga

        container.addView(parentView)
    }
}