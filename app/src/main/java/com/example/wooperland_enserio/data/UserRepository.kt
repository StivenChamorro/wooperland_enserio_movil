package com.example.wooperland_enserio.data


import com.example.wooperland_enserio.model.UserProfileResponse
import com.example.wooperland_enserio.model.UserResponse
import com.example.wooperland_enserio.service.RetrofitInstance

class UserRepository {
    private val usersService = RetrofitInstance.wooperService

    // Cambiamos el tipo de retorno a List<User>
    suspend fun getUsers(): List<UserResponse> {
        return usersService.getUsers()
    }


}
