package com.elkabelaya.playlistmaker.playlist.presentation.preview

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.editplaylist.domain.model.EditPlaylistState
import com.elkabelaya.playlistmaker.playlist.domain.model.PlaylistState
import com.elkabelaya.playlistmaker.playlist.presentation.PlaylistViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PlaylistViewModelMock(state: PlaylistState,
                            dialogState: String? = null
): PlaylistViewModel() {
    override var state: StateFlow<PlaylistState> = MutableStateFlow(state)
    override var dialogState: StateFlow<String?> = MutableStateFlow(dialogState)

    override fun onShare() {}

    override fun select(track: Track) {}

    override fun delete(track: Track) {}

    override fun onDelete() { }

    override fun onEdit() {}


}