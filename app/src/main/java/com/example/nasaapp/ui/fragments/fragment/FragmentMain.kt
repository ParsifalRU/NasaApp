package com.example.nasaapp.ui.fragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nasaapp.databinding.FragmentMainBinding


class FragmentMain : Fragment() {
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

/*        val fragPictOfTheDay = FragmentPictureOfTheDay()
        val fragNewMarsPhoto = FragmentNewMarsPhoto()
        val fragFavoritePhoto = FragmentFavoritePhoto()
        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.fragment_picture_of_the_day, fragPictOfTheDay)?.commit()
        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.favorite_mars_photo, fragFavoritePhoto)
        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.new_mars_photo, fragNewMarsPhoto)*/

        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = FragmentMain()
    }
}