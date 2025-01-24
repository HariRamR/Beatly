package com.hari.beatly

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hari.beatly.song.presentation.play_list.PlaylistScreenRoot
import com.hari.beatly.song.presentation.play_list.PlaylistVM
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.currentKoinScope
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {
    KoinContext {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "playlist",
        ) {
            composable(route = "playlist") {
                val playlistVM = koinViewModel<PlaylistVM>()
                PlaylistScreenRoot(
                    playlistVM,
                    onSongClicked = {
                    },
                    modifier = Modifier.fillMaxHeight(1f),
                )
            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}
