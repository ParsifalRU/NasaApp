package com.example.nasaapp.network.models

data class RoverModel(
    val id: Int,
    val sol: Int,
    val camera: List<CameraVO>,
    val img_src : String,
    val earth_date: String,
    val rover: List<RoverVO>

)
    data class RoverVO(

        val id: Int ,
        val name: String ,
        val landing_date: String ,
        val launch_date: String ,
        val status: String
    )

    data class CameraVO(
        val id: Int,
        val name: String ,
        val full_name: String
    )


