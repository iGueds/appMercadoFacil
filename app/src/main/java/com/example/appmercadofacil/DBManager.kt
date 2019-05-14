package com.example.appmercadofacil

import android.arch.persistence.room.Room

object DBManager {

    private var dbInstance: MFDatabase

    init {
        val context = MFApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            MFDatabase::class.java,
            "MF.sqlite"
        ).build()
    }

    fun getProdutoDAO(): ProdutoDAO{
        return dbInstance.produtoDao()
    }

}