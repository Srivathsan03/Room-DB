package com.srivathsan.room.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private val databaseName = "Room"
        var instance: AppDatabase? = null

        fun getInMemoryDatabase(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }

        fun getDatabase(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, databaseName)
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }

        fun destroyInstance() {
            instance = null
        }
    }
}