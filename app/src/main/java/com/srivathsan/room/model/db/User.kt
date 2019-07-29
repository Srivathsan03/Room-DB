package com.srivathsan.room.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val uid:Int,

    @ColumnInfo(name = "name")
    val name:String?,

    @ColumnInfo(name = "username")
    val username:String?,

    @ColumnInfo(name = "email")
    val email:String?
)