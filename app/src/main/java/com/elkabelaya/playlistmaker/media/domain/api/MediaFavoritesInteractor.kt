package com.elkabelaya.playlistmaker.media.domain.api
import com.elkabelaya.playlistmaker.common.domain.model.ErrorState
import com.elkabelaya.playlistmaker.common.domain.model.Tracks
import kotlinx.coroutines.flow.Flow

interface MediaFavoritesInteractor {
    suspend fun getFracks(): Flow<Pair<Tracks?, ErrorState?>>
}