package com.example.wooperland_enserio.service


import com.example.wooperland_enserio.model.TopicResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TopicService {
    @GET("topic/index")
    suspend fun getTopics(): Response<List<TopicResponse>>
}