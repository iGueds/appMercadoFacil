package com.example.appmercadofacil

class Carrinho {

    var id:Long = 0
    var produto = ""
    var preco = ""
    var mercado = ""
    var imagem = ""

    override fun toString(): String {
        return "Carrinho(produto='$produto')"
    }
}