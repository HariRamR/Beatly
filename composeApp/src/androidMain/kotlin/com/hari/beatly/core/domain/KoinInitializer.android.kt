package com.hari.beatly.core.domain

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

actual class KoinInitializer(val context: Context) {
    actual fun init() {
        startKoin() {
            androidContext(context)
            androidLogger(level = Level.ERROR)
            modules(AppModule().module, viewModelModule)
        }
    }
}