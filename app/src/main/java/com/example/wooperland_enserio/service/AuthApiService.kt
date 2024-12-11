package com.example.wooperland_enserio.service


import com.example.wooperland_enserio.model.dtoAuht.LoginDto
import com.example.wooperland_enserio.model.dtoAuht.RegisterDto
import com.example.wooperland_enserio.model.dtoAuht.RegisterResponseDto
import com.example.wooperland_enserio.model.dtoAuht.TokenDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun getLogin(@Body loginDto: LoginDto) :
            Response<TokenDto>

    @POST("auth/register")
    suspend fun register(@Body registerDto: RegisterDto): Response<RegisterResponseDto>

    @POST("auth/logout")
    suspend fun logout(): Response<Unit>

}