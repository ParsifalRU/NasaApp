package com.example.nasaapp.ui.fragments.view_model

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasaapp.network.api.retrofitCreated
import com.example.nasaapp.ui.fragments.fragment.FragmentNewMarsPhoto
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.Serializable

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

                    Log.d("TAG", " getNewPhoto $it")

                    val bundle = Bundle()
                    bundle.putSerializable("List", it.photos as Serializable)
                    FragmentNewMarsPhoto.getNewInstance(bundle)


                    livedata.value = "READY"
                    Log.d("TAG", "livadata ${livedata.value}")


                }, {
                    Log.e("Tag2", it.message.toString())
                    Log.d("TAG2", "Exception getNewPhoto ${livedata.value}")
                }
                )
   }
}




