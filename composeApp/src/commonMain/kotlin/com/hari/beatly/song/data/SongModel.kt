package com.hari.beatly.song.data

data class SongModel(
    val id: String,
    val title: String,
    val description: String,
    val artist: String,
    val releaseYear: String,
    val genre: String,
    val duration: String,
    val lyrics: String,
    val songUrl: String,
    val coverUrl: String,
    val isFavorite: Boolean,
)

data class PlaylistModel(
    val id: String,
    val name: String,
    val description: String,
    val coverURL: String,
    val songs: List<SongModel>,
)
