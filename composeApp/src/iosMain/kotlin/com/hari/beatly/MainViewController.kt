package com.hari.beatly

import androidx.compose.ui.window.ComposeUIViewController
import com.hari.beatly.core.domain.KoinInitializer

fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
) { App() }