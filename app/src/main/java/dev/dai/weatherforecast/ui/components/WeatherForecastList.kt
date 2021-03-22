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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.toPaddingValues
import dev.dai.weatherforecast.model.WeatherForecast
import dev.dai.weatherforecast.model.weatherForecastItems
import dev.dai.weatherforecast.util.toWeatherIconUrl

@Composable
fun WeatherForecastList(
    weatherForecastList: List<WeatherForecast>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding =
            LocalWindowInsets.current.navigationBars.toPaddingValues()
    ) {
        items(weatherForecastList) { item ->
            WeatherForecastItem(item)
        }
    }
}

@Composable
private fun WeatherForecastItem(weatherForecast: WeatherForecast) {
    Row(
        Modifier
            .clickable { }
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CoilImage(
            data = weatherForecast.weatherIconId.toWeatherIconUrl(),
            contentDescription = "weather icon",
            fadeIn = true,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = weatherForecast.dateString,
                style = MaterialTheme.typography.body1
            )
            Text(
                text = weatherForecast.weatherName,
                style = MaterialTheme.typography.caption
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "${weatherForecast.maximumTemperature}℃",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "${weatherForecast.minimumTemperature}℃",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.alpha(0.5f)
        )
    }
}

@Preview
@Composable
fun WeatherForecastListPreview() {
    Surface {
        WeatherForecastList(weatherForecastItems)
    }
}

@Preview
@Composable
fun WeatherForecastItemPreview() {
    Surface {
        WeatherForecastItem(weatherForecastItems.first())
    }
}
