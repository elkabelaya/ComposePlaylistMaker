package com.elkabelaya.playlistmaker.media.domain.model

import com.elkabelaya.playlistmaker.common.domain.model.ErrorState
import com.elkabelaya.playlistmaker.common.domain.model.Tracks

sealed class  MediaFavoritesState {
    data object Loading: MediaFavoritesState()
    data class Error(val errorState: ErrorState): MediaFavoritesState()
    data class Data(val tracks: Tracks): MediaFavoritesState()
}