package com.example.somedatastorage
import android.content.Context
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
        var _instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = _instance

                if (instance == null) {

                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "Item"
                    ).fallbackToDestructiveMigration().build()

                    _instance = instance
                }

                return instance
            }

        }
    }
}
