package com.elkabelaya.playlistmaker.playlist.di

import com.elkabelaya.playlistmaker.player.domain.repository.PlayerDefaultsRepository
import com.elkabelaya.playlistmaker.player.presentation.repository.PlayerDefaultsRepositoryImpl
import com.elkabelaya.playlistmaker.playlist.domain.repository.PlaylistDescriptionRepository
import com.elkabelaya.playlistmaker.playlist.domain.repository.PlaylistNavigatorRepository
import com.elkabelaya.playlistmaker.playlist.presentation.repository.PlaylistDescriptionRepositoryImpl
import com.elkabelaya.playlistmaker.playlist.presentation.repository.PlaylistNavigatorRepositoryImpl
import org.koin.dsl.module

val playlistPresentationModule = module {
    factory<PlaylistNavigatorRepository>{ PlaylistNavigatorRepositoryImpl(get()) }
    factory<PlaylistDescriptionRepository>{ PlaylistDescriptionRepositoryImpl(get())}
}
