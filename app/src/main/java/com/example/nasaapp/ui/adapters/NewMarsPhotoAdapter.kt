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

    var response2 : PhotosVO? = null
    /*lateinit var url: String*/

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_photo_rec_view, viewGroup, false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        Log.d("TAG", "onBindViewHolder ${response2}")
      /*  var url = response.photos[position].img_src
        Log.d("TAG", "URL = ${response.photos[position].img_src}")*/
        downloadImage(holder.itemView, holder.itemImage/*, url*/)

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

    private fun downloadImage(view: View, imageView: ImageView/*, url: String*/){
        Glide
            .with(view)
            .load("http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG")
            .centerCrop()
            .placeholder(R.drawable.renew)
            .into(imageView)
    }
}