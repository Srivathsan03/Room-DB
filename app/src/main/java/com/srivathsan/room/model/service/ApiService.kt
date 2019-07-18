package com.srivathsan.room.model.service

import com.srivathsan.room.model.response.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users.json")
    fun getUsers(): Call<List<User>>
}