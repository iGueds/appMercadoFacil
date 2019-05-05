package com.example.appmercadofacil

import com.google.gson.Gson
import com.google.gson.GsonBuilder

class Login{
    var email = ""
    var password = ""

    override fun toString(): String {
        return "Login(email='$email')"
    }
    fun toJson():String{
        return GsonBuilder().create().toJson(this)
    }

}
