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
package dev.dai.weatherforecast

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dai.weatherforecast.model.weather
import dev.dai.weatherforecast.model.weatherForecastItems
import dev.dai.weatherforecast.ui.components.CurrentWeather
import dev.dai.weatherforecast.ui.components.WeatherForecastList
import dev.dai.weatherforecast.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val isLightTheme = MaterialTheme.colors.isLight
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Box(modifier = Modifier.weight(1f)) {
                Image(
                    painter = painterResource(id = R.drawable.shibuya),
                    contentDescription = "current place's image",
                    contentScale = ContentScale.Crop,
                    alpha = if (isLightTheme) 1f else 0.8f,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                )
                CurrentWeather(weather, modifier = Modifier.align(Alignment.TopStart))
                Column(
                    Modifier
                        .padding(start = 16.dp, bottom = 16.dp)
                        .align(Alignment.BottomStart),
                ) {
                    Text(
                        text = "Tokyo",
                        color = Color.White,
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = "Shibuya",
                        color = Color.White,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
            WeatherForecastList(weatherForecastItems, modifier = Modifier.weight(1f))
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
