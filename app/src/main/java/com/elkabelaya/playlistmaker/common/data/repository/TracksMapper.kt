package com.elkabelaya.playlistmaker.common.data.repository

import com.elkabelaya.playlistmaker.common.data.model.TrackDto
import com.elkabelaya.playlistmaker.common.data.model.TracksDto
import com.elkabelaya.playlistmaker.common.domain.model.Tracks

interface TracksMapper {
    fun map(dto: TracksDto): Tracks
    fun map(dto: Tracks): TracksDto
}