package com.example.myalbum.domain

import com.example.myalbum.data.repository.AlbumRepositoryImpl
import com.example.myalbum.data.response.AlbumResponse

class AlbumUseCase  (private val repository: AlbumRepositoryImpl) {

    suspend fun getAllAlbumsOnStock(): MutableList<AlbumResponse>{
        return repository.fetchAlbum()
    }

    suspend fun getAlbumByIdOnStock(idAlbum: Long): AlbumResponse{
        return repository.fetchAlbumById(idAlbum)
    }
}