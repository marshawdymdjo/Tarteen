package com.generationgirl.kantinseller

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlin.random.Random

class MessagingService : FirebaseMessagingService() {

    companion object {
        val TAG = MessagingService::class.java.simpleName
        const val CHANNEL_ID_DEFAULT = "channel_default"
        const val CHANNEL_NAME_DEFAULT = "Tarteen"
        const val GROUP_MAIN = "group_main"
    }

    private val notificationManager by lazy {
        this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    private val notificationPreference by lazy {
        NotificationPreference(this)
    }

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        handleNotification(remoteMessage)
    }

    private fun handleNotification(remoteMessage: RemoteMessage) {
        val title = remoteMessage.data["title"] ?: ""
        val body = remoteMessage.data["body"] ?: ""
        showNotification(title, body)
        saveNotificationData(title, body)
    }

    private fun saveNotificationData(title: String, body: String) {
        notificationPreference.saveData(title, body)
    }

    private fun showNotification(title: String, body: String) {
        createNotificationChannel()

        val notifId = Random.nextInt()
        val notification: Notification = createNotification(title, body)
        notificationManager.notify(notifId, notification)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel = NotificationChannel(CHANNEL_ID_DEFAULT, CHANNEL_NAME_DEFAULT, importance)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.BLUE
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

    private fun createNotification(title: String, body: String): Notification {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID_DEFAULT)
        builder.setContentTitle(title)
        builder.setContentText(body)
        builder.setContentIntent(getPendingIntent())
        builder.setStyle(NotificationCompat.BigTextStyle().bigText(body))
        builder.setGroup(GROUP_MAIN)
        builder.setAutoCancel(true)
        return builder.build()
    }

    private fun getPendingIntent(): PendingIntent {
        val intent = Intent(this, MainActivity::class.java)
        return PendingIntent.getActivity(this, 0, intent, 0)
    }
}