package com.elkabelaya.playlistmaker.common.domain.api

import com.elkabelaya.playlistmaker.media.domain.model.MediaFavoritesState

interface StateFullInteractor<T> {
    fun onState(state: (T) -> Unit)
}