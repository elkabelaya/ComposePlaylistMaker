package com.elkabelaya.playlistmaker.root.di

import com.elkabelaya.playlistmaker.player.presentation.PlayerViewModel
import com.elkabelaya.playlistmaker.player.presentation.PlayerViewModelImpl
import com.elkabelaya.playlistmaker.root.presentation.RootViewModel
import com.elkabelaya.playlistmaker.root.presentation.RootViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val rootViewModelModule = module {
    viewModel<RootViewModel> {
        RootViewModelImpl(get())
    }
}