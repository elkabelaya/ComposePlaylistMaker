package com.elkabelaya.playlistmaker.media.presentation.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.presentation.components.ComposeErrorView
import com.elkabelaya.playlistmaker.common.presentation.components.track.TrackItemList
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview
import com.elkabelaya.playlistmaker.media.domain.model.MediaFavoritesState
import com.elkabelaya.playlistmaker.media.presentation.preview.ComposeMediaFavoritesPreviewProvider
import com.elkabelaya.playlistmaker.search.presentation.LoadingContent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ComposeMediaFavorites(viewModel: MediaFavoritesViewModel = koinViewModel()) {
    val state = viewModel.state.collectAsState().value

    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(R.color.background))
    ) {
        when(state) {
            is MediaFavoritesState.Loading -> {
                LoadingContent()
            }
            is MediaFavoritesState.Data -> {
                TrackItemList(state.tracks,viewModel::select)
            }
            is MediaFavoritesState.Error -> {
                ComposeErrorView(state.errorState)
            }
        }
    }

}

@AppPreview
@Composable
fun ComposeMediaFavoritesPreview (
    @PreviewParameter(ComposeMediaFavoritesPreviewProvider::class) model: MediaFavoritesViewModel
) {
    ComposeMediaFavorites(model)
}