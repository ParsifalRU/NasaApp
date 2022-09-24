package com.example.nasaapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaapp.R

class NewMarsPhotoAdapter: RecyclerView.Adapter<NewMarsPhotoAdapter.PhotoHolder>() {

    class PhotoHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_phoro_rec_view, viewGroup, false)

        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {



    }

    override fun getItemCount(): Int {
        return itemCount
    }

}