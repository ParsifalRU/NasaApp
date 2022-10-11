package com.example.nasaapp.ui.fragments.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasaapp.network.api.retrofitCreated
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModelNewPhoto: ViewModel() {

   var livedata = MutableLiveData<String>()

   init {
        getNewPhotos()
    }

   fun getNewPhotos() {
            retrofitCreated.getLastMarsPhotos()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    val response = it to arrayOf(String)
                    Log.d("TAG", " getNewPhoto ${response.toString()}")
                    livedata.value = response.first.photos[0].id.toString()

                }, {
                    Log.e("Tag", it.message.toString())
                    Log.d("TAG", "Exception getNewPhoto ${livedata.value}")
                }
                )
            }
}
