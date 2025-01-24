package com.hari.beatly.core.domain

import android.app.Application

class BaseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}