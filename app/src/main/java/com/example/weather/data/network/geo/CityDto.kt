package com.example.weather.data.network.geo

import com.squareup.moshi.Json

data class CityDto(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "latitude") val latitude: Double,
    @field:Json(name = "longitude") val longitude: Double,
    @field:Json(name = "country") val country: String,
    @field:Json(name = "country_code") val countryCode: String
)