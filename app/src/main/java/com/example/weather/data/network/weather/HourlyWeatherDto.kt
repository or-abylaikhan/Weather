package com.example.weather.data.network.weather

import com.squareup.moshi.Json

data class HourlyWeatherDto(
    @field:Json(name = "time") val time: List<String>,
    @field:Json(name = "temperature_2m") val temperature: List<Double>,
    @field:Json(name = "relativehumidity_2m") val relativeHumidity: List<Int>,
    @field:Json(name = "weathercode") val weatherCode: List<Int>,
    @field:Json(name = "pressure_msl") val pressure: List<Double>,
    @field:Json(name = "windspeed_10m") val windSpeed: List<Double>
)