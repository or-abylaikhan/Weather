package com.example.weather

import android.app.Application
import com.example.weather.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.Forest.plant


class WeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(dataModule)
            androidContext(this@WeatherApp)
            androidLogger()
        }
        if (BuildConfig.DEBUG) {
            plant(Timber.DebugTree())
        }
    }
}