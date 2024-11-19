package com.example.wooperland_enserio.service

import com.example.wooperland_enserio.model.UserProfileResponse
import com.example.wooperland_enserio.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    //obtener todos los usuarios
    @GET("user/index")
    suspend fun getUsers(): List<UserResponse>

    //obtener un usuario por id
    @GET("user/profile")
    suspend fun getUserProfile(): UserProfileResponse


}