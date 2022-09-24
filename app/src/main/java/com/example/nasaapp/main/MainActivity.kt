package com.example.nasaapp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.nasaapp.ui.fragments.fragment.FragmentMain


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.nasaapp.R.layout.activity_main)


        val frag2: Fragment = FragmentMain()
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(com.example.nasaapp.R.id.fragment1, frag2)
        ft.commit()

       /* hideActionBar()*/

}

    fun hideActionBar(){
        supportActionBar?.hide()
    }

}