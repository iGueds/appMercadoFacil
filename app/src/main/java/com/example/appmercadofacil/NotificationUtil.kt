package com.example.appmercadofacil

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat

object NotificationUtil {

    internal val CHANNEL_ID = "1"

    fun createChannel(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            val contexto = MFApplication.getInstance().applicationContext
            val manager = contexto.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val appName =  contexto.getString(R.string.app_name)
            val canal = NotificationChannel(CHANNEL_ID, appName, NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(canal)
        }
    }

    fun create(id: Int, intent: Intent, Tittle: String, Text: String){
        createChannel()
        val context = MFApplication.getInstance().applicationContext
        val pendence = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentIntent(pendence)
            .setContentTitle(Tittle)
            .setContentText(Text)
            .setSmallIcon(R.mipmap.mercado_facil_icon_round)
            .setAutoCancel(true)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

        with(NotificationManagerCompat.from(MFApplication.getInstance())){
            val constructor = builder.build()
            notify(id, constructor)
        }
    }
}