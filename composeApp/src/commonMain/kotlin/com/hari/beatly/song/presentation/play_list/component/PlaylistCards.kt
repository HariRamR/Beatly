package com.hari.beatly.song.presentation.play_list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import beatly.composeapp.generated.resources.Res
import beatly.composeapp.generated.resources.error_cover
import beatly.composeapp.generated.resources.play_icon
import coil3.compose.rememberAsyncImagePainter
import com.hari.beatly.core.presentation.PrimaryColor
import com.hari.beatly.song.data.PlaylistModel
import com.hari.beatly.song.data.SongModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun PlaylistCards(
    playLists: List<PlaylistModel>,
    onPlayButtonClicked: (SongModel) -> Unit,
    scrollState: LazyListState = rememberLazyListState(),
) {
    LazyRow(
        state = scrollState,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(playLists, key = { it.id }) { playList ->
            BoxWithConstraints (
                modifier =
                    Modifier.background(
                        shape = RoundedCornerShape(20.dp),
                        color = PrimaryColor,
                    ),
            ) {
                Box(modifier = Modifier.height(((maxHeight * 40) / 100)).width(((maxHeight * 70) / 100))) {
                    var coverImageLoadResult by remember {
                        mutableStateOf<Result<Painter>?>(null)
                    }
                    val painter =
                        rememberAsyncImagePainter(
                            model = playList.coverURL,
                            onSuccess = {
                                if (it.painter.intrinsicSize.width > 1 && it.painter.intrinsicSize.height > 1) {
                                    Result.success(it)
                                } else {
                                    Result.failure(Exception("Invalid image size"))
                                }
                            },
                            onError = {
                                coverImageLoadResult = Result.failure(it.result.throwable)
                            },
                        )
                    when (val result = coverImageLoadResult) {
                        null -> CircularProgressIndicator()
                        else -> {
                            Image(
                                painter =
                                if (result.isSuccess) {
                                    painter
                                } else {
                                    painterResource(
                                        Res.drawable.error_cover,
                                    )
                                },
                                contentDescription = playList.name,
                                contentScale = if (result.isSuccess) ContentScale.Crop else ContentScale.Fit,
                                modifier =
                                Modifier.aspectRatio(
                                    0.65f,
                                    matchHeightConstraintsFirst = true,
                                ),
                            )
                        }
                    }
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = playList.name,
                            style = MaterialTheme.typography.headlineLarge,
                            modifier = Modifier.background(color = Color.White),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Box(
                            modifier =
                            Modifier
                                .background(shape = CircleShape, color = PrimaryColor)
                                .padding(10.dp),
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.play_icon),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(color = Color.White),
                                modifier = Modifier.clickable { onPlayButtonClicked(playList.songs.first()) },
                            )
                        }
                    }
                }
            }
        }
    }
}
