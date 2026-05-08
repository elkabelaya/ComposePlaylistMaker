package com.elkabelaya.playlistmaker.playlist.di

import com.elkabelaya.playlistmaker.playlist.domain.api.PlaylistInteractor
import com.elkabelaya.playlistmaker.playlist.domain.api.PlaylistNavigatorInteractor
import com.elkabelaya.playlistmaker.playlist.domain.impl.PlaylistInteractorImpl
import com.elkabelaya.playlistmaker.playlist.domain.impl.PlaylistNavigatorInteractorImpl
import org.koin.dsl.module

val playlistDomainModule = module {
    factory<PlaylistInteractor> { parameters ->
        PlaylistInteractorImpl(get(),  get(),parameters.get())
    }
    factory<PlaylistNavigatorInteractor>{ PlaylistNavigatorInteractorImpl(get(), get(), get()) }
}
