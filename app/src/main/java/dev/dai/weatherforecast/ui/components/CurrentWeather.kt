package dev.dai.weatherforecast.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.CoilImage
import dev.dai.weatherforecast.model.Weather
import dev.dai.weatherforecast.model.weather
import dev.dai.weatherforecast.util.toWeatherIconUrl

@Composable
fun CurrentWeather(weather: Weather, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CoilImage(
            data = weather.weatherIconId.toWeatherIconUrl(),
            contentDescription = "current weather icon",
            fadeIn = true,
            modifier = Modifier.size(62.dp)
        )
        Column {
            Text(
                text = weather.weatherName,
                color = Color.White,
                style = MaterialTheme.typography.h5
            )
            Text(
                text = "${weather.temperature}℃",
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}

@Preview
@Composable
fun CurrentWeatherPreview() {
    Surface(color = Color.Black) {
        CurrentWeather(weather)
    }
}
