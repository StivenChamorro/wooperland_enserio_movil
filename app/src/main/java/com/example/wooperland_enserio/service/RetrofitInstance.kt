package com.example.wooperland_enserio.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://backend-production-40d8.up.railway.app/v1")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    val wooperService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}