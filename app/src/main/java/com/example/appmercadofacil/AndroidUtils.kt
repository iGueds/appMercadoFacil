package com.example.appmercadofacil

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object AndroidUtils {
    fun isInternetAvailable(context: Context): Boolean {
        val conection = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val network = conection.allNetworks
        return network.map{conection.getNetworkInfo(it)}.any{it.state == NetworkInfo.State.CONNECTED}
    }
}