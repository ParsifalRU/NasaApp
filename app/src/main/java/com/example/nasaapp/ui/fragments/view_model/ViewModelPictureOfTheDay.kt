package com.example.nasaapp.ui.fragments.view_model

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasaapp.network.api.retrofitCreated
import com.example.nasaapp.ui.fragments.fragment.FragmentPictureOfTheDay
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModelPictureOfTheDay() : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    var livedata = MutableLiveData<String>()

    init {
        getMarsPhotos()
    }

    fun getMarsPhotos() {

            retrofitCreated.getPhotos()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    val response = it  to arrayOf(String)
                    Log.d("TAG", "getMarsPhoto ${response.first[0].url}")

                        val bundle = Bundle()
                        bundle.putString("url", response.first[0].url)
                        FragmentPictureOfTheDay.newInstance(arg1 = bundle)
                        livedata.value = response.first[0].url

                }, {
                    Log.d("TAG", "Exception GetMarsPhoto ${livedata.value} ")

                }
                )




    }

}
