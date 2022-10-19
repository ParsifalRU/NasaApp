package com.example.nasaapp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nasaapp.R
import com.example.nasaapp.ui.fragments.fragment.FragmentMain
import com.example.nasaapp.ui.fragments.view_model.ViewModelNewPhoto
import com.example.nasaapp.ui.fragments.view_model.ViewModelPictureOfTheDay


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager.beginTransaction()

        fragmentManager.add(R.id.fragment1, FragmentMain())
        fragmentManager.commit()

        ViewModelNewPhoto()
        ViewModelPictureOfTheDay()

        hideActionBar()
    }

    fun hideActionBar(){
        supportActionBar?.hide()
    }

}