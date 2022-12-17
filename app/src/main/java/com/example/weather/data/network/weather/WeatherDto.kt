package com.example.weather.data.network.weather

import com.squareup.moshi.Json

data class WeatherDto(@field:Json(name = "hourly") val hourly: HourlyWeatherDto)