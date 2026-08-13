package com.elkabelaya.playlistmaker.player.presentation

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Playlists
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.presentation.utils.SingleLiveData
import com.elkabelaya.playlistmaker.player.domain.api.PlayerFavoriteInteractor
import com.elkabelaya.playlistmaker.player.domain.api.PlayerInteractor
import com.elkabelaya.playlistmaker.player.domain.api.PlayerNavigatorInteractor
import com.elkabelaya.playlistmaker.player.domain.api.PlayerPlaylistsInteractor
import com.elkabelaya.playlistmaker.player.domain.model.PlayerState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class PlayerViewModelImpl(
    val playerInteractor: PlayerInteractor,
    val favoritesInteractor: PlayerFavoriteInteractor,
    val playlistsInteractor: PlayerPlaylistsInteractor,
    val navigatorInteractor: PlayerNavigatorInteractor,
    override val track: Track?
) : PlayerViewModel() {
    private var timerJob: Job? = null

    private val _playerState = MutableStateFlow<PlayerState>(PlayerState.Default(""))
    override val state: StateFlow<PlayerState> = _playerState.asStateFlow()
    private val _isFavorite = MutableStateFlow(false)
    override var isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()
    private val _playlists = MutableStateFlow<Playlists>(emptyList())
    override var playlists: StateFlow<Playlists> = _playlists.asStateFlow()
    private val _toast = MutableStateFlow<String?>(null)
    override var toast: StateFlow<String?> = _toast.asStateFlow()

    init {
        track?.let {
            playerInteractor.setup(it)
        }
        playerInteractor.onState{ state ->
            timerJob?.cancel()
            _playerState.value = state
            if (state is PlayerState.Playing) {
                timerJob = viewModelScope.launch(Dispatchers.IO) {
                    while (true) {
                        delay(PLAYER_DEBOUNCE_DELAY)
                        _playerState.value = PlayerState.Playing(playerInteractor.time())
                    }
                }
            }
        }
        updateFavorite()
        viewModelScope.launch(Dispatchers.IO) {
            playlistsInteractor.get()
                .collect {
                    _playlists.value = it
                }
        }
    }

    override fun togglePlay(){
        playerInteractor.togglePlay()
    }

    override fun toggleFavorite() {
        track?.let {
            viewModelScope.launch(Dispatchers.IO) {
                favoritesInteractor.toggle(track)
                updateFavorite()
            }
        }
    }

    override fun createPlaylist() {
        navigatorInteractor.navigateToNewPlaylist()
    }

    override fun select(playlist: Playlist) {
        track?.let {
            viewModelScope.launch(Dispatchers.IO) {
                val result = playlistsInteractor.add(it, playlist)
                _toast.value = result
            }

        }
    }

    override fun onPause() {
        playerInteractor.onPause()
    }

    override fun onResume() {
        playerInteractor.onResume()
    }

    override fun onCleared() {
        playerInteractor.destroy()
    }

    private fun updateFavorite() {
        track?.let {
            viewModelScope.launch(Dispatchers.IO) {
                _isFavorite.value = favoritesInteractor.isFavorite(track)
            }
        }
    }
    companion object {
        private const val PLAYER_DEBOUNCE_DELAY = 300L
    }
}