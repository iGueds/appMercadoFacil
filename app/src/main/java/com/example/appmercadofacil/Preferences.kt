package com.example.appmercadofacil

import android.content.Context
import android.content.SharedPreferences

object Prefs {
    val PREF_ID = "MF"


    private fun prefs(): SharedPreferences {
        val context = MFApplication.getInstance().applicationContext
        return context.getSharedPreferences(PREF_ID, 0)
    }

    fun setBoolean(flag: String, valor: Boolean) =  prefs().edit().putBoolean(flag, valor).apply()

    fun getBoolean(flag: String) = prefs().getBoolean(flag, false)

    fun setString(flag: String, valor: String) =  prefs().edit().putString(flag, valor).apply()

    fun getString(flag: String) = prefs().getString(flag, "")

    fun setInt(flag: String, valor: Int) = prefs().edit().putInt(flag, valor).apply()

    fun getInt(flag: String) = prefs().getInt(flag, 0)
}