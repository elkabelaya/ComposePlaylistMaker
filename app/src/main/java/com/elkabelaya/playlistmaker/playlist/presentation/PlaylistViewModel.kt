package com.elkabelaya.playlistmaker.playlist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Playlists
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.model.Tracks
import com.elkabelaya.playlistmaker.common.presentation.StateFullViewModel
import com.elkabelaya.playlistmaker.common.presentation.utils.SingleLiveData
import com.elkabelaya.playlistmaker.player.domain.model.PlayerState
import com.elkabelaya.playlistmaker.playlist.domain.model.PlaylistState

abstract class PlaylistViewModel: StateFullViewModel<PlaylistState>, ViewModel() {
    abstract fun observeDialogState(): LiveData<String?>
    abstract fun onShare()
    abstract fun select(track: Track)
    abstract fun delete(track: Track)
    abstract fun onDelete()
    abstract fun onEdit()
}
