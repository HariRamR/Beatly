package com.hari.beatly.song.presentation.play_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import beatly.composeapp.generated.resources.Res
import beatly.composeapp.generated.resources.discover
import beatly.composeapp.generated.resources.playlist_icon
import beatly.composeapp.generated.resources.your_playlist
import com.hari.beatly.core.data.Constants
import com.hari.beatly.core.presentation.LiteYellow
import com.hari.beatly.core.presentation.PrimaryColor
import com.hari.beatly.song.data.SongModel
import com.hari.beatly.song.presentation.play_list.component.PlaylistCards
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PlaylistScreenRoot(
    viewModel: PlaylistVM = koinViewModel(),
    onSongClicked: (SongModel) -> Unit,
    modifier: Modifier,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    PlaylistScreen(
        state,
        onAction = { action ->
            when (action) {
                is PlaylistAction.OnPlaySelected -> onSongClicked(action.songModel)
                else -> Unit
            }
            viewModel.onAction(action)
        },
        modifier,
    )
}

@Composable
private fun PlaylistScreen(
    state: PlaylistState,
    onAction: (PlaylistAction) -> Unit,
    modifier: Modifier,
    scrollState: LazyListState = rememberLazyListState(),
) {
    BoxWithConstraints(
        modifier = modifier.fillMaxWidth(1f).fillMaxHeight(1f).background(color = PrimaryColor),
    ) {
        val maxHeight = maxHeight
        Box(
            modifier =
                Modifier
                    .fillMaxWidth(1f)
                    .background(
                        shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp),
                        color = LiteYellow,
                    ).height((maxHeight * 40) / 100),
        ) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth(1f)
                        .padding(horizontal = 20.dp)
                        .padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = stringResource(Res.string.discover),
                    style = MaterialTheme.typography.headlineLarge,
                    color = PrimaryColor,
                )
                Box(
                    modifier =
                        Modifier
                            .background(shape = CircleShape, color = PrimaryColor)
                            .padding(10.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }
            Row(
                modifier =
                    Modifier
                        .rotate(-90f)
//                        .padding(start = 20.dp, top = ((maxHeight * 20) / 100)),
            ) {
                Text(
                    text = stringResource(Res.string.your_playlist),
                    style = TextStyle(

                    ),
//                    style = MaterialTheme.typography.titleMedium,
                    color = PrimaryColor,
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(Res.drawable.playlist_icon),
                    contentDescription = null,
                )
            }
        }
        Row(modifier = Modifier.padding(top = ((maxHeight * 20) / 100))) {
            Spacer(modifier = Modifier.width(70.dp))
            PlaylistCards(
                playLists =
                    listOf(
                        Constants.PLAYLIST_1,
                        Constants.PLAYLIST_2,
                        Constants.PLAYLIST_3,
                    ),
                onPlayButtonClicked = { onAction(PlaylistAction.OnPlaySelected(it)) },
                scrollState = scrollState,
            )
        }
    }
}
