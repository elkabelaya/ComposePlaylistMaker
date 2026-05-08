package com.elkabelaya.playlistmaker.media.presentation.repository

import android.content.Context
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.media.domain.repository.MediaFavoritesErrorRepository

class MediaFavoritesErrorRepositoryImpl(val context: Context): MediaFavoritesErrorRepository {
    override fun getErrorText(): String {
        return context.getString(R.string.media_favorites_error_empty)
    }
}