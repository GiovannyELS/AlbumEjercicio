package com.example.myalbum.presentation.viewmodel.listdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myalbum.data.response.AlbumResponse
import com.example.myalbum.domain.AlbumUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private val useCase: AlbumUseCase) : ViewModel() {

    private val _albumDetail = MutableLiveData<AlbumResponse>()
    val albumDetailLV: LiveData<AlbumResponse>
        get() = _albumDetail


    fun getDetailAlbumById(idAlbum: Long) {
        viewModelScope.launch {

            val album = useCase.getAlbumByIdOnStock(idAlbum)
            _albumDetail.value = album
        }
    }
}