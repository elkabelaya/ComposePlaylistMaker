package com.elkabelaya.playlistmaker.player.di

import com.elkabelaya.playlistmaker.player.domain.api.PlayerInteractor
import com.elkabelaya.playlistmaker.player.domain.api.PlayerNavigatorInteractor
import com.elkabelaya.playlistmaker.player.domain.api.PlayerPlaylistsInteractor
import com.elkabelaya.playlistmaker.player.domain.impl.PlayerInteractorImpl
import com.elkabelaya.playlistmaker.player.domain.impl.PlayerNavigatorInteractorImpl
import com.elkabelaya.playlistmaker.player.domain.impl.PlayerPlaylistsInteractorImpl
import org.koin.dsl.module

val playerDomainModule = module {
    factory<PlayerInteractor> { PlayerInteractorImpl(get(), get()) }
    factory<PlayerPlaylistsInteractor> { PlayerPlaylistsInteractorImpl(get(), get()) }
    factory<PlayerNavigatorInteractor> {
        PlayerNavigatorInteractorImpl(get(), get())
    }
}
