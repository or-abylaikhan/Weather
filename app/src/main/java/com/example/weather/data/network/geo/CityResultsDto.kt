package com.example.weather.data.network.geo

import com.squareup.moshi.Json

data class CityResultsDto(@field:Json(name = "results") val results: List<CityDto>?)