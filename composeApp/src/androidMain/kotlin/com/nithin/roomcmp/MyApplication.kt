package com.nithin.roomcmp

import android.app.Application
import com.nithin.roomcmp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.koinApplication

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MyApplication)
        }
    }

}