package com.example.wooperland_enserio.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wooperland_enserio.model.dtoAuht.LoginDto
import com.example.wooperland_enserio.model.dtoAuht.TokenDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.content.Context
import com.example.wooperland_enserio.utils.MyApp.Companion.context


class LoginViewModel: ViewModel() {
    val isSuccessLoading = mutableStateOf(value = false)
    val imageErrorAuth = mutableStateOf(value = false)
    val progressBar = mutableStateOf(value = false)
    val isFirstLogin = mutableStateOf(value = false)  // Nueva variable para el primer inicio de sesión
    private val loginRequestLiveData = MutableLiveData<Boolean>()

    init {
        // Cargar el valor inicial desde SharedPreferences.
        val sharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        isFirstLogin.value = sharedPreferences.getBoolean("isFirstLogin", true)
    }

    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                progressBar.value = true
                val authService = RetrofitHelper.getAuthService()
                val responseService = authService.getLogin(LoginDto(email = email, password = password))

                if (responseService.isSuccessful) {
                    delay(1500L)
                    isSuccessLoading.value = true
                    responseService.body()?.let { tokenDto ->
                        RetrofitHelper.saveAuthToken(tokenDto.accessToken)
                        Log.d("Logging", "Token guardado: ${tokenDto.accessToken}")

                        // Si es el primer login, actualizar SharedPreferences.
                        if (isFirstLogin.value) {
                            val sharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
                            sharedPreferences.edit().putBoolean("isFirstLogin", false).apply()
                        }
                    }
                } else {
                    responseService.errorBody()?.let { error ->
                        imageErrorAuth.value = true
                        delay(1500L)
                        imageErrorAuth.value = false
                        error.close()
                    }
                }
                loginRequestLiveData.postValue(responseService.isSuccessful)
                progressBar.value = false
            } catch (e: Exception) {
                Log.d("Logging", "Error Authentication", e)
                progressBar.value = false
            }
        }
    }
}