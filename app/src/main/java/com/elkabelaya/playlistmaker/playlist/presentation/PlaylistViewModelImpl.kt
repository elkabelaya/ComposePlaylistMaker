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
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class PlaylistViewModelImpl(
    val playlistInteractor: PlaylistInteractor,
    val navigatorInteractor: PlaylistNavigatorInteractor,
    initialPlaylist: Playlist
) : PlaylistViewModel() {

    private val playlistState: LiveData<PlaylistState> = liveData {
        combine(
            playlistInteractor.getPlaylist(initialPlaylist),
            playlistInteractor.getTracks(initialPlaylist)
        ) { playlist, tracks ->
            PlaylistState(playlist = playlist, tracks = tracks)
        }
        .flowOn(Dispatchers.IO)
        .collect { combinedState ->
            emit(combinedState)
        }
    }
    override fun observeState(): LiveData<PlaylistState> = playlistState

    private val dialogState: SingleLiveData<String?> = SingleLiveData(null)
    override fun observeDialogState(): LiveData<String?> = dialogState

    override fun onShare() {
        playlistState.value?.let {

            val result = playlistInteractor.getDescription(it.playlist, it.tracks )

            result.first?.let {
                navigatorInteractor.navigateToShare(it)
            }

            result.second?.let {
                dialogState.postValue( it)
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
        playlistState.value?.playlist?.let {
            navigatorInteractor.navigateToEdit(it)
        }
    }


}