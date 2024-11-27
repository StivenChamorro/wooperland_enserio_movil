package com.example.wooperland_enserio.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wooperland_enserio.model.dto.RegisterDto
import com.example.wooperland_enserio.service.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.text.SimpleDateFormat
import java.util.Locale

class RegisterViewModel : ViewModel() {

    // Estados observables
    val isSuccessRegister = mutableStateOf(false)
    val progressBar = mutableStateOf(false)
    val token = mutableStateOf("") // Token JWT recibido
    val errorMessage = mutableStateOf("") // Mensaje de error para la interfaz

    // Formatear la fecha de nacimiento al formato esperado por el backend
    private fun formatBirthdate(inputDate: String): String? {
        val inputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        val outputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        return try {
            val date = inputFormat.parse(inputDate)
            outputFormat.format(date)
        } catch (e: Exception) {
            Log.e("DateFormatError", "Error al formatear la fecha: ${e.message}", e)
            null // Retorna null si no es válida
        }
    }

    // Función principal de registro
    fun register(
        name: String,
        lastName: String,
        birthdate: String,
        email: String,
        user: String,
        password: String,
        confirmPassword: String,
        jwtToken: String
    ) {
        // Validar campos antes de la solicitud
        val formattedBirthdate = formatBirthdate(birthdate)
        if (formattedBirthdate == null) {
            errorMessage.value = "Formato de fecha inválido. Usa DD/MM/YYYY."
            return
        }
        if (password != confirmPassword) {
            errorMessage.value = "Las contraseñas no coinciden."
            return
        }
        if (name.isBlank() || lastName.isBlank() || email.isBlank() || user.isBlank()) {
            errorMessage.value = "Todos los campos son obligatorios."
            return
        }

        // Iniciar la solicitud de registro
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Mostrar progreso
                progressBar.value = true
                errorMessage.value = ""

                // Llamada al servicio
                val authService = RetrofitHelper.getAuthService()
                val response = authService.register(
                    RegisterDto(name, lastName, formattedBirthdate, email, user, password, confirmPassword)
                )

                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    if (registerResponse != null) {
                        // Guardar el token y procesar el usuario
                        token.value = registerResponse.token
                        isSuccessRegister.value = true
                        Log.d("RegisterSuccess", "Registro exitoso. Token recibido: ${token.value}")
                    } else {
                        errorMessage.value = "El servidor no devolvió datos válidos."
                        Log.e("RegisterError", "Respuesta sin datos.")
                    }
                } else {
                    handleHttpError(response.code(), response.message())
                }
            } catch (e: HttpException) {
                errorMessage.value = "Error en la conexión: ${e.message}"
                Log.e("RegisterError", "Excepción HTTP", e)
            } catch (e: Exception) {
                errorMessage.value = "Error inesperado: ${e.localizedMessage}"
                Log.e("RegisterError", "Error desconocido", e)
            } finally {
                // Ocultar progreso
                progressBar.value = false
            }
        }

    }

    // Manejo de errores HTTP específicos
    private fun handleHttpError(code: Int, message: String) {
        val errorMsg = when (code) {
            400 -> "Datos inválidos. Verifica los campos ingresados."
            401 -> "No autorizado. Revisa tus credenciales."
            500 -> "Error en el servidor. Intenta más tarde."
            else -> "Error desconocido: $code - $message"
        }
        errorMessage.value = errorMsg
        Log.e("RegisterError", errorMsg)
    }
}
