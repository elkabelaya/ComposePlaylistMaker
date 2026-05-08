package com.elkabelaya.playlistmaker.media.domain.model

import com.elkabelaya.playlistmaker.common.domain.model.ErrorState
import com.elkabelaya.playlistmaker.common.domain.model.Playlists

sealed interface MediaPlaylistsState {
    data object Loading: MediaPlaylistsState
    data class Error(val errorState: ErrorState): MediaPlaylistsState
    data class Data(val playlists: Playlists): MediaPlaylistsState
}