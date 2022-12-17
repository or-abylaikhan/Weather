package com.example.weather.data.network.geo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoService {
    @GET("v1/search")
    fun searchForCityByName(@Query("name") cityName: String): Call<CityResultsDto>
}