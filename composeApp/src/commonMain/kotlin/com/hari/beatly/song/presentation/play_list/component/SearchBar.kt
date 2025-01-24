package com.hari.beatly.song.presentation.play_list.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import beatly.composeapp.generated.resources.Res
import beatly.composeapp.generated.resources.clear_search
import beatly.composeapp.generated.resources.ic_search
import beatly.composeapp.generated.resources.search_hint
import com.hari.beatly.core.presentation.SecondaryColor
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SearchBar(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    onIMEAction: () -> Unit,
    modifier: Modifier,
) {
    CompositionLocalProvider(
        LocalTextSelectionColors provides TextSelectionColors(
            handleColor = Color.White,
            backgroundColor = Color.White.copy(alpha = 0.4f),
        )
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChanged,
            shape = RoundedCornerShape(100.dp),
            colors =
            OutlinedTextFieldDefaults.colors(
//                focusedBorderColor = SandYellow,
                cursorColor = Color.White,
            ),
            placeholder = {
                Text(text = stringResource(Res.string.search_hint))
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(Res.drawable.ic_search),
                    contentDescription = null,
                )
            },
            trailingIcon = {
                AnimatedVisibility(
                    visible = searchQuery.isNotBlank(),
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(Res.string.clear_search),
                        tint = MaterialTheme.colorScheme.onSurface,
                    )
                }
            },
            singleLine = true,
            keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search,
            ),
            keyboardActions =
            KeyboardActions(
                onSearch = {
                    onIMEAction()
                },
            ),
            modifier = modifier.background(
                color = SecondaryColor,
                shape = RoundedCornerShape(100.dp),
            ).minimumInteractiveComponentSize()
        )
    }
}
