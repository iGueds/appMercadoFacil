package com.example.appmercadofacil

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object CarrinhoService {

    val host = "http://iguedes.pythonanywhere.com"
    val TAG = "WS_MF"

    fun getCarrinho (context: Context): List<Carrinho> {
        val url = "$host/cart"
        val json = URL(url).readText()

        Log.d(TAG, json)

        return parserJson<List<Carrinho>>(json)

    }
    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson<T>(json, type)
    }

}