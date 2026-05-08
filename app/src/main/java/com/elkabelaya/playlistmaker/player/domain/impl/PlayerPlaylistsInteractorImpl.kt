package com.elkabelaya.playlistmaker.player.domain.impl

import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Playlists
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.repository.PlaylistsRepository
import com.elkabelaya.playlistmaker.player.domain.api.PlayerPlaylistsInteractor
import com.elkabelaya.playlistmaker.player.domain.repository.PlayerDefaultsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlayerPlaylistsInteractorImpl(
    private val repository: PlaylistsRepository,
    private val defaultsRepositoty: PlayerDefaultsRepository): PlayerPlaylistsInteractor {
    override suspend fun get(): Flow<Playlists> = flow {
        repository.get().collect {
            emit(it)
        }
    }

    override suspend fun add(track: Track, playlist: Playlist): String {
        val added = repository.add(track, playlist)
        return defaultsRepositoty.addToastText(added, playlist.name)
    }
}