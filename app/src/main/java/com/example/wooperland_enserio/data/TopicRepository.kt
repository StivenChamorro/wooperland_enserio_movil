package com.example.wooperland_enserio.data

import RetrofitHelper
import android.util.Log
import com.example.wooperland_enserio.model.TopicResponse
import com.example.wooperland_enserio.service.RetrofitInstance

class TopicRepository {

    private val topicService = RetrofitHelper.getTopicService()

    suspend fun getTopics(): List<TopicResponse> {
        try {
            val response = topicService.getTopics()
            Log.d("ApiResponse", response.body().toString())

            // Verifica si la respuesta fue exitosa
            if (response.isSuccessful) {
                val body = response.body()

                // Verifica si el cuerpo no es nulo ni vacío
                if (body.isNullOrEmpty()) {
                    throw Exception("La respuesta de la API está vacía")
                }
                return body
            } else {
                // Agrega información adicional al error, como el cuerpo de la respuesta o mensaje
                val errorMessage = "Error en la respuesta de la API: ${response.code()}, ${response.message()}"
                Log.e("TopicRepository", errorMessage)
                throw Exception(errorMessage)
            }
        } catch (e: Exception) {
            // Registra el error con más detalles
            Log.e("TopicRepository", "Error en la llamada a la API: ${e.message}", e)
            throw Exception("Error en la llamada a la API: ${e.message}")
        }
    }
}
