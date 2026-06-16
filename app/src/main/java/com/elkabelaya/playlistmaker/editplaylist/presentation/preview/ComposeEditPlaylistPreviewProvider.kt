package com.elkabelaya.playlistmaker.editplaylist.presentation.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.elkabelaya.playlistmaker.common.domain.mocks.emptyMock
import com.elkabelaya.playlistmaker.common.domain.mocks.mock1
import com.elkabelaya.playlistmaker.common.domain.mocks.mockSequence
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.editplaylist.domain.model.EditPlaylistMode
import com.elkabelaya.playlistmaker.editplaylist.domain.model.EditPlaylistState
import com.elkabelaya.playlistmaker.editplaylist.presentation.EditPlaylistViewModel

class ComposeEditPlaylistPreviewProvider(): PreviewParameterProvider<EditPlaylistViewModel> {
    override val values = sequenceOf(
        EditPlaylistViewModelMock(
            EditPlaylistState(false, false),
            EditPlaylistMode.NEW,
            Playlist.emptyMock(),
            null
        ),
        EditPlaylistViewModelMock(
            EditPlaylistState(true, false),
            EditPlaylistMode.EDIT,
            Playlist.mock1(),
            null
            )
    )
}
