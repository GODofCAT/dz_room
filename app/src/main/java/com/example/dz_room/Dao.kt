package com.example.dz_room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {
    @Query("SELECT * FROM Item")
    fun getAll(): List<Item?>?

    @Query("SELECT * FROM Item WHERE `key` = :key")
    fun getByKey(key: String?): Item?

    @Query("DELETE FROM Item WHERE `key` = :key")
    fun deleteByKey(key: String?)

    @Query("DELETE FROM Item")
    fun deleteAll()

    @Insert
    fun insert(employee: Item?)

    @Update
    fun update(employee: Item?)
}