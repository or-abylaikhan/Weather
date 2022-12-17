package com.example.weather.data.network.air

import retrofit2.Call
import retrofit2.http.GET

interface AirQualityService {
    @GET("v1/air-quality?hourly=pm10")
    fun getAirQuality(lat: Double, long: Double): Call<AirQualityDto>
}