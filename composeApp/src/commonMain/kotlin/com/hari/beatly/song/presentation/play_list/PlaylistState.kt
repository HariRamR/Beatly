package com.hari.beatly.song.presentation.play_list

import com.hari.beatly.song.data.SongModel
import com.plcoding.bookpedia.core.presentation.UiText

data class PlaylistState(
    val searchQuery: String = "",
    val searchResult: List<SongModel> = emptyList(),
    val favoriteSongs: List<SongModel> = emptyList(),
    val isLoading: Boolean = false,
    val errorMsg: UiText? = null
)
