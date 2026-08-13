package com.elkabelaya.playlistmaker.player.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.presentation.AppTheme
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview


@Composable
fun PlayButton(isPlaying: Boolean, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(painterResource(if (isPlaying) R.drawable.ic_player_pause_button else R.drawable.ic_player_play_button),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}

@AppPreview
@Composable
private fun PlayButtonPreview() {
    AppTheme {
        Row {
            PlayButton(true) {}
            PlayButton(false) {}
        }
    }
}