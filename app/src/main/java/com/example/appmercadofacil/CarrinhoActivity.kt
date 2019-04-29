package com.example.appmercadofacil

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class CarrinhoActivity : AppCompatActivity() {

    private val context: Context get() = this
    private var carrinho = listOf<Carrinho>()
    var recyclerCarrinho: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)
        recyclerCarrinho = findViewById<RecyclerView>(R.id.recyclerCarrinho)
        recyclerCarrinho?.layoutManager = LinearLayoutManager(context)
        recyclerCarrinho?.itemAnimator = DefaultItemAnimator()
        recyclerCarrinho?.setHasFixedSize(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val actionBar = supportActionBar
        actionBar!!.title = "Carrinho"
    }
    override fun onResume() {
        super.onResume()
        taskCarrinho()
    }
    fun taskCarrinho() {
        carrinho = CarrinhoService.getCarrinho(context)
        recyclerCarrinho?.adapter = CarrinhoAdapter(carrinho) {onClickCarrinho(it)}
    }

    fun onClickCarrinho(carrinho: Carrinho) {
        Toast.makeText(context, "Clicou produto ${carrinho.produto}", Toast.LENGTH_SHORT).show()
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}
