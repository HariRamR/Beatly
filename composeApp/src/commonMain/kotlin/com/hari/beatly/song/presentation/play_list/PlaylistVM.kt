package com.hari.beatly.song.presentation.play_list

import androidx.lifecycle.ViewModel
import com.hari.beatly.song.data.SongModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PlaylistVM: ViewModel() {
    private val _state = MutableStateFlow(PlaylistState())
    val state = _state.asStateFlow()

    private val _selectedSong = MutableStateFlow<SongModel?>(null)
    val selectedSong = _selectedSong.asStateFlow()

    fun onAction(action: PlaylistAction) {
        when(action) {
            is PlaylistAction.OnSearchQueryChanged -> {
                _state.update {
                    it.copy(searchQuery = action.query)
                }
            }
            is PlaylistAction.OnPlaySelected -> {

            }
        }
    }

    fun onPlayListPlayClicked(song: SongModel) {
        _selectedSong.value = song
    }
}