package com.example.myalbum.presentation.ui.listdetail

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.myalbum.R
import com.example.myalbum.data.network.api.AlbumServices
import com.example.myalbum.data.network.retrofit.RetrofitHelper
import com.example.myalbum.data.repository.AlbumRepositoryImpl
import com.example.myalbum.databinding.ActivityMainDetailBinding
import com.example.myalbum.domain.AlbumUseCase
import com.example.myalbum.presentation.viewmodel.listdetail.DetailViewModel
import com.example.myalbum.presentation.viewmodel.listdetail.ViewModelDetailFactory
import com.squareup.picasso.Picasso

class MainActivityDetail : AppCompatActivity() {

    private lateinit var bindingDetail: ActivityMainDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bindingDetail = ActivityMainDetailBinding.inflate(layoutInflater)
        setContentView(bindingDetail.root)

        val idAlbum = intent.getLongExtra("ID_ALBUM", -1)
        if (idAlbum == -1L) {
            finish()
        }

        val apiServices = RetrofitHelper.getRetrofit().create(AlbumServices::class.java)
        val repository = AlbumRepositoryImpl(apiServices)
        val useCase = AlbumUseCase(repository)
        val viewModelFactory = ViewModelDetailFactory(useCase)
        val viewModel = ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]

        viewModel.getDetailAlbumById(idAlbum)

        viewModel.albumDetailLV.observe(this){
            with(it){
                bindingDetail.longIdDetail.text = id.toString()
                bindingDetail.txtTitulo.text = title
                bindingDetail.urlIdLongDetail.text = albumId.toString()
                Picasso
                    .get()
                    .load(url)
                    .into(bindingDetail.backgroundImageViewDetail)

                Picasso
                    .get()
                    .load(thumbnailUrl)
                    .into(bindingDetail.thumbnailurlDetail)
            }

        }
        bindingDetail.longIdDetail.text = idAlbum.toString()
    }
}