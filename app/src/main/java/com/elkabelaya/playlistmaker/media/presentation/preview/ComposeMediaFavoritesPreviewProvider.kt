package com.elkabelaya.playlistmaker.media.presentation.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.elkabelaya.playlistmaker.common.domain.model.ErrorState
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.mocks.mockList
import com.elkabelaya.playlistmaker.media.domain.model.MediaFavoritesState
import com.elkabelaya.playlistmaker.media.presentation.favorites.MediaFavoritesViewModel


class ComposeMediaFavoritesPreviewProvider() : PreviewParameterProvider<MediaFavoritesViewModel> {
    override val values = sequenceOf(
        MediaFavoritesViewModelMock(MediaFavoritesState.Loading),
        MediaFavoritesViewModelMock(MediaFavoritesState.Data(Track.mockList())),
        MediaFavoritesViewModelMock(MediaFavoritesState.Error(ErrorState.Empty("Error Text"))),
    )
}
