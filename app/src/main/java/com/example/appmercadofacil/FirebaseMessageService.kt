package com.example.appmercadofacil

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseMessageService: FirebaseMessagingService() {

    val TAG = "MFFirebase"

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d(TAG, "NOVO TOKEN $token")

        Prefs.setString("FB_TOKEN", token!!)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {

        if (remoteMessage?.notification != null){
            val title = remoteMessage?.notification?.title
            val body = remoteMessage?.notification?.body
            Log.d(TAG, "Título: $title")
            Log.d(TAG, "Corpo: $body")
            showNotification(remoteMessage!!)
        }
    }

    private fun showNotification(remoteMessage: RemoteMessage) {
        val intent = Intent(this, ProdutoActivity::class.java)
        val title = remoteMessage?.notification?.title
        val body = remoteMessage?.notification?.body
        NotificationUtil.create(1, intent, title!!, body!!)
    }
}