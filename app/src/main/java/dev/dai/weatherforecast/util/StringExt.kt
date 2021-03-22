package dev.dai.weatherforecast.util

fun String.toWeatherIconUrl(): String =
    "https://openweathermap.org/img/wn/$this@2x.png"