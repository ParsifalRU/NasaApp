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

    private fun getNewPhotos() {

        retrofitCreated.let {

            retrofitCreated.getLastMarsPhotos()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    Log.d("TAG", "GetNewPhoto new data1 $it")
                    val response = it.size to arrayOf(String)
                    Log.d("TAG", "getNewPhoto ${response.first}")
                    livedata.value = it.count().toString()

                    /*val bundle = Bundle()
                    bundle.putString("url", response.first[0].imageSrc)
                    FragmentPictureOfTheDay.newInstance(arg1 = bundle)
                    livedata.value = response.first[0].imageSrc*/


                    /* downloadImage(dt.first[0].url, bindings.imageView)*/
                }, {
                    Log.d("TAG", "Exception getNewPhoto ${livedata.value} ")

                })

        }
    }
}