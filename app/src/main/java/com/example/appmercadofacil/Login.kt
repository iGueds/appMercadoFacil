package com.example.appmercadofacil

import com.google.gson.Gson
import com.google.gson.GsonBuilder

class Login{
    var user = ""
    var password = ""

    override fun toString(): String {
        return "Login(user='$user')"
    }
    fun toJson():String{
        return GsonBuilder().create().toJson(this)
    }

}
