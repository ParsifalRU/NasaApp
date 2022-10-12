package com.example.nasaapp.ui.fragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nasaapp.databinding.MarsPhotoNewBinding
import com.example.nasaapp.ui.adapters.NewMarsPhotoAdapter

class FragmentNewMarsPhoto : Fragment() {

    lateinit var adapter: NewMarsPhotoAdapter
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
        super.onViewCreated(view, savedInstanceState)
    }

private fun setVerticalRecyclerView(){
    adapter = NewMarsPhotoAdapter()
    binding.vertRecyclerView.adapter = adapter
}

    companion object {
        @JvmStatic
        fun newInstance() = FragmentNewMarsPhoto()
    }
}