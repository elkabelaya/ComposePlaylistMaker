package com.elkabelaya.playlistmaker.player.presentation.repository

import android.content.Context
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.presentation.utils.showAppToast
import com.elkabelaya.playlistmaker.player.domain.repository.PlayerDefaultsRepository

class PlayerDefaultsRepositoryImpl(val context: Context): PlayerDefaultsRepository {
    override fun getEmptyTime(): String {
        return context.getString(R.string.player_empty_time)
    }

    override fun addToastText(added: Boolean, playlist: String): String {
        val stringId = if (added) R.string.player_playlist_added else R.string.player_playlist_not_added
        return  context.getString(stringId, playlist)
    }
}