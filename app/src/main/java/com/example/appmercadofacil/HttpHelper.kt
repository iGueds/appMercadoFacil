package com.example.appmercadofacil

import android.util.Log
import okhttp3.*
import okhttp3.Response
import java.io.IOException

object HttpHelper {

    private val TAG = "HTTP_MF"
    private val LOG_ON = true
    val JSON = MediaType.parse("application/json; charset=utf-8")

    var client = OkHttpClient()

    fun get(url:String): String {
        Log.d(TAG, "HttpHelper.get: $url")
        val request = Request.Builder().url(url).get().build()
        return getJson(request)
    }

    fun post(url: String, json: String): String {
        Log.d(TAG, "HttpHelper.post: $url > $json")
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).post(body).build()

        return getJson(request)
    }

    fun delete(url: String): String {
        Log.d(TAG, "HttpHelper.delete: $url")
        val request = Request.Builder().url(url).delete().build()
        return getJson(request)
    }


    private fun getJson(request: Request?): String {
        val response = client.newCall(request).execute()
        val body = response.body()
        if (body != null) {
            val json = body.string()
            Log.d(TAG, "  << : $json")
            return json
        }
        throw IOException("Erro na requisição")
    }
}