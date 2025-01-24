package com.hari.beatly.core.domain

import com.hari.beatly.song.presentation.play_list.PlaylistVM
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

actual val viewModelModule = module {
    viewModelOf(::PlaylistVM)
}