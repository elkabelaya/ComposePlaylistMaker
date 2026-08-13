package com.elkabelaya.playlistmaker.player.presentation.preview

import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Playlists
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.player.domain.model.PlayerState
import com.elkabelaya.playlistmaker.player.presentation.PlayerViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlayerViewModelMock(override val track: Track?,
                          playerState: PlayerState,
                          isFavorite: Boolean = false,
                          playlists: Playlists = emptyList(),
                          toast: String? = null
    ) : PlayerViewModel() {

    private val _state = MutableStateFlow<PlayerState>(PlayerState.Default(""))
    override var state: StateFlow<PlayerState> = _state.asStateFlow()
    private val _isFavorite = MutableStateFlow(false)
    override var isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()
    private val _playlists = MutableStateFlow<Playlists>(emptyList())
    override var playlists: StateFlow<Playlists> = _playlists.asStateFlow()
    private val _toast = MutableStateFlow<String?>(null)
    override var toast: StateFlow<String?> = _toast.asStateFlow()

    init {
        _state.value = playerState
        _isFavorite.value = isFavorite
        _playlists.value = playlists
        _toast.value = toast
    }
    override fun togglePlay() {}

    override fun toggleFavorite() {}

    override fun onPause() {}

    override fun onResume() {}

    override fun createPlaylist() {}

    override fun select(playlist: Playlist) {}
}