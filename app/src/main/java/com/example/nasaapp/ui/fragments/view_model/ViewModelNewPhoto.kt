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
                    livedata.value = response.first.toString()

                    /*val bundle = Bundle()
                    bundle.putString("url", response.first[0].imageSrc)
                    FragmentPictureOfTheDay.newInstance(arg1 = bundle)
                    livedata.value = response.first[0].imageSrc*/

                }, {
                    Log.d("TAG", "Exception getNewPhoto ${livedata.value} ")
                })


            }

}
