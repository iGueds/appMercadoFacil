package com.example.appmercadofacil

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.GsonBuilder

@Entity(tableName = "produto")
class Produto{

    @PrimaryKey
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