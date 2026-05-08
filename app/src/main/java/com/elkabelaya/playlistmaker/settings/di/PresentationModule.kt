package com.elkabelaya.playlistmaker.settings.di

import com.elkabelaya.playlistmaker.settings.domain.repository.SettingsNavigatorRepository
import com.elkabelaya.playlistmaker.settings.presentation.repository.SettingsNavigatorRepositoryImpl
import org.koin.dsl.module

val settingsPresentationModule = module {
    factory<SettingsNavigatorRepository>{ SettingsNavigatorRepositoryImpl(get()) }
}
