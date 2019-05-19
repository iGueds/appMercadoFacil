package com.example.appmercadofacil

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object LoginService {

    val host = "http://iguedes.pythonanywhere.com"
    val TAG = "WS_MF"


    fun postLogin (Login: Login): Response{
        val json = HttpHelper.post("$host/login", Login.toJson())

        Log.d(TAG, json)

        Prefs.setString("LG_TOKEN", json)

        return parserJson(json)

    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}