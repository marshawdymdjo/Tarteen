package com.generationgirl.kantinseller

import android.app.Application
import com.google.firebase.FirebaseApp

/**
 * @author by milhamj on 2019-10-16.
 */
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initFirebase()
    }

    private fun initFirebase() {
        FirebaseApp.initializeApp(this)
    }
}