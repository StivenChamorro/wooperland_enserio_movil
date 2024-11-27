package com.example.wooperland_enserio.model.dto

import com.google.gson.annotations.SerializedName

data class RegisterResponseDto(
    @SerializedName("user") val user: UserDto, // Datos del usuario registrado
    @SerializedName("token") val token: String // Token JWT recibido
)
