package com.example.appmercadofacil

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.*
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class PrincipalActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)
        supportActionBar?.hide()


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


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        configMenuLateral()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        //(menu?.findItem(R.id.action_buscar)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

          //  override fun onQueryTextChange(newText: String): Boolean {
         //       return false
           // }

          //  override fun onQueryTextSubmit(query: String): Boolean {
              //  return false
            //}

       // })
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

    private fun configMenuLateral(){
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        var menuLateral = findViewById<DrawerLayout>(R.id.layout_menu_lateral)

        var toogle = ActionBarDrawerToggle(this, menuLateral, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        menuLateral.addDrawerListener(toogle)
        toogle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.menu_lateral)
        navigationView.setNavigationItemSelectedListener(this)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_mercados -> {
                Toast.makeText(this, "Carregando...",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,CarrinhoActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_comparar -> {
                Toast.makeText(this, "Carregando...",Toast.LENGTH_SHORT).show()
            }
            R.id.nav_localiza -> {
                Toast.makeText(this, "Localizando...",Toast.LENGTH_SHORT).show()
            }
            R.id.nav_sair -> {
                Toast.makeText(this, "Saindo...",Toast.LENGTH_SHORT).show()
                finishAffinity()
            }
        }
        layout_menu_lateral.closeDrawer(GravityCompat.START)
        return true
    }
}
