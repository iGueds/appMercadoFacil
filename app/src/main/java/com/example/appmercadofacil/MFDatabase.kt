package com.example.appmercadofacil

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Produto::class), version = 1)
abstract class MFDatabase: RoomDatabase(){
    abstract fun produtoDao(): ProdutoDAO

}