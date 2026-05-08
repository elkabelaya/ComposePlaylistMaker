package com.elkabelaya.playlistmaker.media.presentation.repository

import android.content.Context
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.media.domain.repository.MediaPlaylistsErrorRepository

class MediaPlaylistsErrorsRepositoryImpl(val context: Context): MediaPlaylistsErrorRepository {
    override fun getErrorText(): String {
        return context.getString(R.string.media_playlist_error_not_created)
    }
}