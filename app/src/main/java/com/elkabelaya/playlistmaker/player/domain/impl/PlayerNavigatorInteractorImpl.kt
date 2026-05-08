package com.elkabelaya.playlistmaker.player.domain.impl

import com.elkabelaya.playlistmaker.common.domain.repository.NavigatorRepository
import com.elkabelaya.playlistmaker.player.domain.repository.PlayerNavigatorRepository
import com.elkabelaya.playlistmaker.player.domain.api.PlayerNavigatorInteractor

class PlayerNavigatorInteractorImpl(
    private val repository: NavigatorRepository,
    private val playerRepository: PlayerNavigatorRepository
): PlayerNavigatorInteractor {

    override fun navigateToNewPlaylist() {
        repository.navigateTo(playerRepository.getNewPlayLst())
    }
}