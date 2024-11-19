package com.example.wooperland_enserio.data

import com.example.wooperland_enserio.model.UserProfileResponse
import com.example.wooperland_enserio.model.UserResponse
import com.example.wooperland_enserio.service.RetrofitInstance

class UserProfileRepository {
    private val usersProfileService = RetrofitInstance.wooperService

    suspend fun getUserProfile(): UserProfileResponse {
        return usersProfileService.getUserProfile()
    }
}