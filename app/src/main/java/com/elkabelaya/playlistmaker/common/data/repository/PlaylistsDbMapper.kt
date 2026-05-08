package com.elkabelaya.playlistmaker.common.data.repository

import com.elkabelaya.playlistmaker.common.data.db.PlaylistCount
import com.elkabelaya.playlistmaker.common.data.db.PlaylistEntity
import com.elkabelaya.playlistmaker.common.data.db.TrackPlaylistEntity
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Track

interface PlaylistsDbMapper {
    fun map(playlist: Playlist): PlaylistEntity
    fun map(entity: PlaylistEntity): Playlist
    fun map(entity: PlaylistCount): Playlist
    fun fill(entity: PlaylistEntity, playlist: Playlist): PlaylistEntity
    fun map(track: Track, playlist: Playlist): TrackPlaylistEntity
}