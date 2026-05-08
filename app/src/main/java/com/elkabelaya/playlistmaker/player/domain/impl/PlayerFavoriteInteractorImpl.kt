package com.elkabelaya.playlistmaker.player.domain.impl

import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.repository.FavoriteTracksRepository
import com.elkabelaya.playlistmaker.player.domain.api.PlayerFavoriteInteractor

class PlayerFavoriteInteractorImpl(private val repository: FavoriteTracksRepository):
    PlayerFavoriteInteractor {
    override suspend fun isFavorite(track: Track): Boolean {
        return repository.find(track.trackId) != null
    }

    override suspend fun toggle(track: Track): Boolean {
        if (isFavorite(track)) {
            repository.delete(track.trackId)
            return false
        } else {
            repository.add(track)
            return true
        }
    }
}