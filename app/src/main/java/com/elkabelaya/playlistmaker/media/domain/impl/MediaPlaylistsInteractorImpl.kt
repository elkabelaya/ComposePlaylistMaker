package com.elkabelaya.playlistmaker.media.domain.impl

import com.elkabelaya.playlistmaker.common.domain.model.ErrorState
import com.elkabelaya.playlistmaker.common.domain.model.Playlists
import com.elkabelaya.playlistmaker.common.domain.repository.PlaylistsRepository
import com.elkabelaya.playlistmaker.media.domain.api.MediaPlaylistsInteractor
import com.elkabelaya.playlistmaker.media.domain.repository.MediaPlaylistsErrorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MediaPlaylistsInteractorImpl(
    private val repository: PlaylistsRepository,
    private val errorRepository: MediaPlaylistsErrorRepository
): MediaPlaylistsInteractor {

    override fun getPlayLists(): Flow<Pair<Playlists?, ErrorState?>> = flow {
        repository.get()
            .collect { playlists ->
                if (playlists.isEmpty()) {
                    emit(Pair(null, ErrorState.Empty(errorRepository.getErrorText())))
                } else {
                    emit(Pair(playlists, null)  )
                }
            }
    }
}