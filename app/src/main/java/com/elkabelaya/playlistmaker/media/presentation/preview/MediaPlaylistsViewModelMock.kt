package com.elkabelaya.playlistmaker.media.presentation.preview

import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.media.domain.model.MediaPlaylistsState
import com.elkabelaya.playlistmaker.media.presentation.playlists.MediaPlaylistsViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MediaPlaylistsViewModelMock(state: MediaPlaylistsState): MediaPlaylistsViewModel() {
    private val _state = MutableStateFlow<MediaPlaylistsState>(MediaPlaylistsState.Loading)
    override var state: StateFlow<MediaPlaylistsState> = _state.asStateFlow()
    init {
        _state.value = state
    }
    override fun select(playlist: Playlist) {}

    override fun create() {}


}