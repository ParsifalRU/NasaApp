package com.example.nasaapp.network.api

import com.example.nasaapp.ui.picture_of_the_day.model.ModelPictOfTheDay
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

    val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/")
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitCreated: NasaPhotoApi = retrofit.create(NasaPhotoApi::class.java)

    val currentDate: Date = Date()
    val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val dateText: String = dateFormat.format(currentDate)

interface NasaPhotoApi {

    @GET("planetary/apod")
    fun getPhotos(

        @Query("api_key")
        ApiKey :String = "TZIMZYEFae7yfl8BNaoYsogFD8e88WTx0dSaWvxi",

        @Query("start_date")
        StartDate : String = dateText

    ) : Observable<List<ModelPictOfTheDay>>
}
