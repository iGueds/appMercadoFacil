package com.example.appmercadofacil

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val imageView = findViewById<ImageView>(R.id.background_splash)
        val animation = AnimationUtils.loadAnimation(this,R.anim.splash_translate)
        imageView.startAnimation(animation)
        supportActionBar?.hide()

        changeToLogin()
    }

    fun changeToLogin(){
        val intent = Intent(this, LoginActivity::class.java)

        Handler().postDelayed({
            intent.change()
        },2000)
    }
    fun Intent.change(){
        startActivity(this)
        finish()
    }
}
