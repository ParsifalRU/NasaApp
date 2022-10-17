package com.example.nasaapp.ui.fragments.fragment

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nasaapp.databinding.MarsPhotoNewBinding
import com.example.nasaapp.ui.adapters.NewMarsPhotoAdapter

class FragmentNewMarsPhoto() : Fragment(){

    val adapter = NewMarsPhotoAdapter()
    lateinit var binding: MarsPhotoNewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MarsPhotoNewBinding.inflate(inflater, container, false)
        setVerticalRecyclerView()
        return binding.root
    }

private fun setVerticalRecyclerView(){
    binding.vertRecyclerView.layoutManager = GridLayoutManager(Application().baseContext, 3)
    binding.vertRecyclerView.adapter = adapter
}

    companion object {
        @JvmStatic
        fun newInstance(arg1: Bundle?): FragmentNewMarsPhoto {
            val fragmentNewMarsPhoto = FragmentNewMarsPhoto()
            fragmentNewMarsPhoto.arguments = arg1
            Log.d("TAG2","arg from fragment${fragmentNewMarsPhoto.arguments?.get("response")}")
            return fragmentNewMarsPhoto
        }
    }

}