package com.generationgirl.kantin

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.generationgirl.kantin.model.Makanan
import com.generationgirl.kantin.model.Pesanan

class BayarActivity : AppCompatActivity () {

    private var daftarPesanan: ArrayList<Makanan> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R. layout. activity_bayar)
        title = "Pesanan"

        supportActionBar?. setDisplayHomeAsUpEnabled(true)
        supportActionBar?. setDisplayShowHomeEnabled(true)

        daftarPesanan = intent.getParcelableArrayListExtra("daftarpesanan")

        var totalHarga = 0

        val layoutDaftarPesanan = findViewById<LinearLayout>(R.id.daftar_pesanan)
        daftarPesanan.forEachIndexed{ index, makanan ->
            generatePesanan(layoutDaftarPesanan, makanan, index+1)
            totalHarga += makanan.harga?.toIntOrNull()?:0
        }

        val total = findViewById<TextView>(R.id.total)
        total.text = "Total Rp $totalHarga"

        val btnBayar = findViewById<Button>(R.id.btn_bayar)
        btnBayar. setOnClickListener {
            // TODO save to shared preferences
            val pesanan = Pesanan()
            pesanan.kode = CodeGenerator().generate()
            pesanan.total = totalHarga.toString()
            pesanan.daftarMakanan = daftarPesanan
            SharedPreferences(this).simpanPesanan(pesanan)

            val intent = Intent(this, ThanksActivity::class.java)
            intent.putExtra("kode", pesanan.kode)
            startActivity(intent)
        }
    }

    private fun generatePesanan(container: ViewGroup, makanan: Makanan, count: Int) {
        val parentView = layoutInflater.inflate(R.layout.item_pesanan, null)
        val namaMakanan = parentView.findViewById<TextView>(R.id.nama_makanan)
        val hargaMakanan = parentView.findViewById<TextView>(R.id.harga_makanan)

        namaMakanan.text = "$count. ${makanan.namaMakanan}"
        hargaMakanan.text = makanan.harga

        container.addView(parentView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
}