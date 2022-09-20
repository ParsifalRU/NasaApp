package com.example.nasaapp.ui.picture_of_the_day.view_model

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasaapp.network.api.retrofitCreated
import com.example.nasaapp.ui.picture_of_the_day.fragment.FragmentPictureOfTheDay
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModelPictureOfTheDay() : ViewModel() {

    val t = Log.d("TAG", "ViewModel.Start")
    var livedata = MutableLiveData<String>()

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {

        retrofitCreated.let {
        Log.d("TAG", "getMarsPhoto")

            retrofitCreated.getPhotos()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    Log.d("TAG", "new data1 $it")
                    val response = it  to arrayOf(String)
                    Log.d("TAG", "new data1 ${response.first[0].url}")

                        val bundle = Bundle()
                        bundle.putString("url", response.first[0].url)
                        FragmentPictureOfTheDay.newInstance(arg1 = bundle)
                    livedata.value = response.first[0].url


                    /* downloadImage(dt.first[0].url, bindings.imageView)*/
                }, {
                    Log.d("TAG", "new data2 ${livedata.value} ")

                })

        }
    }


}
