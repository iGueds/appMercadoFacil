package com.example.appmercadofacil

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class AdicionarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val actionBar = supportActionBar
        actionBar!!.title = "Adicionar"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}
