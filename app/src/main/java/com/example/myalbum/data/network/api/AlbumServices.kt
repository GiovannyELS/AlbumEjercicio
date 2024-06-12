package com.example.myalbum.data.network.api

import com.example.myalbum.data.response.AlbumResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumServices {

    @GET("photos")
    suspend fun getAllAlbum(): MutableList<AlbumResponse>

    @GET("photos/{id}")
    suspend fun getAlbumById(@Path("id") idAlbum: Long): AlbumResponse

}