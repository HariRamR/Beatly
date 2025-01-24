package com.hari.beatly.song.presentation.play_list

import com.hari.beatly.song.data.SongModel

sealed interface PlaylistAction {
    data class OnSearchQueryChanged(val query: String): PlaylistAction
    data class OnPlaySelected(val songModel: SongModel): PlaylistAction
}