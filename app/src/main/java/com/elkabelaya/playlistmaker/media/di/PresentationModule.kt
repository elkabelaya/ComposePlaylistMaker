package com.elkabelaya.playlistmaker.media.di

import com.elkabelaya.playlistmaker.media.domain.repository.MediaFavoritesErrorRepository
import com.elkabelaya.playlistmaker.media.domain.repository.MediaNavigatorRepository
import com.elkabelaya.playlistmaker.media.domain.repository.MediaPlaylistsErrorRepository
import com.elkabelaya.playlistmaker.media.presentation.repository.MediaFavoritesErrorRepositoryImpl
import com.elkabelaya.playlistmaker.media.presentation.repository.MediaNavigatorRepositoryImpl
import com.elkabelaya.playlistmaker.media.presentation.repository.MediaPlaylistsErrorsRepositoryImpl
import com.elkabelaya.playlistmaker.search.domain.repository.SearchNavigatorRepository
import com.elkabelaya.playlistmaker.search.presentation.repository.SearchNavigatorRepositoryImpl
import org.koin.dsl.module

val mediaPresentationModule = module {
    factory<MediaFavoritesErrorRepository>{ MediaFavoritesErrorRepositoryImpl(get()) }
    factory<MediaPlaylistsErrorRepository>{ MediaPlaylistsErrorsRepositoryImpl(get()) }
    factory<MediaNavigatorRepository>{ MediaNavigatorRepositoryImpl() }
}
