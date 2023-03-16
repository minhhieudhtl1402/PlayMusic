package com.example.mar16retrofitwithservices.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MusicClient {
    val BASE_URL = "https://storage.googleapis.com/automotive-media/"
    fun invoke(): MusicApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MusicApi::class.java)
    }
}