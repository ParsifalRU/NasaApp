package com.example.nasaapp.ui.fragments.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasaapp.network.api.retrofitCreated
import com.example.nasaapp.ui.adapters.NewMarsPhotoAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModelNewPhoto: ViewModel() {

   var livedata = MutableLiveData<String>()
  /* lateinit var response2: PhotosVO*/

    init {
        getNewPhotos()
    }

   fun getNewPhotos() {
            retrofitCreated.getLastMarsPhotos()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    val response = it to arrayOf(String)

                    Log.d("TAG", " getNewPhoto ${response}")
                    livedata.value = response.toString()
                    Log.d("TAG", " getNewPhoto ${response.first.photos.component1()}")

                    NewMarsPhotoAdapter().takeResponse2(it)

                }, {
                    Log.e("Tag", it.message.toString())
                    Log.d("TAG", "Exception getNewPhoto ${livedata.value}")
                }
                )
   }
}
