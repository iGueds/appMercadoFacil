package com.example.appmercadofacil

import android.app.Application
import java.lang.IllegalStateException

class MFApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: MFApplication?  = null
        fun getInstance(): MFApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no Android Manifest")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}