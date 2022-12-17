package com.example.weather.data.network.geo

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoService {
    @GET("v1/search")
    fun searchForCityByName(@Query("name") cityName: String): Response<CityResultsDto>
}