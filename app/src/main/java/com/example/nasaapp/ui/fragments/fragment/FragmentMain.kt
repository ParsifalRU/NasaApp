package com.example.nasaapp.ui.fragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import com.example.nasaapp.databinding.FragmentMainBinding
import com.example.nasaapp.ui.fragments.view_model.ViewModelNewPhoto
import com.example.nasaapp.ui.fragments.view_model.ViewModelPictureOfTheDay


class FragmentMain : Fragment() {
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)


        ViewModelPictureOfTheDay().viewModelScope
        ViewModelNewPhoto().viewModelScope

        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = FragmentMain()
    }
}