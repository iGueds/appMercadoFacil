package com.example.appmercadofacil

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

            if (campoUsuario == "aluno" && valorSenha == "impacta") {
                val intent = Intent(this, TelaInicial::class.java)
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
}
