package com.generationgirl.kantinseller

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import java.security.AccessControlContext
import kotlin.random.Random

/**
 * @author by milhamj on 2019-10-16.
 */
class NotificationPreference(context: Context) {

    companion object {
        private const val KEY = "notification_preference"
    }

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
    private val gson = Gson()

    fun getAllData(): List<NotificationData> {
        val list = mutableListOf<NotificationData>()
        val keys = sharedPreferences.all
        for (entry in keys.entries) {
            val data: NotificationData = gson.fromJson(entry.value.toString(), NotificationData::class.java)
            list.add(data)
        }
        return list
    }

    fun saveData(title: String, subtitle: String) {
        val data = NotificationData(title, subtitle, System.currentTimeMillis())
        sharedPreferences.edit()
            .putString(Random.nextInt().toString(), gson.toJson(data))
            .apply()
    }
}