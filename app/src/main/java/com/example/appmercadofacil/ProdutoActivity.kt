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

class ProdutoActivity : AppCompatActivity() {

    private val context: Context get() = this
    private var produto = listOf<Produto>()
    var recyclerProduto: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)
        recyclerProduto = findViewById<RecyclerView>(R.id.recyclerProduto)
        recyclerProduto?.layoutManager = LinearLayoutManager(context)
        recyclerProduto?.itemAnimator = DefaultItemAnimator()
        recyclerProduto?.setHasFixedSize(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val actionBar = supportActionBar
        actionBar!!.title = "Produtos"
    }
    override fun onResume() {
        super.onResume()
        taskCarrinho()
    }
    fun taskCarrinho() {
        Thread {
            produto = ProdutoService.getProduto(context)
            runOnUiThread {
                recyclerProduto?.adapter = ProdutoAdapter(produto) { onClickProduto(it) }
            }
        }.start()
    }

    fun onClickProduto(produto: Produto) {
        Toast.makeText(context, "Clicou ${produto.name}", Toast.LENGTH_SHORT).show()
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}