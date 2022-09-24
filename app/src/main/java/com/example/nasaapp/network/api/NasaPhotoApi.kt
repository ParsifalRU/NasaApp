package com.example.nasaapp.network.api

import com.example.nasaapp.network.models.ModelPictOfTheDay
import com.example.nasaapp.network.models.RoverModel
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

    private const val API_KEY = "TZIMZYEFae7yfl8BNaoYsogFD8e88WTx0dSaWvxi"
    private const val BASE_ROVER = "mars-photos/api/v1/rovers/"

    private const val PICTURE_OF_DAY = "planetary/apod"

    private const val CURIOSITY_ROVER = BASE_ROVER + "curiosity/photos"
    private const val OPPORTUNITY_ROVER = BASE_ROVER + "opportunity/photos"
    private const val SPIRIT_ROVER = BASE_ROVER + "spirit/photos"


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

    @GET(PICTURE_OF_DAY)
    fun getPhotos(

        @Query("api_key")
        ApiKey :String = API_KEY,

        @Query("start_date")
        StartDate : String = dateText

    ) : Observable<List<ModelPictOfTheDay>>

    @GET(CURIOSITY_ROVER)
    fun getCuriosityMarsPhotosFromMarsSol(
        @Query("page")
        page: Int = 1,

        @Query("sol")
        sol: Int = 1000,

        @Query("camera")
        camera: String = "FHAZ",

        @Query("api_key")
        APIKey: String = API_KEY
    ): Observable<List<RoverModel>>

    @GET(CURIOSITY_ROVER)
    fun getCuriosityMarsPhotosFromEarthDate(
        @Query("page")
        page: Int = 1,

        @Query("earth_date")
        earthDate: String = "2006-11-17",

        @Query("camera")
        camera: String = "FHAZ",

        @Query("api_key")
        APIKey: String = API_KEY
    ): Observable<List<RoverModel>>


    @GET(OPPORTUNITY_ROVER)
    fun getOpportunityMarsPhotosFromEarthDate(
        @Query("page")
        page: Int = 1,

        @Query("earth_date")
        earthDate: String = "2006-11-17",

        @Query("camera")
        camera: String = "FHAZ",

        @Query("api_key")
        APIKey: String = API_KEY
    ): Observable<List<RoverModel>>

    @GET(OPPORTUNITY_ROVER)
    fun getOpportunityMarsPhotosFromMarsSol(
        @Query("page")
        page: Int = 1,

        @Query("sol")
        sol: Int = 1000,

        @Query("camera")
        camera: String = "FHAZ",

        @Query("api_key")
        APIKey: String = API_KEY
    ): Observable<List<RoverModel>>

    @GET(SPIRIT_ROVER)
    fun getSpiritMarsPhotosFromMarsSol(
        @Query("page")
        page: Int = 1,

        @Query("sol")
        sol: Int = 1000,

        @Query("camera")
        camera: String = "FHAZ",

        @Query("api_key")
        APIKey: String = API_KEY
    ): Observable<List<RoverModel>>

    @GET(SPIRIT_ROVER)
    fun getSpiritMarsPhotosFromEarthDate(
        @Query("sol")
        sol: Int = 1000,

        @Query("page")
        page: Int = 1,

        @Query("earth_date")
        earthDate: String = "2015-06-03",

        @Query("camera")
        camera: String = "FHAZ",

        @Query("api_key")
        APIKey: String = API_KEY
    ): Observable<List<RoverModel>>

    @GET(SPIRIT_ROVER)
    fun getSpiritMarsPhotosFromEarthDate(
        @Query("page")
        page: Int = 1,

        @Query("earth_date")
        earthDate: String = "2006-11-17",

        @Query("camera")
        camera: String = "FHAZ",

        @Query("api_key")
        APIKey: String = API_KEY
    ): Observable<List<RoverModel>>

    @GET(CURIOSITY_ROVER)
    fun getLastMarsPhotos(
        @Query("page")
        page: Int = 1,

        @Query("sol")
        sol: Int = 1000,

        @Query("api_key")
        APIKey: String = API_KEY
    ): Observable<List<RoverModel>>

}



