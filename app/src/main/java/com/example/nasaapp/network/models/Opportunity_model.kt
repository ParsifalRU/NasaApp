package model_opportunity

data class Opportunity_model(

    val id: Int = 0,
    val solDate: Int = 1000,
    val cameraVO: CameraVO = CameraVO(),
    val imageSrc: String = "",
    val earthDate: String = "2020-12-15",
    val rover: RoverVO

)
data class RoverVO(

    val id: Int = 0,
    val name: String = "Curiosity",
    val landingDate: String = "11.02.2002",
    val launchDate: String = "11.02.2002",
    val status: String = "Active"
)

data class CameraVO(

    val id: Int = 0,
    val name: String = "FHAZ",
    val fullName: String = "Front Hazard Avoidance Camera"
)