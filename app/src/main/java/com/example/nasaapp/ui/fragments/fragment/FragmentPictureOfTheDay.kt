package com.example.nasaapp.ui.fragments.fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.nasaapp.R
import com.example.nasaapp.databinding.FragmentPictureOfTheDayBinding
import com.example.nasaapp.ui.fragments.view_model.ViewModelPictureOfTheDay


class FragmentPictureOfTheDay() : Fragment() {

    lateinit var binding: FragmentPictureOfTheDayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPictureOfTheDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewModelPictureOfTheDay().livedata.observe(viewLifecycleOwner, Observer {url -> downloadImage(url)})
    }

    private fun downloadImage(url:String){
            Glide
                .with(this)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageView)

    }

    companion object {
        fun newInstance(arg1: Bundle?): FragmentPictureOfTheDay {
            val pictureOfTheDay = FragmentPictureOfTheDay()
            pictureOfTheDay.arguments = arg1
            Log.d("TAG2","${pictureOfTheDay.arguments?.get("url")}")
            return pictureOfTheDay
        }
    }
}