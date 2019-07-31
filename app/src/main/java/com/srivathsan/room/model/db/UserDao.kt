package com.srivathsan.room.model.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.srivathsan.room.model.network.response.User

@Dao
interface UserDao{
    @Query("SELECT * FROM User")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM User WHERE id = (:userId)")
    fun getUserById(userId: Int): User

    @Insert
    fun insertUser(vararg user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("DELETE FROM User")
    fun deleteAll()
}