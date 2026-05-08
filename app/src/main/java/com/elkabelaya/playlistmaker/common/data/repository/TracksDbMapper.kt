package com.elkabelaya.playlistmaker.common.data.repository

import com.elkabelaya.playlistmaker.common.data.db.TrackEntity
import com.elkabelaya.playlistmaker.common.data.db.TrackFavoriteEntity
import com.elkabelaya.playlistmaker.common.domain.model.Track

interface TracksDbMapper {
    fun map(track: Track): TrackEntity
    fun mapFavorite(track: Track): TrackFavoriteEntity

    fun map(entity: TrackEntity): Track
}