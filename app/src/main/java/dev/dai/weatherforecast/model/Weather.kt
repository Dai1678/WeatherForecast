package dev.dai.weatherforecast.model

data class Weather(
    val weatherName: String,
    val temperature: Int,
    val weatherIconId: String,
    val place: String,
    val city: String
)

val weather = Weather(
    weatherName = "Clouds",
    temperature = 18,
    weatherIconId = "02d",
    place = "Tokyo",
    city = "Shibuya"
)
