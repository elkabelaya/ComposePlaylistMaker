package com.elkabelaya.playlistmaker.settings.di

import com.elkabelaya.playlistmaker.settings.presentation.SettingsViewModel
import com.elkabelaya.playlistmaker.settings.presentation.SettingsViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val settingsViewModelModule = module {

    viewModel<SettingsViewModel> {
        SettingsViewModelImpl(get(), get(), get())
    }
}