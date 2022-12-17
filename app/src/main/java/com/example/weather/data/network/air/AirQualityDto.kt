package com.example.weather.data.network.air

import com.squareup.moshi.Json

data class AirQualityDto(@field:Json(name = "hourly") val hourlyAirQualityDto: HourlyAirQualityDto)