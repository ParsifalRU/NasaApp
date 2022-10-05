package com.example.nasaapp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.viewModelScope
import com.example.nasaapp.ui.fragments.fragment.FragmentMain
import com.example.nasaapp.ui.fragments.view_model.ViewModelNewPhoto
import com.example.nasaapp.ui.fragments.view_model.ViewModelPictureOfTheDay


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.nasaapp.R.layout.activity_main)

        val frag2: Fragment = FragmentMain()
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(com.example.nasaapp.R.id.fragment1, frag2)
        ft.commit()

        ViewModelPictureOfTheDay().viewModelScope
        ViewModelNewPhoto().viewModelScope

       hideActionBar()

}

    fun hideActionBar(){
        supportActionBar?.hide()
    }

}