package com.example.wooperland_enserio.model.dtoAuht

data class UserDto(
    val id: Int,
    val name: String,
    val last_name: String,
    val birthdate: String,
    val email: String,
    val user: String,
    val created_at: String,
    val updated_at: String,
    val token: String // Nuevo campo para incluir el token
)
