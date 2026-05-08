package com.elkabelaya.playlistmaker.settings.di

import com.elkabelaya.playlistmaker.settings.domain.api.SettingsNavigatorInteractor
import com.elkabelaya.playlistmaker.settings.domain.impl.SettingsNavigatorInteractorImpl
import org.koin.dsl.module

val settingsDomainModule = module {
     factory<SettingsNavigatorInteractor> { SettingsNavigatorInteractorImpl(get(), get()) }
}
