package com.example.appmercadofacil

class Carrinho {

    var id:Long = 0
    var name = ""
    var brand = ""
    var image = ""
    var price = ""

    override fun toString(): String {
        return "Carrinho(produto='$name')"
    }
}