package com.example.appmercadofacil

import android.content.Context

object CarrinhoService {

    fun getCarrinho (context: Context): List<Carrinho> {
        val carrinho = mutableListOf<Carrinho>()

        for (i in 1..10) {
            val d = Carrinho()
            d.produto = "Produto $i"
            d.preco = "R$ 20,00 $i"
            d.mercado = "Mercado $i"
            d.imagem = "https://www.supermarketnews.com/sites/supermarketnews.com/files/styles/article_featured_standard/public/Luckys_Market_produce_department.jpg?itok=aVnTth_a"
            carrinho.add(d)
        }

        return carrinho
    }

}