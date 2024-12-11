package com.example.wooperland_enserio.model.dto

import com.google.gson.annotations.SerializedName

data class ChildrenResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("child") val child: Child
)

data class Child(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("birthdate") val birthdate: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("relation") val relation: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("avatar") val avatar: String?, // URL de Cloudinary
    @SerializedName("about") val about: String?,
    @SerializedName("user_id") val userId: Int
)
