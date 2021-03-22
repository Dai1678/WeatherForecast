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
package dev.dai.weatherforecast.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import dev.dai.weatherforecast.R
import dev.dai.weatherforecast.model.Weather
import dev.dai.weatherforecast.util.toWeatherIconUrl

@Composable
fun WeatherImage(weather: Weather, modifier: Modifier = Modifier) {
    val isLightTheme = MaterialTheme.colors.isLight
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.shibuya),
            contentDescription = "current place's image",
            contentScale = ContentScale.Crop,
            alpha = if (isLightTheme) 1f else 0.8f,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
        )
        CurrentWeather(
            weatherName = weather.weatherName,
            weatherIconId = weather.weatherIconId,
            temperature = weather.temperature,
            modifier = Modifier.align(Alignment.TopStart).statusBarsPadding()
        )
        WeatherPlace(
            place = weather.place,
            city = weather.city,
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}

@Composable
fun CurrentWeather(
    weatherName: String,
    weatherIconId: String,
    temperature: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CoilImage(
            data = weatherIconId.toWeatherIconUrl(),
            contentDescription = "current weather icon",
            fadeIn = true,
            modifier = Modifier.size(62.dp)
        )
        Column {
            Text(
                text = weatherName,
                color = Color.White,
                style = MaterialTheme.typography.h5
            )
            Text(
                text = "$temperature℃",
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}

@Composable
fun WeatherPlace(place: String, city: String, modifier: Modifier = Modifier) {
    Column(modifier.padding(start = 16.dp, bottom = 16.dp)) {
        Text(
            text = place,
            color = Color.White,
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            Icon(
                imageVector = Icons.Default.Place,
                contentDescription = "place icon",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = city,
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}
