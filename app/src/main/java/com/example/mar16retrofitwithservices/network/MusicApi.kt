package com.example.mar16retrofitwithservices.network

import com.example.mar16retrofitwithservices.model.MusicAlbum
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MusicApi {
    @GET("music.json")
    suspend fun getMusicAlbum(): Response<MusicAlbum>
}