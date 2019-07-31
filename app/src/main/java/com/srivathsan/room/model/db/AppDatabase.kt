package com.srivathsan.room.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.srivathsan.room.model.network.response.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private const val DATABASE_NAME = "Room"
        private var instance: AppDatabase? = null

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
                instance = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
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