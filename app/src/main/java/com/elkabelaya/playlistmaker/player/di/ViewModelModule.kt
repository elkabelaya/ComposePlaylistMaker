package com.elkabelaya.playlistmaker.player.di

import com.elkabelaya.playlistmaker.player.presentation.PlayerViewModel
import com.elkabelaya.playlistmaker.player.presentation.PlayerViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val playerViewModelModule = module {

    viewModel<PlayerViewModel> { parameters ->
        PlayerViewModelImpl(get(),  get(), get(), get(), parameters.get())
    }
}