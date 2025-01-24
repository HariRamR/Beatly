package com.hari.beatly.core.domain

import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(AppModule().module, viewModelModule)
        }
    }
}