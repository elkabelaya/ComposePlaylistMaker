package com.elkabelaya.playlistmaker.search.domain.use_case

import com.elkabelaya.playlistmaker.common.domain.model.Resource
import com.elkabelaya.playlistmaker.common.domain.model.Tracks
import kotlinx.coroutines.flow.Flow

interface GetTracksUseCase {
    suspend fun getTracks(query: String): Flow<Resource<Tracks>>
}