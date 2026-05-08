package com.elkabelaya.playlistmaker.search.presentation.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.elkabelaya.playlistmaker.common.domain.model.ErrorState
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.mocks.mockList
import com.elkabelaya.playlistmaker.search.domain.model.SearchState
import com.elkabelaya.playlistmaker.search.presentation.SearchViewModel


class ComposeSearchPreviewProvider() : PreviewParameterProvider<SearchViewModel> {
    override val values = sequenceOf(
        SearchViewModelMock(SearchState.Default),
        SearchViewModelMock(SearchState.History(Track.mockList())),
        SearchViewModelMock(SearchState.Enter, "Queen"),
        SearchViewModelMock(SearchState.Loading, "Queen"),
        SearchViewModelMock(SearchState.Result(Track.mockList()), "Queen"),
        SearchViewModelMock(SearchState.Error(ErrorState.Wifi("text")), "Queen"),
    )
}
