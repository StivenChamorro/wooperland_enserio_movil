package com.example.wooperland_enserio.model.dto

import com.google.gson.annotations.SerializedName

data class RegisterDto(
    @SerializedName("name") val name: String,
    @SerializedName("last_name") val last_name: String,
    @SerializedName("birthdate") val birthdate: String,
    @SerializedName("email") val email: String,
    @SerializedName("user") val user: String,
    @SerializedName("password") val password: String,
    @SerializedName("password_confirmation") val password_confirmation: String,
)
