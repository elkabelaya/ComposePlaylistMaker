package com.elkabelaya.playlistmaker.search.domain.api

import com.elkabelaya.playlistmaker.common.domain.model.Track

interface SearchNavigatorInteractor {
    fun navigateTo(track: Track)
}