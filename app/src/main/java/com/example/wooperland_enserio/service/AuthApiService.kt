package com.example.wooperland_enserio.service


import com.example.wooperland_enserio.model.dto.LoginDto
import com.example.wooperland_enserio.model.dto.TokenDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun getLogin(@Body loginDto: LoginDto) :
            Response<TokenDto>
}