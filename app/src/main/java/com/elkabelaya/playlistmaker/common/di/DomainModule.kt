package com.elkabelaya.playlistmaker.common.di

import com.elkabelaya.playlistmaker.player.domain.api.PlayerFavoriteInteractor
import com.elkabelaya.playlistmaker.common.domain.api.ModeInteractor
import com.elkabelaya.playlistmaker.common.domain.api.PermissionInteractor
import com.elkabelaya.playlistmaker.common.domain.impl.ClickDebounceUseCaseImpl
import com.elkabelaya.playlistmaker.player.domain.impl.PlayerFavoriteInteractorImpl
import com.elkabelaya.playlistmaker.common.domain.impl.ModeInteractorImpl
import com.elkabelaya.playlistmaker.common.domain.impl.PermissionInteractorImpl
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.empty
import com.elkabelaya.playlistmaker.common.domain.use_case.ClickDebounceUseCase
import org.koin.core.qualifier.named

import org.koin.dsl.module

val commonDomainModule = module {
    factory<ClickDebounceUseCase>{ ClickDebounceUseCaseImpl(get()) }
    factory<ModeInteractor>{ ModeInteractorImpl(get(), get()) }
    factory<PlayerFavoriteInteractor> { PlayerFavoriteInteractorImpl(get()) }
    factory<PermissionInteractor> { PermissionInteractorImpl(get()) }
}



