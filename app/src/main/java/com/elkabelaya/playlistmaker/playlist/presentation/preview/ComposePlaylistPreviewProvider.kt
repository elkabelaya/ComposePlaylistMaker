package com.elkabelaya.playlistmaker.playlist.presentation.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.elkabelaya.playlistmaker.common.domain.mocks.mock1
import com.elkabelaya.playlistmaker.common.domain.model.ErrorState
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.mocks.mockList
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.playlist.domain.model.PlaylistState
import com.elkabelaya.playlistmaker.playlist.presentation.PlaylistViewModel
import com.elkabelaya.playlistmaker.search.domain.model.SearchState
import com.elkabelaya.playlistmaker.search.presentation.SearchViewModel
import com.elkabelaya.playlistmaker.search.presentation.preview.SearchViewModelMock


class ComposePlaylistPreviewProvider() : PreviewParameterProvider<PlaylistViewModel> {
    override val values = sequenceOf(
        PlaylistViewModelMock(PlaylistState(Playlist.mock1(), Track.mockList()))

    )
}
