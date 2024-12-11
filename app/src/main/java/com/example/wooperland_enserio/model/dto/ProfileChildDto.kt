package com.example.wooperland_enserio.model.dto

data class ProfileChildResponse(
    val message: String,
    val child: ProfileChildDto // Aquí se agrega el objeto ProfileChildDto como hijo
)

data class ProfileChildDto(
    val id: String,
    val name: String,
    val lastname: String,
    val birthdate: String,
    val nickname: String,
    val relation: String,
    val gender: String,
    val about: String?,
    val avatar: String?,
    val user_id: Int
)

data class UpdateChildDto(
    val nickname: String,
    val about: String?
)
