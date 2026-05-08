package com.elkabelaya.playlistmaker.search.domain.repository

import com.elkabelaya.playlistmaker.common.domain.model.Resource
import com.elkabelaya.playlistmaker.common.domain.model.Tracks
import kotlinx.coroutines.flow.Flow

interface TracksRepository {
    suspend fun getTracks(query: String): Flow<Resource<Tracks>>
}