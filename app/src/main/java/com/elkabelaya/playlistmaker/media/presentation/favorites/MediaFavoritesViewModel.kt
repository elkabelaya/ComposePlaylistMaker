package com.elkabelaya.playlistmaker.media.presentation.favorites

import androidx.lifecycle.ViewModel
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.presentation.ComposeStateFullViewModel
import com.elkabelaya.playlistmaker.common.presentation.StateFullViewModel
import com.elkabelaya.playlistmaker.media.domain.model.MediaFavoritesState

abstract class MediaFavoritesViewModel: ComposeStateFullViewModel<MediaFavoritesState>, ViewModel() {
    abstract fun select(track: Track)
}