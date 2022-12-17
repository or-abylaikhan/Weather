package com.example.weather.data.network.weather

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface WeatherService {
    @GET("v1/forecast?hourly=temperature_2m,relativehumidity_2m,weathercode,pressure_msl,windspeed_10m")
    fun getWeatherForecast(lat: Double, long: Double): ApiResponse<WeatherDto>
}