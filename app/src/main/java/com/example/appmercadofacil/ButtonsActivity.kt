package com.example.appmercadofacil

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class ButtonsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val args = intent.extras
        val numero = args?.getInt("activity")
        if (numero == 1){
            val actionBar = supportActionBar
            actionBar!!.title = "Mercados abertos"
        }
        if (numero == 2){
            val actionBar = supportActionBar
            actionBar!!.title = "Melhores preços"
        }
        if (numero == 3){
            val actionBar = supportActionBar
            actionBar!!.title = "Promoções"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}
