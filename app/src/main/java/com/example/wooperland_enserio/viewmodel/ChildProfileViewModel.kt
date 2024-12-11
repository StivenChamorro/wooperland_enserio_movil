package com.example.wooperland_enserio.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wooperland_enserio.data.ProfileChildRepository
import com.example.wooperland_enserio.model.dto.ProfileChildDto
import com.example.wooperland_enserio.model.dto.ProfileChildResponse
import com.example.wooperland_enserio.model.dto.UpdateChildDto
import kotlinx.coroutines.launch

class ChildProfileViewModel: ViewModel() {
    private val repository = ProfileChildRepository()

    private val _childProfile = MutableLiveData<ProfileChildResponse?>()
    val children: MutableLiveData<ProfileChildResponse?> = _childProfile

    // Variable para almacenar el ID del niño
    var childId: String? = null

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchChildProfile() {

        viewModelScope.launch {
            try {
                val response = repository.getChild()

                   childId = response?.child?.id
                   _childProfile.value = response
                   Log.d("fetchChild", response.toString())

            } catch (e: Exception) {
                _error.value = "Error fetching child profile: ${e.message}"
                Log.e("FetchChild", "Error fetching child profile: ${e.message}")
            } finally {

            }
        }
    }

    fun updateChildProfile(newNickname: String, newAbout: String) {
        viewModelScope.launch {
            try {
                if (childId == null) {
                    _error.value = "El ID del niño no está disponible. Inténtalo más tarde."
                    return@launch
                }

                // Construye el DTO para la solicitud.
                val updateChildDto = UpdateChildDto(nickname = newNickname, about = newAbout)

                // Realiza la llamada al repositorio.
                val response = repository.updateChildProfile(childId!!, updateChildDto)

                if (response != null) {
                    // Actualiza el estado con el nuevo perfil.
                    _childProfile.value = response
                    Log.d("UpdateChild", "Perfil actualizado correctamente: $response")
                } else {
                    _error.value = "Error al actualizar el perfil. Intenta de nuevo."
                }
            } catch (e: Exception) {
                _error.value = "Error al actualizar el perfil: ${e.message}"
                Log.e("UpdateChild", "Error: ${e.message}", e)
            }
        }
    }


}
