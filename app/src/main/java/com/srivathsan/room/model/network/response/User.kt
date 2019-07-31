package com.srivathsan.room.model.network.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class User(
    /*data class cant be stored in db, so commented*/
//    @SerializedName("address")
//    val address: Address,
//    @SerializedName("company")
//    val company: Company,
    @SerializedName("email")
    val email: String,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String
)