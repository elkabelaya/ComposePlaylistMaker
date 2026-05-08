package com.elkabelaya.playlistmaker.playlist.domain.repository

import com.elkabelaya.playlistmaker.common.domain.model.Navigation
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.model.Tracks

interface PlaylistDescriptionRepository {
    fun getDescription(playlist: Playlist, tracks: Tracks): String
    fun getEmptyDescription(): String
}