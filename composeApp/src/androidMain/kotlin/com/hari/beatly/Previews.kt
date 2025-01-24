package com.hari.beatly

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hari.beatly.song.presentation.play_list.component.SearchBar

@Preview
@Composable
private fun SearchBarPreview() {
    SearchBar(
        searchQuery = "",
        onSearchQueryChanged = {},
        onIMEAction = {},
        modifier = Modifier.fillMaxWidth(),
    )
} 
