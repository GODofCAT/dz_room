package com.example.dz_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.somedatastorage.AppDatabase

class MainActivity : AppCompatActivity() {

    val fieldKey = ObservableField("")
    val fieldValue = ObservableField("")

    val dao  = AppDatabase.instance!!.dao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun add(){
        dao.insert(Item(fieldKey.get(),fieldValue.get().toString()))
    }
    fun get(){
        dao.getByKey(fieldKey.get())
    }
    fun update(){
        dao.update(Item(fieldKey.get(),fieldValue.get().toString()))
    }
    fun deleteByKey(){
        dao.deleteByKey(fieldKey.get())
    }
    fun delete(){
        dao.deleteAll()
    }
}