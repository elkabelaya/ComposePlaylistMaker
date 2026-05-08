package com.elkabelaya.playlistmaker.playlist.di

import com.elkabelaya.playlistmaker.player.presentation.PlayerViewModel
import com.elkabelaya.playlistmaker.player.presentation.PlayerViewModelImpl
import com.elkabelaya.playlistmaker.playlist.presentation.PlaylistViewModel
import com.elkabelaya.playlistmaker.playlist.presentation.PlaylistViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val playlistViewModelModule = module {

    viewModel<PlaylistViewModel> { parameters ->
        PlaylistViewModelImpl(get{parameters}, get(), parameters.get())
    }
}