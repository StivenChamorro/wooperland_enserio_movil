package com.example.wooperland_enserio.service


import com.example.wooperland_enserio.model.dto.ChildrenResponse
import com.example.wooperland_enserio.model.dto.ProfileChildDto
import com.example.wooperland_enserio.model.dto.ProfileChildResponse
import com.example.wooperland_enserio.model.dto.UpdateChildDto
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface ChildrenApiService {
    @Multipart
    @POST("children/store")
    suspend fun addChild(
        @Part("name") name: RequestBody,
        @Part("lastname") lastname: RequestBody,
        @Part("birthdate") birthdate: RequestBody,
        @Part("nickname") nickname: RequestBody,
        @Part("relation") relation: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part("about") about: RequestBody?,
        @Part avatar: MultipartBody.Part? // Archivo de imagen
    ): Response<ChildrenResponse>


    @GET("user/first-child")
    suspend fun getChild(): Response<ProfileChildResponse>

    @PUT("update/{children}")
    suspend fun updateChild(
        @Path("children") childId: String, // Se pasa el ID como parámetro en la URL
        @Body profileChildDto: UpdateChildDto // Se pasa el cuerpo de la solicitud
    ): Response<ProfileChildResponse>
}
