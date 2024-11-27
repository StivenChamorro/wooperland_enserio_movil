package com.example.wooperland_enserio.service


import com.example.wooperland_enserio.model.dto.LoginDto
import com.example.wooperland_enserio.model.dto.RegisterDto
import com.example.wooperland_enserio.model.dto.RegisterResponseDto
import com.example.wooperland_enserio.model.dto.TokenDto
import com.example.wooperland_enserio.model.dto.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun getLogin(@Body loginDto: LoginDto) :
            Response<TokenDto>

    @POST("auth/register")
    suspend fun register(@Body registerDto: RegisterDto): Response<RegisterResponseDto>
}