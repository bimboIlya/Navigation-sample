package com.example.navigationsample

import android.app.Application
import com.example.navigationsample.di.navModule
import com.example.navigationsample.di.vmModule
import com.example.navigationsample.ui.createNotificationChannel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        initTimber()
        initKoin()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(navModule, vmModule)
        }
    }
}