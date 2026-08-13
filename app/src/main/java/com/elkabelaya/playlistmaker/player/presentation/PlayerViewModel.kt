package com.elkabelaya.playlistmaker.player.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Playlists
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.presentation.ComposeStateFullViewModel
import com.elkabelaya.playlistmaker.common.presentation.StateFullViewModel
import com.elkabelaya.playlistmaker.common.presentation.utils.SingleLiveData
import com.elkabelaya.playlistmaker.player.domain.model.PlayerState
import kotlinx.coroutines.flow.StateFlow

abstract class PlayerViewModel: ComposeStateFullViewModel<PlayerState>, ViewModel() {
    abstract val track: Track?
    abstract var isFavorite: StateFlow<Boolean>
    abstract var playlists: StateFlow<Playlists>
    abstract var toast: StateFlow<String?>
    abstract fun togglePlay()
    abstract fun toggleFavorite()
    abstract fun onPause()
    abstract fun onResume()
    abstract fun createPlaylist()
    abstract fun select(playlist: Playlist)
}
