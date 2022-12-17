package com.example.weather.di

import com.example.weather.BuildConfig
import com.example.weather.data.network.air.AirQualityService
import com.example.weather.data.network.geo.GeoService
import com.example.weather.data.network.weather.WeatherService
import com.example.weather.util.Constants.AIR_QUALITY_API_BASE_URL
import com.example.weather.util.Constants.GEO_API_BASE_URL
import com.example.weather.util.Constants.NETWORK_TIME_OUT
import com.example.weather.util.Constants.WEATHER_API_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { createWeatherService(get()) }
    single { createAirQualityService(get()) }
    single { createGeoService(get()) }
    single { createRetrofitBuilder((get())) }
    single { createHttpClient(get()) }
    single { createLoggingInterceptor() }
}

private fun createWeatherService(retrofitBuilder: Retrofit.Builder) =
    retrofitBuilder.baseUrl(WEATHER_API_BASE_URL).build().create(WeatherService::class.java)

private fun createAirQualityService(retrofitBuilder: Retrofit.Builder) =
    retrofitBuilder.baseUrl(AIR_QUALITY_API_BASE_URL).build().create(AirQualityService::class.java)

private fun createGeoService(retrofitBuilder: Retrofit.Builder) =
    retrofitBuilder.baseUrl(GEO_API_BASE_URL).build().create(GeoService::class.java)

private fun createRetrofitBuilder(httpClient: OkHttpClient) =
    Retrofit.Builder().client(httpClient).addConverterFactory(MoshiConverterFactory.create())

private fun createHttpClient(loggingInterceptor: HttpLoggingInterceptor) =
    OkHttpClient.Builder().apply {
        connectTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
        readTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
        writeTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) addInterceptor(loggingInterceptor)
    }.build()

private fun createLoggingInterceptor() =
    HttpLoggingInterceptor { message -> Timber.tag("OkHttp").d(message) }.apply { level = BODY }