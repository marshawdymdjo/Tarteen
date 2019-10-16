package com.generationgirl.kantin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kantin1 = findViewById<View>(R.id.kantin1)
        val kantin2 = findViewById<View>(R.id.kantin2)
        val kantin3 = findViewById<View>(R.id.kantin3)

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
