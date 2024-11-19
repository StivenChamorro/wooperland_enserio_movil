package com.example.wooperland_enserio.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wooperland_enserio.data.UserProfileRepository
import com.example.wooperland_enserio.data.UserRepository
import com.example.wooperland_enserio.model.UserProfileResponse
import com.example.wooperland_enserio.model.UserResponse
import kotlinx.coroutines.launch

class ProfileUserViewModel: ViewModel() {
    private val repository = UserProfileRepository()

    private val _userProfile = MutableLiveData<UserProfileResponse>()
    val userProfile: LiveData<UserProfileResponse> = _userProfile

    fun fetchUserProfile() {
        viewModelScope.launch {
            try {
                val user = repository.getUserProfile()  // Obtener datos del perfil
                _userProfile.value = user
            } catch (e: Exception) {
                Log.e("FetchUserProfile", "Error fetching profile: ${e.message}")
            }
        }
    }
}