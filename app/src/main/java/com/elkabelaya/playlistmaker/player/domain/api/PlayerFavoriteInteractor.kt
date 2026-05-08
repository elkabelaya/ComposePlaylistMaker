package com.elkabelaya.playlistmaker.player.domain.api

import com.elkabelaya.playlistmaker.common.domain.model.Track

interface PlayerFavoriteInteractor {
    suspend fun isFavorite(track: Track): Boolean
    suspend fun toggle(track: Track): Boolean
}