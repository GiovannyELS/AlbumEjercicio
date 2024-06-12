package com.example.myalbum.presentation.ui.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myalbum.data.response.AlbumResponse
import com.example.myalbum.databinding.AlbumItemBinding
import com.squareup.picasso.Picasso

class AlbumAdapter: RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    lateinit var onItemClickListener: (AlbumResponse) -> Unit


    var albumes = mutableListOf<AlbumResponse>()
        set (value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albumes[position]
        holder.bindAlbum(album)
    }

    override fun getItemCount(): Int {
    return albumes.size
    }

    inner class ViewHolder(private var binding: AlbumItemBinding): RecyclerView.ViewHolder(binding.root) {


        fun bindAlbum(album: AlbumResponse) {
            binding.imageurl.setImageResource(0)
            Picasso.get()
                .load(album.url)
                .resize(200, 200)
                .centerCrop()
                .into(binding.imageurl)

            binding.thumbnailurl.setImageResource(0)
            Picasso.get()
                .load(album.thumbnailUrl)
                .resize(200, 200)
                .centerCrop()
                .into(binding.thumbnailurl)

            binding.txtTittle.text = album.title
            binding.longUrlId.text = album.id.toString()
            binding.longId.text = album.albumId.toString()

            setOnClickListener(album)

        }

        private fun setOnClickListener(album: AlbumResponse) {
            binding.root.setOnClickListener {
                if (::onItemClickListener.isInitialized)
                    onItemClickListener(album)
                else
                    Log.e("Adapter", "onClickListener no inicializada")
            }
        }

    }
}