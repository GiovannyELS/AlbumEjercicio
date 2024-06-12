package com.example.myalbum.presentation.viewmodel.listdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myalbum.domain.AlbumUseCase

class ViewModelDetailFactory (private val albumUseCase: AlbumUseCase) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
                return DetailViewModel(albumUseCase) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }