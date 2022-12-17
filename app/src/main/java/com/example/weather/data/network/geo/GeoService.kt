package com.example.weather.data.network.geo

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoService {
    @GET("v1/search")
    fun searchForCityByName(@Query("name") cityName: String): ApiResponse<CityResultsDto>
}