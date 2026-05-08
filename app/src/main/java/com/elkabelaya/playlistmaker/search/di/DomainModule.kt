package com.elkabelaya.playlistmaker.search.di

import com.elkabelaya.playlistmaker.search.domain.api.SearchInteractor
import com.elkabelaya.playlistmaker.search.domain.api.SearchNavigatorInteractor
import com.elkabelaya.playlistmaker.search.domain.impl.GetTracksUseCaseImpl
import com.elkabelaya.playlistmaker.search.domain.impl.HistoryUseCaseImpl
import com.elkabelaya.playlistmaker.search.domain.impl.InputDebounceUseCaseImpl
import com.elkabelaya.playlistmaker.search.domain.impl.SearchInteractorImpl
import com.elkabelaya.playlistmaker.search.domain.impl.SearchNavigatorInteractorImpl
import com.elkabelaya.playlistmaker.search.domain.use_case.GetTracksUseCase
import com.elkabelaya.playlistmaker.search.domain.use_case.HistoryUseCase
import com.elkabelaya.playlistmaker.search.domain.use_case.InputDebounceUseCase
import org.koin.dsl.module

val searchDomainModule = module {
    factory<GetTracksUseCase> { GetTracksUseCaseImpl(get()) }
    factory<InputDebounceUseCase>{ InputDebounceUseCaseImpl(get()) }
    factory<SearchInteractor>{SearchInteractorImpl(get(), get(), get(), get(), get())}
    factory<HistoryUseCase>{ HistoryUseCaseImpl(get(), 10) }
    factory<SearchNavigatorInteractor> {
        SearchNavigatorInteractorImpl(get(), get())
    }
}
