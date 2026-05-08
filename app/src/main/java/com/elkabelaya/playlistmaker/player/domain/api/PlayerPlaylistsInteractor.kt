package com.elkabelaya.playlistmaker.player.domain.api

import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Playlists
import com.elkabelaya.playlistmaker.common.domain.model.Track
import kotlinx.coroutines.flow.Flow

interface PlayerPlaylistsInteractor {
    suspend fun get(): Flow<Playlists>
    suspend fun add(track: Track, playlist: Playlist): String
}