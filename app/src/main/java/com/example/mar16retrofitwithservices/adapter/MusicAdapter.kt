package com.example.mar16retrofitwithservices.adapter

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mar16retrofitwithservices.databinding.MusicItemBinding
import com.example.mar16retrofitwithservices.model.Music
import com.example.mar16retrofitwithservices.model.MusicAlbum

class MusicAdapter(val musicAlbum: MusicAlbum) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {
    companion object {
        val BASE_URL = "https://storage.googleapis.com/automotive-media/"
    }

    inner class ViewHolder(val binding: MusicItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
//            binding.ivCover
            Glide.with(binding.ivCover).load(BASE_URL + musicAlbum.album[position].image)
                .into(binding.ivCover)
            binding.tvName.text = musicAlbum.album[position].title
            binding.ivCover.setOnClickListener {

                binding.ivCover.setOnClickListener{
//                    val mediaPlayer=MediaPlayer
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicAdapter.ViewHolder {
        val binding = MusicItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicAdapter.ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return musicAlbum.album.size
    }
}