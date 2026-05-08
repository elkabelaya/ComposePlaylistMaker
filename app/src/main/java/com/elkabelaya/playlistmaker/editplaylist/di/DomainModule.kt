package com.elkabelaya.playlistmaker.editplaylist.di

import com.elkabelaya.playlistmaker.common.di.CommonDiNames
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.editplaylist.domain.api.EditPlayListInteractor
import com.elkabelaya.playlistmaker.editplaylist.domain.impl.EditPlayListInteractorImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val editplaylistDomainModule = module {
    factory<EditPlayListInteractor> { params ->
        EditPlayListInteractorImpl(get(), get(named(CommonDiNames.PLAYLIST_COVERS_FOLDER_NAME))) }
}
