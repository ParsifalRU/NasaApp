package com.example.nasaapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaapp.R
import com.example.nasaapp.main.MainActivity

class NewMarsPhotoAdapter: RecyclerView.Adapter<NewMarsPhotoAdapter.PhotoHolder>() {



    class PhotoHolder(view: View):RecyclerView.ViewHolder(view) {

        val textvw0: TextView
        val textvw1: TextView
        val textvw2: TextView
        val imgv: ImageView

        init {
            textvw0 = view.findViewById(R.id.tv_rec1)
            textvw1 = view.findViewById(R.id.tv_rec2)
            textvw2 = view.findViewById(R.id.tv_rec3)
            imgv = view.findViewById(R.id.imgv)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_rv, viewGroup, false)

        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        Picasso.with(MainActivity().baseContext)
            .load(dm.reviews[position].userImage)
            .placeholder(R.drawable.ic_baseline_data_usage_24)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.imgv)

        holder.textvw0.text = dm.reviews[position].userName
        holder.textvw1.text = dm.reviews[position].date
        holder.textvw2.text = dm.reviews[position].message

    }

    override fun getItemCount(): Int {
        return dm.reviews.size
    }

}