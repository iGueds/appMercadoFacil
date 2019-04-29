package com.example.appmercadofacil

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class TelaInicial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        mercados_abertos.setOnClickListener{
            Toast.makeText(this, "Carregando...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ButtonsActivity::class.java)
            val param = Bundle()
            param.putInt("activity",1)
            intent.putExtras(param)
            startActivity(intent)
        }
        melhores_precos.setOnClickListener{
            Toast.makeText(this, "Carregando...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ButtonsActivity::class.java)
            val param = Bundle()
            param.putInt("activity",2)
            intent.putExtras(param)
            startActivity(intent)
        }
        comparar_precos.setOnClickListener{
            Toast.makeText(this, "Carregando...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ButtonsActivity::class.java)
            val param = Bundle()
            param.putInt("activity",3)
            intent.putExtras(param)
            startActivity(intent)
        }



        //Toolbar AC 05
        //var toolbar = findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show()
        }
        if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Atualizar", Toast.LENGTH_SHORT).show()
            load.visibility = View.VISIBLE
            Handler().postDelayed({load.visibility = View.GONE}, 10000)
            }
        if (id == R.id.action_config) {
            val intent = Intent(this,ConfigActivity::class.java)
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
            startActivity(intent)

        }
        if (id == R.id.action_add) {
            val intent = Intent(this,AdicionarActivity::class.java)
            Toast.makeText(this, "Adicionar", Toast.LENGTH_SHORT).show()
            startActivity(intent)

        }
        if (id == R.id.action_sair) {
            Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
