package com.example.wooperland_enserio.model.dto

import com.google.gson.annotations.SerializedName

data class TokenDto(
    @SerializedName("accessToken") val accessTokenVerify: String
)
