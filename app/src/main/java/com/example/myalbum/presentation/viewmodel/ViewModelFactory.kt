package com.example.myalbum.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myalbum.domain.AlbumUseCase

class ViewModelFactory (private val albumUseCase: AlbumUseCase) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlbumViewModel::class.java)) {
                return AlbumViewModel(albumUseCase) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")

        }
    }