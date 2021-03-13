package com.example.navigationsample.ui

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import androidx.core.net.toUri
import androidx.fragment.app.Fragment

const val NOTIFICATION_ID = 42
const val NOTIFICATION_CHANNEL_ID = "poop_channel_id"
const val NOTIFICATION_CHANNEL_NAME = "poop_channel_name"


fun Application.createNotificationChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        )

        val notificationManager = getSystemService<NotificationManager>()
        notificationManager?.createNotificationChannel(channel)
    }
}

fun Fragment.pushDeeplinkNotification() = requireContext().pushDeeplinkNotification()

fun Context.pushDeeplinkNotification() {
    val notificationManager = getSystemService<NotificationManager>()
    val pendingIntent = createDeeplinkPendingIntent()
    val notification = createNotification(pendingIntent)

    notificationManager?.notify(NOTIFICATION_ID, notification)
}

private fun Context.createDeeplinkPendingIntent(): PendingIntent {
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = "app.poop://c3/intent".toUri()
    }

    return PendingIntent.getActivity(this, 0, intent, 0)
}

private fun Context.createNotification(pendingIntent: PendingIntent): Notification =
    NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("Deeplink notification")
        .setContentIntent(pendingIntent)
        .build()
