package com.example.dz_room

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModelStore
import com.example.somedatastorage.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
        val context: Context = applicationContext;
        val fieldKey = ObservableField("")
        val fieldValue = ObservableField("")

        val dao = AppDatabase._instance!!.dao

        fun add() {
            GlobalScope.launch { dao.insert(fieldKey.get()?.let { Item(it, fieldValue.get().toString()) }) }
        }

        fun get() {
            GlobalScope.launch { fieldValue.set(dao.getByKey(fieldKey.get())?.value.toString()); }
        }

        fun update() {
            GlobalScope.launch { dao.update(fieldKey.get()?.let { Item(it, fieldValue.get().toString()) }) }
        }

        fun deleteByKey() {
            GlobalScope.launch { dao.deleteByKey(fieldKey.get()) }
        }

        fun delete() {
            GlobalScope.launch { dao.deleteAll() }
        }

}