package com.elkabelaya.playlistmaker.editplaylist.presentation

import android.net.Uri
import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.empty
import com.elkabelaya.playlistmaker.common.presentation.utils.SingleLiveData
import com.elkabelaya.playlistmaker.editplaylist.domain.api.EditPlayListInteractor
import com.elkabelaya.playlistmaker.editplaylist.domain.model.EditPlaylistMode
import com.elkabelaya.playlistmaker.editplaylist.domain.model.EditPlaylistState
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EditPlaylistViewModelImpl(
    val interactor: EditPlayListInteractor,
     initialPlaylist: Playlist?
): EditPlaylistViewModel() {
    private val _state = MutableStateFlow(EditPlaylistState(initialPlaylist != null, initialPlaylist == null))
    override var state: StateFlow<EditPlaylistState> = _state.asStateFlow()
    private val _mode = MutableStateFlow(if (initialPlaylist == null) EditPlaylistMode.NEW else EditPlaylistMode.EDIT)
    override var mode: StateFlow<EditPlaylistMode> = _mode.asStateFlow()

    private  var _playList: MutableStateFlow<Playlist?> = MutableStateFlow(null)
    override var playList: StateFlow<Playlist?> = _playList.asStateFlow()

    private  var _image: MutableStateFlow<String?> = MutableStateFlow(null)
    override var image: StateFlow<String?> = _image.asStateFlow()


    var isSaved: Boolean = initialPlaylist != null

    init {
        if (initialPlaylist == null) {
            viewModelScope.launch(Dispatchers.IO) {
                val id = interactor.initiate()
                viewModelScope.launch(Dispatchers.Main) {
                    _playList.value = Playlist.empty().copy(id = id)
                }
            }
        } else {
            _playList.value = initialPlaylist
            _image.value = initialPlaylist.coverUrl
        }

    }

    override fun onCleared() {
        super.onCleared()
        dispose()
    }

    override fun save() {
        isSaved = true
        _playList.value?.let {
            var playlist = it
            viewModelScope.launch(Dispatchers.IO) {
                var savedUrl: String? = null
                _image.value?.let { imageUrl ->
                    if (imageUrl != playlist.coverUrl) {
                        savedUrl = interactor.addCover(imageUrl.toUri(), playlist.id)
                        playlist = playlist.copy(coverUrl = savedUrl)
                    }
                }
                interactor.save(playlist)
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun dispose() {
        if (!isSaved) {
            _playList.value?.let {
                GlobalScope.launch(Dispatchers.IO) {
                    interactor.delete(it)
                }
            }
        }
    }

    override fun addImage(uri:Uri?) {
        _image.value = uri.toString()
    }

    override fun changeName(name: String) {
        _playList.value?.let {
            val newName = name.trim()
            _playList.value = it.copy(name = name.trim())
            _state.value = _state.value.copy(
                    isSaveEnabled = !newName.isEmpty(),
                    needDialog = needDialog()
                )
        }
    }

    override fun changeDescription(description: String) {
        _playList.value?.let {
            _playList.value = it.copy(description = description.trim())
            _state.value = _state.value.copy(
                    needDialog = needDialog()
                )

        }
    }

    private fun needDialog(): Boolean {
        return !isSaved and hasAnyData()
    }

    private fun hasAnyData(): Boolean {
        _playList.value?.let {
            return it.name.isNotEmpty() or
                    (it.description?.isNotEmpty() == true) or
                    (_image.value?.isNotEmpty() == true)
        }
        return false
    }
}