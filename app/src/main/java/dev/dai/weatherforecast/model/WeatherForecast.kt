/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.dai.weatherforecast.model

data class WeatherForecast(
    val dateString: String,
    val weatherIconId: String,
    val maximumTemperature: Int,
    val minimumTemperature: Int
) {
    fun getWeatherIconUrl(): String =
        "https://openweathermap.org/img/wn/$weatherIconId@2x.png"
}

val weatherForecastItems = listOf(
    WeatherForecast(
        dateString = "3/22 13:00",
        weatherIconId = "01d",
        maximumTemperature = 19,
        minimumTemperature = 10
    ),
    WeatherForecast(
        dateString = "3/23 13:00",
        weatherIconId = "02d",
        maximumTemperature = 20,
        minimumTemperature = 10
    ),
    WeatherForecast(
        dateString = "3/24 13:00",
        weatherIconId = "03d",
        maximumTemperature = 13,
        minimumTemperature = 10
    ),
    WeatherForecast(
        dateString = "3/25 13:00",
        weatherIconId = "04d",
        maximumTemperature = 15,
        minimumTemperature = 12
    ),
    WeatherForecast(
        dateString = "3/26 13:00",
        weatherIconId = "09d",
        maximumTemperature = 10,
        minimumTemperature = 5
    ),
    WeatherForecast(
        dateString = "3/27 13:00",
        weatherIconId = "10d",
        maximumTemperature = 10,
        minimumTemperature = 9
    ),
    WeatherForecast(
        dateString = "3/28 13:00",
        weatherIconId = "11d",
        maximumTemperature = 5,
        minimumTemperature = 1
    )
)
