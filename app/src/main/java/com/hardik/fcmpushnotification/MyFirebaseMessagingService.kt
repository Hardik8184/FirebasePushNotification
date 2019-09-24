package com.hardik.fcmpushnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

  private val tag = "FirebaseMessagingService"

  override fun onNewToken(token: String) {
    super.onNewToken(token)
    println("$tag token --> $token")
  }

  override fun onMessageReceived(remoteMessage: RemoteMessage) {

    try {

      if (remoteMessage.notification != null) {
        showNotification(remoteMessage.notification?.title, remoteMessage.notification?.body)
      } else {
        showNotification(remoteMessage.data["title"], remoteMessage.data["message"])
      }

    } catch (e: Exception) {
      println("$tag error -->${e.localizedMessage}")
    }
  }

  private fun showNotification(
    title: String?,
    body: String?
  ) {
    val intent = Intent()
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    val pendingIntent = PendingIntent.getActivity(
        this, 0, intent,
        PendingIntent.FLAG_ONE_SHOT
    )

    val channelId = getString(R.string.channel_id)
    val channelName = getString(R.string.channel_name)
    val notificationManager =
      getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    // Since android Oreo notification channel is needed.
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      setupNotificationChannels(channelId, channelName, notificationManager)
    }

    val soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

    val notificationBuilder = NotificationCompat.Builder(this, channelId)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setContentTitle(title)
        .setContentText(body)
        .setAutoCancel(true)
        .setSound(soundUri)
        .setContentIntent(pendingIntent)

    notificationManager.notify(0, notificationBuilder.build())
  }

  @RequiresApi(api = Build.VERSION_CODES.O)
  private fun setupNotificationChannels(
    channelId: String,
    channelName: String,
    notificationManager: NotificationManager
  ) {

    val channel =
      NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_LOW)
    channel.enableLights(true)
    channel.lightColor = Color.GREEN
    channel.enableVibration(true)
    notificationManager.createNotificationChannel(channel)
  }
}