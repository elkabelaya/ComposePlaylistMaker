package com.elkabelaya.playlistmaker.media.di

import com.elkabelaya.playlistmaker.media.domain.api.MediaFavoritesInteractor
import com.elkabelaya.playlistmaker.media.domain.api.MediaNavigatorInteractor
import com.elkabelaya.playlistmaker.media.domain.api.MediaPlaylistsInteractor
import com.elkabelaya.playlistmaker.media.domain.impl.MediaFavoritesInteractorImpl
import com.elkabelaya.playlistmaker.media.domain.impl.MediaNavigatorInteractorImpl
import com.elkabelaya.playlistmaker.media.domain.impl.MediaPlaylistsInteractorImpl
import org.koin.dsl.module

val mediaDomainModule = module {
    factory<MediaFavoritesInteractor> { MediaFavoritesInteractorImpl(get(), get()) }
    factory<MediaPlaylistsInteractor> { MediaPlaylistsInteractorImpl(get(), get()) }
    factory<MediaNavigatorInteractor> {
        MediaNavigatorInteractorImpl(get(), get())
    }
}
