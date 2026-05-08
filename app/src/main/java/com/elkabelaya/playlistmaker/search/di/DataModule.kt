package com.elkabelaya.playlistmaker.search.di

import com.elkabelaya.playlistmaker.search.data.network.TracksRetrofitNetworkClient
import com.elkabelaya.playlistmaker.search.presentation.repository.SearchErrorRepositoryImpl
import com.elkabelaya.playlistmaker.search.data.repository.TracksNetworkClient
import com.elkabelaya.playlistmaker.search.data.repository.TracksRepositoryImpl
import com.elkabelaya.playlistmaker.search.domain.repository.SearchErrorRepository
import com.elkabelaya.playlistmaker.search.domain.repository.TracksRepository
import org.koin.dsl.module

val searchDataModule = module {
    single<TracksNetworkClient> { TracksRetrofitNetworkClient(get())}
    factory<TracksRepository> { TracksRepositoryImpl(get(), get()) }
    single<SearchErrorRepository> { SearchErrorRepositoryImpl(get())}
}
