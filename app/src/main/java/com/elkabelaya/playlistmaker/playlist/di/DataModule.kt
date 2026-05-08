package com.elkabelaya.playlistmaker.playlist.di

import com.elkabelaya.playlistmaker.player.domain.repository.PlayerNavigatorRepository
import com.elkabelaya.playlistmaker.player.data.repository.PlayerRepositoryImpl
import com.elkabelaya.playlistmaker.player.domain.repository.PlayerRepository
import com.elkabelaya.playlistmaker.player.presentation.repository.PlayerNavigatorRepositoryImpl
import org.koin.dsl.module

val playlistDataModule = module {
//    factory<PlayerRepository> { PlayerRepositoryImpl() }
//    factory<PlayerNavigatorRepository> { PlayerNavigatorRepositoryImpl() }
}
