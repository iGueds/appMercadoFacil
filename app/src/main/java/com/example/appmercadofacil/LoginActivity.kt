package com.example.appmercadofacil

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        //background_login.setImageResource(R.drawable.mercado_facil_background)


        login_button.setOnClickListener{
            Toast.makeText(this, "Entrando...", Toast.LENGTH_SHORT).show()
            val campoUsuario = user_login.text.toString()
            val valorSenha = user_password.text.toString()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                window.setStatusBarColorTo(R.color.colorPrimary)
            }

            if (campoUsuario == "aluno" && valorSenha == "impacta") {
                val intent = Intent(this, PrincipalActivity::class.java)
                val param = Bundle()
                param.putString("campo_login", "")
                param.putString("campo_senha","")
                intent.putExtras(param)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun Window.setStatusBarColorTo(color: Int){
        this.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        this.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        this.statusBarColor = ContextCompat.getColor(baseContext, color)
    }
}
