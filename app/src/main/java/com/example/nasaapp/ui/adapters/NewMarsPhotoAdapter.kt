package com.example.nasaapp.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasaapp.R
import com.example.nasaapp.network.models.MarsPhotoVO


class NewMarsPhotoAdapter(val testResponse: List<MarsPhotoVO>?): RecyclerView.Adapter<NewMarsPhotoAdapter.PhotoHolder>() {
    var response2 : List<MarsPhotoVO>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_photo_rec_view, viewGroup, false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        Log.d("TAG", "onBindViewHolder ${testResponse}")
        downloadImage(holder.itemView, holder.itemImage, position, testResponse)
    }

    class PhotoHolder(view: View):RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.item_imgView)
    }

    override fun getItemCount(): Int {
        var b: Int
        if (testResponse == null){
            b = 12
        } else b = testResponse!!.size
        return /*response2.size*/ b
    }


/*   fun takeResponse2(response: PhotosVO) {
        Log.d("TAG", "Adapter response $response" )
        response2 = response
        Log.d("TAG", "Adapter response $response2" )
    }*/

    private fun downloadImage(view: View, imageView: ImageView, position: Int, response: List<MarsPhotoVO>?){
        val url:String

        Log.d("TAG3", testResponse?.size.toString())

       Log.d("TAG", "Adapter fownlImage $testResponse")
       /* url = response2[position].img_src*/
        if (response == null){
            url ="https://i.gifer.com/74H8.gif"
        } else url = testResponse?.get(position)!!.img_src

        Glide
            .with(view)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.renew)
            .into(imageView)
    }
}