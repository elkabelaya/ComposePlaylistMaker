package com.elkabelaya.playlistmaker.search.domain.impl

import com.elkabelaya.playlistmaker.common.domain.consumer.ResourceConsumer
import com.elkabelaya.playlistmaker.common.domain.model.Resource
import com.elkabelaya.playlistmaker.common.domain.model.Tracks
import com.elkabelaya.playlistmaker.search.domain.repository.TracksRepository
import com.elkabelaya.playlistmaker.search.domain.use_case.GetTracksUseCase
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executors

class GetTracksUseCaseImpl(private val repository: TracksRepository) : GetTracksUseCase {

    override suspend fun getTracks(query: String): Flow<Resource<Tracks>> {
        return repository.getTracks(query)
    }
}