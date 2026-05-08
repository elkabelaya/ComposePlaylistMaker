package com.elkabelaya.playlistmaker.media.presentation.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.use_case.ClickDebounceUseCase
import com.elkabelaya.playlistmaker.media.domain.api.MediaFavoritesInteractor
import com.elkabelaya.playlistmaker.media.domain.api.MediaNavigatorInteractor
import com.elkabelaya.playlistmaker.media.domain.model.MediaFavoritesState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MediaFavoritesViewModelImpl(
    val interactor: MediaFavoritesInteractor,
    val navigatorInteractor: MediaNavigatorInteractor,
    val clickDebounceUseCase: ClickDebounceUseCase
): MediaFavoritesViewModel() {
    private val _state = MutableStateFlow<MediaFavoritesState>(MediaFavoritesState.Loading)
    override var state: StateFlow<MediaFavoritesState> = _state.asStateFlow()
    init {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.getFracks()
                .collect { result ->
                    result.first?.let {
                        _state.value =  MediaFavoritesState.Data(it)
                    }
                    result.second?.let {
                        _state.value = MediaFavoritesState.Error(it)
                    }
                }
        }
    }
    override fun select(track: Track) {
        if (clickDebounceUseCase.canClickDebounced()) {
            navigatorInteractor.navigateTo(track)
        }
    }
}