package com.elkabelaya.playlistmaker.search.di

import com.elkabelaya.playlistmaker.search.domain.repository.SearchNavigatorRepository
import com.elkabelaya.playlistmaker.search.presentation.repository.SearchNavigatorRepositoryImpl
import org.koin.dsl.module

val searchPresentationModule = module {
    factory<SearchNavigatorRepository>{ SearchNavigatorRepositoryImpl() }
}
