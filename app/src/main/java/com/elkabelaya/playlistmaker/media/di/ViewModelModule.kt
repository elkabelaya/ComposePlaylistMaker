package com.elkabelaya.playlistmaker.media.di

import com.elkabelaya.playlistmaker.media.presentation.favorites.MediaFavoritesViewModel
import com.elkabelaya.playlistmaker.media.presentation.favorites.MediaFavoritesViewModelImpl
import com.elkabelaya.playlistmaker.media.presentation.playlists.MediaPlaylistsViewModel
import com.elkabelaya.playlistmaker.media.presentation.playlists.MediaPlaylistsViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mediaViewModelModule = module {

    viewModel<MediaFavoritesViewModel> {
        MediaFavoritesViewModelImpl(get(), get(), get())
    }

    viewModel<MediaPlaylistsViewModel> {
        MediaPlaylistsViewModelImpl(get(), get())
    }
}