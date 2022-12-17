package com.example.weather.data.network.air

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface AirQualityService {
    @GET("v1/air-quality?hourly=pm10")
    fun getAirQuality(lat: Double, long: Double): ApiResponse<AirQualityDto>
}