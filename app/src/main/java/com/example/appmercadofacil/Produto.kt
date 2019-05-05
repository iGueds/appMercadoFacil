package com.example.appmercadofacil

import com.google.gson.GsonBuilder

class Produto{

    var id:Long = 0
    var name = ""
    var brand = ""
    var image = ""
    var price = ""

    override fun toString(): String {
        return "Produto(produto='$name')"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}