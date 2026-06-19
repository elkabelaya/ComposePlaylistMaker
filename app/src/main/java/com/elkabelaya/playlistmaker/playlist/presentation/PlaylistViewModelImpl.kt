package com.elkabelaya.playlistmaker.playlist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Playlists
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.model.Tracks
import com.elkabelaya.playlistmaker.common.domain.repository.ExternalNavigatorRepository
import com.elkabelaya.playlistmaker.common.presentation.utils.SingleLiveData
import com.elkabelaya.playlistmaker.media.domain.model.MediaFavoritesState
import com.elkabelaya.playlistmaker.player.domain.api.PlayerFavoriteInteractor
import com.elkabelaya.playlistmaker.player.domain.api.PlayerInteractor
import com.elkabelaya.playlistmaker.player.domain.api.PlayerNavigatorInteractor
import com.elkabelaya.playlistmaker.player.domain.api.PlayerPlaylistsInteractor
import com.elkabelaya.playlistmaker.player.domain.model.PlayerState
import com.elkabelaya.playlistmaker.playlist.domain.api.PlaylistInteractor
import com.elkabelaya.playlistmaker.playlist.domain.api.PlaylistNavigatorInteractor
import com.elkabelaya.playlistmaker.playlist.domain.model.PlaylistState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class PlaylistViewModelImpl(
    val playlistInteractor: PlaylistInteractor,
    val navigatorInteractor: PlaylistNavigatorInteractor,
    initialPlaylist: Playlist
) : PlaylistViewModel() {

    private val _state: MutableStateFlow<PlaylistState> = MutableStateFlow(
        PlaylistState(
            initialPlaylist,
            tracks = emptyList()
        )
    )
    override val state: StateFlow<PlaylistState> = _state.asStateFlow()

    private val _dialogState: MutableStateFlow<String?> = MutableStateFlow(null)
    override val dialogState: StateFlow<String?> = _dialogState.asStateFlow()

    init {
        viewModelScope.launch {
            combine(
                playlistInteractor.getPlaylist(initialPlaylist),
                playlistInteractor.getTracks(initialPlaylist)
            ) { playlist, tracks ->
                PlaylistState(playlist = playlist, tracks = tracks)
            }
                .flowOn(Dispatchers.IO)
                .collect { combinedState ->
                    _state.value = combinedState
                }
        }
    }
    override fun onShare() {
        state.value.let {

            val result = playlistInteractor.getDescription(it.playlist, it.tracks )

            result.first?.let {
                navigatorInteractor.navigateToShare(it)
            }

            result.second?.let {
                _dialogState.value =  it
            }
        }
    }


    override fun select(track: Track) {
        navigatorInteractor.navigateTo(track)
    }

    override fun delete(track: Track) {
        viewModelScope.launch(Dispatchers.IO) {
            playlistInteractor.remove(track)
        }
    }

    override fun onDelete() {
        viewModelScope.launch(Dispatchers.IO) {
            playlistInteractor.remove()
        }
    }

    override fun onEdit() {
        navigatorInteractor.navigateToEdit(_state.value.playlist)
    }
}