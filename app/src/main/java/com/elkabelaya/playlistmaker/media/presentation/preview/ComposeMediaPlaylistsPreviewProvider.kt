package com.elkabelaya.playlistmaker.media.presentation.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.elkabelaya.playlistmaker.common.domain.model.ErrorState
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.mocks.mockList
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.media.domain.model.MediaPlaylistsState
import com.elkabelaya.playlistmaker.media.presentation.playlists.MediaPlaylistsViewModel


class ComposeMediaPlaylistsPreviewProvider() : PreviewParameterProvider<MediaPlaylistsViewModel> {
    override val values = sequenceOf(
        MediaPlaylistsViewModelMock(MediaPlaylistsState.Loading),
        MediaPlaylistsViewModelMock(MediaPlaylistsState.Data(Playlist.mockList())),
        MediaPlaylistsViewModelMock(MediaPlaylistsState.Error(ErrorState.Empty("Error Text"))),
    )
}
