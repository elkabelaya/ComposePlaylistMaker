package com.elkabelaya.playlistmaker.media.presentation.playlists

import androidx.lifecycle.ViewModel
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.presentation.ComposeStateFullViewModel
import com.elkabelaya.playlistmaker.common.presentation.StateFullViewModel
import com.elkabelaya.playlistmaker.media.domain.model.MediaPlaylistsState

abstract class MediaPlaylistsViewModel: ComposeStateFullViewModel<MediaPlaylistsState>, ViewModel() {
    abstract fun select(playlist: Playlist)
    abstract fun create()
}