package com.elkabelaya.playlistmaker.playlist.domain.impl

import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.repository.ExternalNavigatorRepository
import com.elkabelaya.playlistmaker.common.domain.repository.NavigatorRepository
import com.elkabelaya.playlistmaker.playlist.domain.api.PlaylistNavigatorInteractor
import com.elkabelaya.playlistmaker.playlist.domain.repository.PlaylistDescriptionRepository
import com.elkabelaya.playlistmaker.playlist.domain.repository.PlaylistNavigatorRepository

class PlaylistNavigatorInteractorImpl(
    private val repository: NavigatorRepository,
    private val playlistRepository: PlaylistNavigatorRepository,
    private val externalNavigatorRepository: ExternalNavigatorRepository
): PlaylistNavigatorInteractor {

    override fun navigateTo(track: Track) {
        repository.navigateTo(playlistRepository.getPlayer(track))
    }

    override fun navigateToEdit(playlist: Playlist) {
        repository.navigateTo(playlistRepository.getPlayListEdit(playlist))
    }

    override fun navigateToShare(description: String) {
        externalNavigatorRepository.share(description)
    }
}