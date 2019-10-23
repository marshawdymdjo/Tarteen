package com.generationgirl.kantin

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.generationgirl.kantin.model.Pesanan
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SharedPreferences(val context: Context) {

    fun simpanPesanan(pesanan: MutableList<Pesanan>) {
        val editor = context.getSharedPreferences("Tarteen", MODE_PRIVATE).edit()
        val gson = Gson()
        editor.putString("pesanan", gson.toJson(pesanan))
        editor.apply()
    }

    fun simpanPesanan(pesanan: Pesanan) {
        val arrayPesanan = getPesanan()
        arrayPesanan.add(pesanan)
        simpanPesanan(arrayPesanan)
    }

    fun getPesanan(): MutableList<Pesanan> {
        val prefs: SharedPreferences = context.getSharedPreferences("Tarteen", MODE_PRIVATE)
        val strDaftarPesanan = prefs.getString("pesanan", "")

        if (!strDaftarPesanan.isNullOrEmpty()) {
            val gson = Gson()
            val itemType = object : TypeToken<MutableList<Pesanan>>() {}.type
            return gson.fromJson<MutableList<Pesanan>>(strDaftarPesanan,
                itemType)

        }
        return arrayListOf()
    }
}