package com.example.weather.di

import android.content.Context
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { createLocationService(androidContext()) }
}

private fun createLocationService(appContext: Context) =
    LocationServices.getFusedLocationProviderClient(appContext)