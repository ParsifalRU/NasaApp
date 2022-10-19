package com.example.nasaapp.ui.fragments.fragment

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nasaapp.databinding.MarsPhotoNewBinding
import com.example.nasaapp.network.models.MarsPhotoVO
import com.example.nasaapp.ui.adapters.NewMarsPhotoAdapter
import com.example.nasaapp.ui.fragments.view_model.ViewModelNewPhoto

class FragmentNewMarsPhoto : Fragment(){

    lateinit var binding: MarsPhotoNewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MarsPhotoNewBinding.inflate(inflater, container, false)
        setVerticalRecyclerView()
        return binding.root
    }

 fun setVerticalRecyclerView(){

        val response = arguments?.getSerializable("List") as List<MarsPhotoVO>?
        Log.d("TAG4", response.toString())
        val adapter = NewMarsPhotoAdapter(response)
        binding.vertRecyclerView.layoutManager = GridLayoutManager(Application().baseContext, 3)
        binding.vertRecyclerView.adapter = adapter
        ViewModelNewPhoto().livedata.observe(viewLifecycleOwner, Observer { status -> changeItemsRecycler(status)})
}

fun changeItemsRecycler(status: String){
      if (status == "READY"){
          binding.vertRecyclerView.adapter?.notifyDataSetChanged()
          Log.d("TAG", "Перерисовка адаптера")
          setVerticalRecyclerView()
      }

}
    companion object {
        fun getNewInstance(arg1: Bundle?): FragmentNewMarsPhoto {
            val fragmentNewMarsPhoto = FragmentNewMarsPhoto()
            fragmentNewMarsPhoto.arguments = arg1
            t = fragmentNewMarsPhoto.arguments?.getSerializable("List")
            Log.d("TAG2","get newInstance ${fragmentNewMarsPhoto.arguments?.getSerializable("List")}")
            return fragmentNewMarsPhoto
        }
    }

}