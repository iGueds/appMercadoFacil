package com.example.appmercadofacil

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ProdutoDAO {

    @Query("SELECT * FROM produto WHERE id=:id")
    fun getById(id: Long): Produto?

    @Query("SELECT * FROM produto")
    fun findAll(): List<Produto>

    @Insert
    fun insert(produto: Produto)

    @Delete
    fun delete(produto: Produto)
}