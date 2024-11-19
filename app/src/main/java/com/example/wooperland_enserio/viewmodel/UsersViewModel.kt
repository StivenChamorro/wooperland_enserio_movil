package com.example.wooperland_enserio.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wooperland_enserio.data.UserRepository
import com.example.wooperland_enserio.model.UserResponse
import kotlinx.coroutines.launch

class UsersViewModel : ViewModel() {
    private val repository = UserRepository()

    // Cambiamos el tipo de MutableLiveData a una lista de usuarios
    private val _users = MutableLiveData<List<UserResponse>>()
    val users: LiveData<List<UserResponse>> = _users

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                // Obtenemos la lista de usuarios desde el repositorio
                val responses = repository.getUsers() // Nota el cambio en el método
                _users.value = responses
                Log.d("FetchUsers", _users.value.toString()) // Usamos Log.d para debug
            } catch (e: Exception) {
                Log.e("FetchUsers", "Error fetching users: ${e.message}")
            }
        }
    }
}