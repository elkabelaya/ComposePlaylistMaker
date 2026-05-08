package com.elkabelaya.playlistmaker.settings.domain.impl

import com.elkabelaya.playlistmaker.common.domain.repository.ExternalNavigatorRepository
import com.elkabelaya.playlistmaker.settings.domain.api.SettingsNavigatorInteractor
import com.elkabelaya.playlistmaker.settings.domain.repository.SettingsNavigatorRepository

class SettingsNavigatorInteractorImpl(
    private val repository: ExternalNavigatorRepository,
    private val settingsRepository: SettingsNavigatorRepository
): SettingsNavigatorInteractor {
    override fun navigateToShare(){
        repository.share(settingsRepository.getShareUrl())
    }
    override fun navigateToAgreement(){
        repository.openWeb(settingsRepository.getShareUrl())
    }
    override fun navigateToMail(){
        repository.openEmail(settingsRepository.getEmail())
    }
}