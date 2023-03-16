package com.example.mar16retrofitwithservices.model

import com.google.gson.annotations.SerializedName

data class MusicAlbum(
    @SerializedName("music")
    val album: List<Music>
)