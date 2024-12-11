package com.example.wooperland_enserio.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wooperland_enserio.model.dto.AddChildDto
import com.example.wooperland_enserio.model.dto.ChildrenResponse
import com.example.wooperland_enserio.service.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class AddChildViewModel : ViewModel() {

    // Estado para manejar la respuesta o errores
    private val _responseState = MutableStateFlow<ChildrenResponse?>(null)
    val responseState = _responseState.asStateFlow()

    private val _errorState = MutableStateFlow<String?>(null)
    val errorState = _errorState.asStateFlow()

    fun addChild(dto: AddChildDto) {
        viewModelScope.launch {
            try {
                // Llamar a RetrofitInstance para realizar la solicitud
                val response = RetrofitInstance.childrenService.addChild(
                    name = dto.name,
                    lastname = dto.lastname,
                    birthdate = dto.birthdate,
                    nickname = dto.nickname,
                    relation = dto.relation,
                    gender = dto.gender,
                    about = dto.about,
                    avatar = dto.avatar
                )

                if (response.isSuccessful) {
                    _responseState.value = response.body()
                } else {
                    _errorState.value = "Error: ${response.code()} - ${response.message()}"
                }
            } catch (e: Exception) {
                Log.e("AddChildViewModel", "Error adding child: ${e.message}", e)
                _errorState.value = e.message
            }
        }
    }

    // Método para crear el DTO desde los datos del formulario
    fun createAddChildDto(
        name: String,
        lastname: String,
        birthdate: String,
        nickname: String,
        relation: String,
        gender: String,
        about: String?,
        avatarPath: String?
    ): AddChildDto {
        val nameBody = name.toRequestBody("text/plain".toMediaTypeOrNull())
        val lastnameBody = lastname.toRequestBody("text/plain".toMediaTypeOrNull())
        val birthdateBody = birthdate.toRequestBody("text/plain".toMediaTypeOrNull())
        val nicknameBody = nickname.toRequestBody("text/plain".toMediaTypeOrNull())
        val relationBody = relation.toRequestBody("text/plain".toMediaTypeOrNull())
        val genderBody = gender.toRequestBody("text/plain".toMediaTypeOrNull())
        val aboutBody = about?.toRequestBody("text/plain".toMediaTypeOrNull())

        val avatarPart = avatarPath?.let {
            val file = File(it)
            val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
            MultipartBody.Part.createFormData("avatar", file.name, requestFile)
        }

        return AddChildDto(
            name = nameBody,
            lastname = lastnameBody,
            birthdate = birthdateBody,
            nickname = nicknameBody,
            relation = relationBody,
            gender = genderBody,
            about = aboutBody,
            avatar = avatarPart
        )
    }
}
