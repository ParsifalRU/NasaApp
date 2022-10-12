package com.example.nasaapp.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasaapp.R
import com.example.nasaapp.network.models.PhotosVO


class NewMarsPhotoAdapter: RecyclerView.Adapter<NewMarsPhotoAdapter.PhotoHolder>() {
    lateinit var response1: PhotosVO

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_photo_rec_view, viewGroup, false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val url = response1.photos[position].img_src
        Log.d("TAG", "URL = ${response1.photos[position].img_src}")
        downloadImage(holder.itemView, holder.itemImage, url)

    }

    class PhotoHolder(view: View):RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.item_imgView)
    }

    override fun getItemCount(): Int {
        return itemCount
    }

    fun takeResponse2(response:PhotosVO){
        Log.d("TAG", "Adapter response ${response}" )
        response1 = response
    }

    private fun downloadImage(view: View, imageView: ImageView, url: String){
        Glide
            .with(view)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.renew)
            .into(imageView)
    }
}