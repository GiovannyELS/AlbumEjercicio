package com.example.myalbum.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myalbum.R
import com.example.myalbum.data.network.api.AlbumServices
import com.example.myalbum.data.network.retrofit.RetrofitHelper
import com.example.myalbum.data.repository.AlbumRepositoryImpl
import com.example.myalbum.databinding.ActivityMainBinding
import com.example.myalbum.domain.AlbumUseCase
import com.example.myalbum.presentation.viewmodel.AlbumViewModel
import com.example.myalbum.presentation.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiService = RetrofitHelper.getRetrofit().create(AlbumServices::class.java)
        val repository = AlbumRepositoryImpl(apiService)
        val useCase = AlbumUseCase(repository)
        val viewModelFactory = ViewModelFactory (useCase)
        val viewModel = ViewModelProvider(this, viewModelFactory)[AlbumViewModel::class.java]

        val adapterAlbum = AlbumAdapter()
        binding.vgRecycler.adapter = adapterAlbum
        binding.vgRecycler.layoutManager = LinearLayoutManager(this)


        viewModel.albumLV.observe(this) {
            Log.i("GAMES", "games")
            adapterAlbum.albumes = it.toMutableList()
        }
    }
}