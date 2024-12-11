package com.example.wooperland_enserio.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import kotlinx.coroutines.launch

class LogoutViewModel : ViewModel() {


     fun logout(context: Context, onLogoutComplete: () -> Unit) {
         viewModelScope.launch {

        try {

        val authApiService = RetrofitHelper.getAuthService()
        val response = authApiService.logout()
        if (response.isSuccessful) {
            RetrofitHelper.saveAuthToken("") // Limpiar token
            Toast.makeText(context, "Sesión cerrada con éxito", Toast.LENGTH_SHORT).show()
            onLogoutComplete()
        } else {
            println("Error al cerrar sesión: ${response.code()}")
        }
        }catch (e: HttpException){
            println("Error al cerrar sesión: ${e.message}")
        }catch (e: Exception){
            println("Error al cerrar sesión: ${e.message}")
        }
         }
    }
}