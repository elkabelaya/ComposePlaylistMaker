package com.elkabelaya.playlistmaker.media.domain.api

import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Track

interface MediaNavigatorInteractor {
    fun navigateTo(track: Track)
    fun navigateTo(playlist: Playlist)
    fun navigateToNewPlaylist()
}