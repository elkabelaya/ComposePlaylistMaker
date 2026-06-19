package com.elkabelaya.playlistmaker.playlist.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.domain.mocks.mock1
import com.elkabelaya.playlistmaker.common.domain.mocks.mockList
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.presentation.AppTheme
import com.elkabelaya.playlistmaker.common.presentation.MenuButton
import com.elkabelaya.playlistmaker.common.presentation.PlaylistCard
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview
import com.elkabelaya.playlistmaker.playlist.domain.model.PlaylistState
import com.elkabelaya.playlistmaker.playlist.presentation.PlaylistViewModel
import com.elkabelaya.playlistmaker.playlist.presentation.preview.PlaylistViewModelMock
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkabelaya.playlistmaker.common.presentation.Dimens

@Composable
fun PlaylistMenu(playlist: Playlist,
                 onShare: () -> Unit,
                 onEdit: () -> Unit,
                 onDelete: () -> Unit) {
    Column {
        PlaylistCard(
            playlist,
            modifier = Modifier.padding(bottom = Dimens.paddingXS)
        )
        MenuButton(R.string.playlist_menu_share, onClick = onShare)
        MenuButton(R.string.playlist_menu_edit, onClick = onEdit)
        MenuButton(R.string.playlist_remove, onClick = onDelete)
        Spacer(Modifier.height(107.dp))
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@AppPreview
@Composable
private fun PlaylistMenuPreview() {
    AppTheme {
        PlaylistMenu(Playlist.mock1(), { },{},{})
    }
}