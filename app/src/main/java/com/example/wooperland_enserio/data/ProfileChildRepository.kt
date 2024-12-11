package com.example.wooperland_enserio.data

import android.util.Log
import com.example.wooperland_enserio.model.dto.ProfileChildDto
import com.example.wooperland_enserio.model.dto.ProfileChildResponse
import com.example.wooperland_enserio.model.dto.UpdateChildDto
import retrofit2.Response

class ProfileChildRepository {

    private val profileChildService = RetrofitHelper.getProfileChildService()

    suspend fun getChild(): ProfileChildResponse? {
        try {
            // Realiza la llamada a la API
            val response: Response<ProfileChildResponse> = profileChildService.getChild()

            // Verifica si la respuesta fue exitosa
            if (response.isSuccessful) {
                val body = response.body()

                // Si el cuerpo no es nulo, se retorna el objeto
                body?.let {
                    return it
                } ?: run {
                    Log.e(
                        "ProfileChildRepository",
                        "La respuesta es exitosa pero el cuerpo es nulo."
                    )
                    return null  // Devuelve null si el cuerpo es nulo
                }
            } else {
                // Si la respuesta no fue exitosa, se maneja el error
                val errorMessage =
                    "Error en la respuesta de la API: ${response.code()}, ${response.message()}"
                Log.e("ProfileChildRepository", errorMessage)
                throw Exception(errorMessage)
            }
        } catch (e: Exception) {
            // Se maneja la excepción con un mensaje más detallado
            Log.e("ProfileChildRepository", "Error al hacer la llamada a la API: ${e.message}", e)
            throw Exception("Error al hacer la llamada a la API: ${e.message}")
        }
    }

    suspend fun updateChildProfile(childId: String, updateChildDto: UpdateChildDto): ProfileChildResponse? {
        try {
            val response = profileChildService.updateChild(childId, updateChildDto)
            if (response.isSuccessful) {
                return response.body()
            } else {
                throw Exception("API error: ${response.code()} - ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e("ProfileChildRepository", "Error: ${e.message}", e)
            throw Exception("Error updating child profile: ${e.message}")
        }
    }
}
