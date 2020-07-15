package com.technokratos.core_db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(
//    version = 1,
//    entities = [
//    ]
//)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun get(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "app.db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }
}