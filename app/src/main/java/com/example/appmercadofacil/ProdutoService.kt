package com.example.appmercadofacil

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object ProdutoService {

    val host = "http://iguedes.pythonanywhere.com"
    val TAG = "WS_MF"
    val dao = DBManager.getProdutoDAO()

    fun getProduto (context: Context): List<Produto> {
        if (AndroidUtils.isInternetAvailable(context)){
            val url = "$host/product"
            val json = URL(url).readText()
            val produtos:List<Produto> =  parserJson(json)

            for (d in produtos){
                if (dao.getById(d.id) == null)
                    dao.insert(d)
            }

            Log.d(TAG, json)

            return produtos
       } else {
            return dao.findAll()
        }

    }

    fun postProduto(produto: Produto): Response {
        val json = HttpHelper.post("$host/product", produto.toJson())
        return parserJson(json)
    }

    fun deleteProduto(produto: Produto): Response {
        Log.d(TAG, produto.id.toString())
        val url = "$host/product/${produto.id}"
        val json = HttpHelper.delete(url)
        Log.d(TAG, json)
        return parserJson(json)}

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson<T>(json, type)
    }
}