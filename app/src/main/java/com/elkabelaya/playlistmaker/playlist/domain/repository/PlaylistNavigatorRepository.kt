package com.elkabelaya.playlistmaker.playlist.domain.repository

import com.elkabelaya.playlistmaker.common.domain.model.Navigation
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Track

interface PlaylistNavigatorRepository {
    fun getPlayListEdit(playlist: Playlist): Navigation
    fun getPlayer(track: Track): Navigation
}