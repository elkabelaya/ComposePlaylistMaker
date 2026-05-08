package com.elkabelaya.playlistmaker.editplaylist.di

import com.elkabelaya.playlistmaker.editplaylist.presentation.EditPlaylistViewModel
import com.elkabelaya.playlistmaker.editplaylist.presentation.EditPlaylistViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val editplaylistViewModelModule = module {

    viewModel<EditPlaylistViewModel> { parameters ->
        EditPlaylistViewModelImpl(get(), parameters.getOrNull())
    }
}