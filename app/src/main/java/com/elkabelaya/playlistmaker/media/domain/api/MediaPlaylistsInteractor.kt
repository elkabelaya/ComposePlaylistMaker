package com.elkabelaya.playlistmaker.media.domain.api

import com.elkabelaya.playlistmaker.common.domain.model.ErrorState
import com.elkabelaya.playlistmaker.common.domain.model.Playlists
import kotlinx.coroutines.flow.Flow

interface MediaPlaylistsInteractor {
    fun getPlayLists(): Flow<Pair<Playlists?, ErrorState?>>
}
