package com.example.wooperland_enserio.model.dto

import okhttp3.MultipartBody
import okhttp3.RequestBody

data class AddChildDto(
    val name: RequestBody,
    val lastname: RequestBody,
    val birthdate: RequestBody,
    val nickname: RequestBody,
    val relation: RequestBody,
    val gender: RequestBody,
    val about: RequestBody?,
    val avatar: MultipartBody.Part? // Imagen como archivo
)
