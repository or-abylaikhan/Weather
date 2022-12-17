package com.example.weather.data.network.air

import com.squareup.moshi.Json

data class HourlyAirQualityDto(
    @field:Json(name = "time") val time: List<String>,
    @field:Json(name = "pm10") val pm10: List<Int>
)