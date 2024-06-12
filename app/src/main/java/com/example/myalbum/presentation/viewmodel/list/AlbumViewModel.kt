package com.example.myalbum.presentation.viewmodel.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myalbum.data.response.AlbumResponse
import com.example.myalbum.domain.AlbumUseCase
import kotlinx.coroutines.launch

class AlbumViewModel(private val useCase: AlbumUseCase) : ViewModel() {

    private var albumList = MutableLiveData<List<AlbumResponse>>()

    val albumLV
        get() = albumList

    init {
        viewModelScope.launch {
            albumList.value = useCase.getAllAlbumsOnStock()
        }
    }
}