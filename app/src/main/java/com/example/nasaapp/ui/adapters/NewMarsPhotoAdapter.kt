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


class NewMarsPhotoAdapter(): RecyclerView.Adapter<NewMarsPhotoAdapter.PhotoHolder>() {

    var response2 : PhotosVO? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_photo_rec_view, viewGroup, false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        Log.d("TAG", "onBindViewHolder ${response2?.photos?.get(position)}")


      /*  var url = response.photos[position].img_src
        Log.d("TAG", "URL = ${response.photos[position].img_src}")*/

        downloadImage(holder.itemView, holder.itemImage, position)


    }

    class PhotoHolder(view: View):RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.item_imgView)
    }

    override fun getItemCount(): Int {
        return 12
    }

    fun takeResponse2(response: PhotosVO): PhotosVO {
        Log.d("TAG", "Adapter response ${response}" )
        response2 = response
        return response
    }

    private fun downloadImage(view: View, imageView: ImageView, position: Int){
        var url:String
        when(response2 == null){
            false -> url = response2!!.photos[position].img_src
            else -> {url = "https://apod.nasa.gov/apod/image/2111/MACSJ0138_Hubble_1080.jpg"}
        }

        Glide
            .with(view)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.renew)
            .into(imageView)
    }
}