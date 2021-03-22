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
    val weatherName: String,
    val dateString: String,
    val weatherIconId: String,
    val maximumTemperature: Int,
    val minimumTemperature: Int
)

val weatherForecastItems = listOf(
    WeatherForecast(
        weatherName = "Clear",
        dateString = "3/22 Monday",
        weatherIconId = "01d",
        maximumTemperature = 19,
        minimumTemperature = 10
    ),
    WeatherForecast(
        weatherName = "Clouds",
        dateString = "3/23 Tuesday",
        weatherIconId = "02d",
        maximumTemperature = 20,
        minimumTemperature = 10
    ),
    WeatherForecast(
        weatherName = "Clouds",
        dateString = "3/24 Wednesday",
        weatherIconId = "03d",
        maximumTemperature = 13,
        minimumTemperature = 10
    ),
    WeatherForecast(
        weatherName = "Clouds",
        dateString = "3/25 Thursday",
        weatherIconId = "04d",
        maximumTemperature = 15,
        minimumTemperature = 12
    ),
    WeatherForecast(
        weatherName = "Drizzle",
        dateString = "3/26 Friday",
        weatherIconId = "09d",
        maximumTemperature = 10,
        minimumTemperature = 5
    ),
    WeatherForecast(
        weatherName = "Rain",
        dateString = "3/27 Saturday",
        weatherIconId = "10d",
        maximumTemperature = 10,
        minimumTemperature = 9
    ),
    WeatherForecast(
        weatherName = "Thunderstorm",
        dateString = "3/28 Sunday",
        weatherIconId = "11d",
        maximumTemperature = 5,
        minimumTemperature = 1
    )
)
