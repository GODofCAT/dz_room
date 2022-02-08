package com.example.dz_room

interface Dao {
    @Query("SELECT * FROM Item")
    fun getAll(): List<Item?>?

    @Query("SELECT * FROM Item WHERE key = :key")
    fun getByKey(key: Int): Item?

    @Query("DELETE * FROM Item WHERE key = :key")
    fun deleteByKey(key: Int): Item?

    @Query("DELETE * FROM Item")
    fun deleteAll()

    @Insert
    fun insert(employee: Item?)

    @Update
    fun update(employee: Item?)
}