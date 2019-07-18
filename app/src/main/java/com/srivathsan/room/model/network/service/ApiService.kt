package com.srivathsan.room.model.network.service

import com.srivathsan.room.model.network.response.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users.json")
    fun getUsers(): Call<List<User>>
}