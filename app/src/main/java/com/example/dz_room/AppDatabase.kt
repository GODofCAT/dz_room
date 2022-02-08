package com.example.somedatastorage
import androidx.room.*
import androidx.room.Room.databaseBuilder
import com.example.dz_room.Dao
import com.example.dz_room.Item
import com.example.dz_room.MainActivity

@Database(entities = [Item::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val dao: Dao

    companion object {
        @Volatile
        var instance:AppDatabase?=null
        get(){
            var instance=field
            return instance?: synchronized(this) { databaseBuilder(
                        MainActivity.context,
                        AppDatabase::class.java,
                        "app_database"
                    ).fallbackToDestructiveMigration().build()
                }.also { field=it }
        }



    }

}