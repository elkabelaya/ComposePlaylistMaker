package com.elkabelaya.playlistmaker.search.di

import com.elkabelaya.playlistmaker.search.presentation.SearchViewModel
import com.elkabelaya.playlistmaker.search.presentation.SearchViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchViewModelModule = module {

    viewModel <SearchViewModel>{
        SearchViewModelImpl(get(), get(), get())
    }
}