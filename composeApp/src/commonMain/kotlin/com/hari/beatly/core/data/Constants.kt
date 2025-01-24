package com.hari.beatly.core.data

import com.hari.beatly.song.data.PlaylistModel
import com.hari.beatly.song.data.SongModel

object Constants {
    val PLAYLIST_1 =
        PlaylistModel(
            id = "1",
            name = "Pop",
            coverURL = "https://i.pinimg.com/originals/1d/67/86/1d67862d37e65d7b6a3b626b0d14ce04.jpg",
            description = "Pop songs",
            songs =
                listOf(
                    SongModel(
                        id = "1",
                        title = "Song 1",
                        description = "Description 1",
                        releaseYear = "14 Jan 2024",
                        genre = "Pop",
                        artist = "Artist 1",
                        duration = "3:45",
                        lyrics = "Lyrics 1",
                        coverUrl = "https://images.unsplash.com/photo-1542281286-9e0a16",
                        songUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
                        isFavorite = false,
                    ),
                ),
        )
    val PLAYLIST_2 =
        PlaylistModel(
            id = "2",
            name = "Rock",
            coverURL = "https://flypaper.soundfly.com/wp-content/uploads/2016/10/metal-covers-header-1024x683.png",
            description = "Rock songs",
            songs =
            listOf(
                SongModel(
                    id = "1",
                    title = "Song 1",
                    description = "Description 2",
                    releaseYear = "14 Feb 2024",
                    genre = "Rock",
                    artist = "Artist 2",
                    duration = "3:45",
                    lyrics = "Lyrics 2",
                    coverUrl = "https://images.unsplash.com/photo-1542281286-9e0a16",
                    songUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
                    isFavorite = false,
                ),
            ),
        )
    val PLAYLIST_3 =
        PlaylistModel(
            id = "3",
            name = "Jazz",
            coverURL = "https://i.pinimg.com/originals/08/3c/77/083c7736d964c1fbb123576d19b3b604.jpg",
            description = "Jazz songs",
            songs =
            listOf(
                SongModel(
                    id = "1",
                    title = "Song 3",
                    description = "Description 3",
                    releaseYear = "14 Mar 2024",
                    genre = "Jazz",
                    artist = "Artist 3",
                    duration = "3:45",
                    lyrics = "Lyrics 3",
                    coverUrl = "https://images.unsplash.com/photo-1542281286-9e0a16",
                    songUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
                    isFavorite = false,
                ),
            ),
        )
}
