package com.elkabelaya.playlistmaker.playlist.domain.api

import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Track

interface PlaylistNavigatorInteractor {
    fun navigateTo(track: Track)
    fun navigateToEdit(playlist: Playlist)

    fun navigateToShare(description: String)
}