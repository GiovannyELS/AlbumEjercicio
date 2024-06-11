package com.example.myalbum.data.repository

import com.example.myalbum.data.response.AlbumResponse

interface AlbumRepository {

    suspend fun fetchAlbum(): MutableList<AlbumResponse>

}