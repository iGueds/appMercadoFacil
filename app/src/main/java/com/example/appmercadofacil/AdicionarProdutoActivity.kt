package com.example.appmercadofacil

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_adicionar_produto.*

class AdicionarProdutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_produto)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("Novo Produto")

        salvarProduto.setOnClickListener {
            val produto = Produto()
            produto.name = nameProduto.text.toString()
            produto.brand = brandProduto.text.toString()
            produto.image = imageProduto.text.toString()
            produto.price = priceProduto.text.toString()

            taskAtualizar(produto)
        }
    }

    private fun taskAtualizar(produto: Produto) {
        Thread {
            ProdutoService.postProduto(produto)
            runOnUiThread {
                val intent = Intent(this, ProdutoActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}