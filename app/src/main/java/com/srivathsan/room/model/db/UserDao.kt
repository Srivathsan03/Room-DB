package com.srivathsan.room.model.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao{
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Query("SELECT * FROM User WHERE id = (:userId)")
    fun getUserById(userId: Int): User

    @Insert
    fun insertAll(vararg user: User)

    @Delete
    fun delete(user: User)
}