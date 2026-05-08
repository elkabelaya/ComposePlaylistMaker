package com.elkabelaya.playlistmaker.playlist.domain.model

import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Tracks

data class PlaylistState (
    val playlist: Playlist,
    val tracks: Tracks
)