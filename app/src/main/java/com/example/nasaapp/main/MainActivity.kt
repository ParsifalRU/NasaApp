package com.example.nasaapp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nasaapp.ui.fragments.view_model.ViewModelNewPhoto
import com.example.nasaapp.ui.fragments.view_model.ViewModelPictureOfTheDay


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.nasaapp.R.layout.activity_main)

        ViewModelNewPhoto()
        ViewModelPictureOfTheDay()

        hideActionBar()
    }

    fun hideActionBar(){
        supportActionBar?.hide()
    }

}