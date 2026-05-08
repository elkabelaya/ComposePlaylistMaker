package com.elkabelaya.playlistmaker.settings.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elkabelaya.playlistmaker.common.domain.api.ModeInteractor
import com.elkabelaya.playlistmaker.common.domain.use_case.ClickDebounceUseCase

import com.elkabelaya.playlistmaker.settings.domain.api.SettingsNavigatorInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class SettingsViewModelImpl(
    val modeInteractor: ModeInteractor,
    val navigatorInteractor: SettingsNavigatorInteractor,
    val clickDebounceUseCase: ClickDebounceUseCase
): SettingsViewModel() {
    private val _isDarkMode = MutableStateFlow(false)
    override var isDarkMode: StateFlow<Boolean> = _isDarkMode.asStateFlow()

    override fun switch(isDarck: Boolean) {
        modeInteractor.switchTheme(isDarck)
        _isDarkMode.value = isDarck
    }

    override fun share() {
        if (clickDebounceUseCase.canClickDebounced()) {
            navigatorInteractor.navigateToShare()
        }
    }

    override fun support() {
        if (clickDebounceUseCase.canClickDebounced()) {
            navigatorInteractor.navigateToMail()
        }
    }

    override fun agreement() {
        if (clickDebounceUseCase.canClickDebounced()) {
            navigatorInteractor.navigateToAgreement()
        }
    }

    init {
        _isDarkMode.value = modeInteractor.darkTheme
    }
}