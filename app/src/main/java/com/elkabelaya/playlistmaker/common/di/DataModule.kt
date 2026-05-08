package com.elkabelaya.playlistmaker.common.di

import androidx.room.Room
import com.elkabelaya.playlistmaker.common.data.db.AppDatabase
import com.elkabelaya.playlistmaker.common.data.db.DbConstants
import com.elkabelaya.playlistmaker.common.data.db.dao.FavoriteTracksDao
import com.elkabelaya.playlistmaker.common.data.db.dao.PlaylistsDao
import com.elkabelaya.playlistmaker.common.data.db.dao.migrations.HANDLE_MIGRATION_1_2
import com.elkabelaya.playlistmaker.common.data.db.dao.migrations.HANDLE_MIGRATION_2_3
import com.elkabelaya.playlistmaker.common.data.mapper.PlaylistsDbMapperImpl
import com.elkabelaya.playlistmaker.common.data.mapper.TracksDbMapperImpl
import com.elkabelaya.playlistmaker.common.data.mapper.TracksMapperImpl
import com.elkabelaya.playlistmaker.common.data.network.ItunesApi
import com.elkabelaya.playlistmaker.common.data.network.RetrofitClient
import com.elkabelaya.playlistmaker.common.data.repository.CoroutinesLoopRepositoryImpl
import com.elkabelaya.playlistmaker.common.data.repository.FavoriteTracksRepositoryImpl
import com.elkabelaya.playlistmaker.common.data.repository.LocalStorageRepositoryImpl
import com.elkabelaya.playlistmaker.common.data.repository.PermissionsRepositoryImpl
import com.elkabelaya.playlistmaker.common.data.repository.PlaylistsDbMapper
import com.elkabelaya.playlistmaker.common.data.repository.PlaylistsRepositoryImpl
import com.elkabelaya.playlistmaker.common.data.repository.PreferencesRepositoryImpl
import com.elkabelaya.playlistmaker.common.data.repository.ThemeRepositoryImpl
import com.elkabelaya.playlistmaker.common.data.repository.TracksDbMapper
import com.elkabelaya.playlistmaker.common.data.repository.TracksMapper
import com.elkabelaya.playlistmaker.common.domain.repository.FavoriteTracksRepository
import com.elkabelaya.playlistmaker.common.domain.repository.LocalStorage
import com.elkabelaya.playlistmaker.common.domain.repository.LocalStorageRepository
import com.elkabelaya.playlistmaker.common.domain.repository.LoopRepository
import com.elkabelaya.playlistmaker.common.domain.repository.PermissionsRepository
import com.elkabelaya.playlistmaker.common.domain.repository.PlaylistsRepository
import com.elkabelaya.playlistmaker.common.domain.repository.PreferencesRepository
import com.elkabelaya.playlistmaker.common.domain.repository.ThemeRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val commonDataModule = module {
    single<ItunesApi>{ RetrofitClient.itunesService }
    single<TracksMapper> { TracksMapperImpl() }
    factory<LoopRepository>{ CoroutinesLoopRepositoryImpl() }
    single<PreferencesRepository>{ PreferencesRepositoryImpl(get(), get()) }
    single<ThemeRepository>{ ThemeRepositoryImpl() }
    single<AppDatabase> {
        Room
            .databaseBuilder(get(), AppDatabase::class.java, DbConstants.DB_FILE_NAME)
            .addMigrations(
                AppDatabase.HANDLE_MIGRATION_1_2,
                AppDatabase.HANDLE_MIGRATION_2_3
            )
            .build()
    }
    single<TracksDbMapper> { TracksDbMapperImpl() }
    single<FavoriteTracksDao>{
        val dataBase: AppDatabase = get()
        dataBase.favoriteTracksDao()
    }
    single<FavoriteTracksRepository> { FavoriteTracksRepositoryImpl(get(), get()) }
    single<PlaylistsDbMapper> { PlaylistsDbMapperImpl(get()) }
    single<PlaylistsDao>{
        val dataBase: AppDatabase = get()
        dataBase.playlistsDao()
    }
    single<PlaylistsRepository>{ PlaylistsRepositoryImpl(get(), get(), get()) }
    factory<LocalStorageRepository>(named(CommonDiNames.PLAYLIST_COVERS_FOLDER_NAME)) {
        LocalStorageRepositoryImpl(get(), LocalStorage.PLAYLIST_COVERS_FOLDER.folder)
    }
    single<PermissionsRepository>{ PermissionsRepositoryImpl() }
}
