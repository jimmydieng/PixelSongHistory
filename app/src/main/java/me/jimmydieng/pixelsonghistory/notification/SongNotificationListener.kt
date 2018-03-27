package me.jimmydieng.pixelsonghistory.notification

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.text.TextUtils


class SongNotificationListener : NotificationListenerService() {

    private val GOOGLE_MUSIC_SERVICE_PKG_NAME = "com.google.intelligence.sense"
    private val GOOGLE_MUSIC_SERVICE_CHANNEL_NAME = "com.google.intelligence.sense.ambientmusic.MusicNotificationChannel"

    override fun onListenerConnected() {
        process(*activeNotifications)
    }

    override fun onNotificationPosted(statusBarNotification: StatusBarNotification) {
        process(statusBarNotification)
    }

    private fun process(vararg statusBarNotifications: StatusBarNotification) {
        for (statusBarNotification in statusBarNotifications) {
            if (statusBarNotification.packageName == GOOGLE_MUSIC_SERVICE_PKG_NAME) {
                val notification = statusBarNotification.notification
                if (notification.channelId == GOOGLE_MUSIC_SERVICE_CHANNEL_NAME) {
                    val timeMillis = notification.`when`
                    val songText = notification.extras.getString(Notification.EXTRA_TITLE)
                    if (!TextUtils.isEmpty(songText)) {
                        persistSongAsync(timeMillis, songText)
                    }
                }
            }
        }
    }

    private fun persistSongAsync(timeMillis: Long, songText: String) {

    }
}
