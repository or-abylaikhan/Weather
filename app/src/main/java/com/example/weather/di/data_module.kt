package com.example.weather.di

import android.content.Context
import com.example.weather.BuildConfig
import com.example.weather.data.network.WeatherApi
import com.example.weather.util.Constants.NETWORK_TIME_OUT
import com.example.weather.util.Constants.WEATHER_API_BASE_URL
import com.google.android.gms.location.LocationServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

val dataModule = module {
    single { createLocationService(androidContext()) }
    single { createWeatherApi(get()) }
    single { createRetrofit((get())) }
    single { createHttpClient(get()) }
    single { createLoggingInterceptor() }
}

private fun createLocationService(appContext: Context) =
    LocationServices.getFusedLocationProviderClient(appContext)

private fun createWeatherApi(retrofit: Retrofit) = retrofit.create(WeatherApi::class.java)

private fun createRetrofit(httpClient: OkHttpClient) =
    Retrofit.Builder().apply {
        baseUrl(WEATHER_API_BASE_URL)
        client(httpClient)
        addConverterFactory(MoshiConverterFactory.create())
    }.build()

private fun createHttpClient(loggingInterceptor: HttpLoggingInterceptor) =
    OkHttpClient.Builder().apply {
        connectTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
        readTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
        writeTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) addInterceptor(loggingInterceptor)
    }.build()

private fun createLoggingInterceptor() =
    HttpLoggingInterceptor { message -> Timber.tag("OkHttp").d(message) }