package com.example.myalbum.data.repository

import com.example.myalbum.data.network.api.AlbumServices
import com.example.myalbum.data.response.AlbumResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AlbumRepositoryImpl (private var apiservice: AlbumServices): AlbumRepository {
    override suspend fun fetchAlbum(): MutableList<AlbumResponse> {
        return withContext(Dispatchers.IO) {
            val listAlbum = apiservice.getAllAlbum()
            listAlbum
        }
    }
}