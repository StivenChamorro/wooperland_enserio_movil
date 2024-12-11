package com.example.wooperland_enserio.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wooperland_enserio.data.TopicRepository
import com.example.wooperland_enserio.model.TopicResponse
import kotlinx.coroutines.launch

class TopicsViewModel: ViewModel() {
    private val repository = TopicRepository()

    private val _topics = MutableLiveData<List<TopicResponse>>()
    val topics: LiveData<List<TopicResponse>> = _topics

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchTopics() {
        _loading.value = true
        viewModelScope.launch {
            try {
                val response = repository.getTopics()

                Log.d("Topics", "Datos recibidos: $topics")

                // Verifica si la respuesta está vacía
                if (response.isNullOrEmpty()) {
                    _error.value = "La respuesta está vacía"
                    Log.e("FetchTopics", "La respuesta está vacía")
                } else {
                    _topics.value = response
                    Log.d("fetchTopics", response.toString())
                }
            } catch (e: Exception) {
                _error.value = "Error fetching topics: ${e.message}"
                Log.e("FetchTopics", "Error fetching topics: ${e.message}")
            } finally {
                _loading.value = false
            }
        }
    }
}
