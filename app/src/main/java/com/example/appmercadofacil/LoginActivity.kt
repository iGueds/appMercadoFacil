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



        login_button.setOnClickListener {
            Toast.makeText(this, "Entrando...", Toast.LENGTH_SHORT).show()
            val Login = Login()
            Login.user = user_login.text.toString()
            Login.password = user_password.text.toString()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.setStatusBarColorTo(R.color.colorPrimary)
            }



            taskLogin(Login)


        }
    }
    private fun taskLogin(login: Login) {
        val intent = Intent(this, PrincipalActivity::class.java)
        Thread {
            LoginService.postLogin(login)
            runOnUiThread{startActivity(intent)
            }
        }.start()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun Window.setStatusBarColorTo(color: Int){
        this.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        this.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        this.statusBarColor = ContextCompat.getColor(baseContext, color)
    }
}