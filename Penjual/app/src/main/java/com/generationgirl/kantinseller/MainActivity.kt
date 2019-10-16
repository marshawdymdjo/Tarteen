package com.generationgirl.kantinseller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var listRv: RecyclerView
    private lateinit var adapter: NotificationAdapter
    private lateinit var notificationPreference: NotificationPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationPreference = NotificationPreference(this)
        adapter = NotificationAdapter()
        adapter.setList(notificationPreference.getAllData())

        listRv = findViewById(R.id.listRv)
        listRv.adapter = adapter
    }
}
