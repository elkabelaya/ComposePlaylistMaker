package com.elkabelaya.playlistmaker.player.di

import com.elkabelaya.playlistmaker.player.domain.repository.PlayerDefaultsRepository
import com.elkabelaya.playlistmaker.player.presentation.repository.PlayerDefaultsRepositoryImpl
import com.elkabelaya.playlistmaker.settings.domain.repository.SettingsNavigatorRepository
import com.elkabelaya.playlistmaker.settings.presentation.repository.SettingsNavigatorRepositoryImpl
import org.koin.dsl.module

val playerPresentationModule = module {
    factory<PlayerDefaultsRepository>{ PlayerDefaultsRepositoryImpl(get()) }
}
