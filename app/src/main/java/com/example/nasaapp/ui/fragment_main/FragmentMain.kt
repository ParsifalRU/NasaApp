package com.example.nasaapp.ui.fragment_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import com.example.nasaapp.databinding.FragmentMainBinding
import com.example.nasaapp.ui.picture_of_the_day.view_model.ViewModelPictureOfTheDay


class FragmentMain : Fragment() {
    lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        ViewModelPictureOfTheDay().viewModelScope
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMain()
    }
}