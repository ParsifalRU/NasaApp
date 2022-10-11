package com.example.nasaapp.ui.fragments.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.nasaapp.databinding.MarsPhotoNewBinding
import com.example.nasaapp.ui.adapters.NewMarsPhotoAdapter
import com.example.nasaapp.ui.fragments.view_model.ViewModelNewPhoto

class FragmentNewMarsPhoto : Fragment() {
    val adapter = NewMarsPhotoAdapter()
    lateinit var binding: MarsPhotoNewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MarsPhotoNewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setVerticalRecyclerView()
        ViewModelNewPhoto().livedata.observe(viewLifecycleOwner, Observer { id -> takeId(id)})
        super.onViewCreated(view, savedInstanceState)
    }

    fun takeId(id:String){
        Log.d("TagData", id)
    }

private fun setVerticalRecyclerView(){
    binding.vertRecyclerView.adapter = adapter
}

    companion object {
        @JvmStatic
        fun newInstance() = FragmentNewMarsPhoto()
    }
}