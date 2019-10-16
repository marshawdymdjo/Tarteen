package com.generationgirl.kantin

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.generationgirl.kantin.model.Makanan
import kotlinx.android.synthetic.main.item_menu.*

class BaksoKantinActivity : AppCompatActivity() {

    private lateinit var layoutBayar: LinearLayout
    private lateinit var btnBayar: Button
    private lateinit var total: TextView

    private var totalHarga: Int = 0

    private val daftarPesanan: ArrayList<Makanan> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_bakso);
        title = "Bakso Kuah"

        supportActionBar?. setDisplayHomeAsUpEnabled(true)
        supportActionBar?. setDisplayShowHomeEnabled(true)

        layoutBayar = findViewById(R.id.layout_bayar)
        btnBayar = findViewById(R.id.btn_bayar)
        total = findViewById(R.id.total)

        val viewMenu1= findViewById<View>(R.id.menu_1)
        val viewMenu2= findViewById<View>(R.id.menu_2)
        val viewMenu3= findViewById<View>(R.id.menu_3)
        val viewMenu4= findViewById<View>(R.id.menu_4)
        val viewMenu5= findViewById<View>(R.id.menu_5)

        setMenuKantin(viewMenu1, "Bihun", "5000");
        setMenuKantin(viewMenu2, "Tahu", "1000");
        setMenuKantin(viewMenu3, "Batagor", "2000");
        setMenuKantin(viewMenu4, "Mi", "5000");
        setMenuKantin(viewMenu5, "Bakso", "2000");

        btnBayar.setOnClickListener {
            val intent = Intent(this, BayarActivity::class.java)
            intent.putParcelableArrayListExtra("daftarpesanan", daftarPesanan)
            startActivity(intent)
        }
    }

    fun setMenuKantin(view: View, namaMenu: String, hargaMenu: String) {
        val menu = view. findViewById<TextView>(R.id. nama_menu)
        val harga = view. findViewById<TextView>(R.id.harga_menu)
        val btnTambah= view.findViewById<Button>(R.id.btn_tambah)

        menu.text = namaMenu
        harga.text = hargaMenu

        btnTambah.setOnClickListener {
            tambah(namaMenu, hargaMenu)
        }
    }

    fun tambah(namaMakanan: String, harga: String) {
        if (!layoutBayar.isVisible) {
            layoutBayar.visibility = View.VISIBLE
        }

        totalHarga += harga.toInt()

        total.text = "Total: Rp $totalHarga"
        daftarPesanan.add(Makanan(namaMakanan, harga))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if (item.itemId == android.R.id.home) {
           this.finish()
       }
        return super.onOptionsItemSelected(item)
    }
}