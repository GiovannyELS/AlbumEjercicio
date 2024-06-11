package com.example.myalbum.data.network.api

import com.example.myalbum.data.response.AlbumResponse
import retrofit2.http.GET

interface AlbumServices {

    @GET("photos")
    suspend fun getAllAlbum(): MutableList<AlbumResponse>
}