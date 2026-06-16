package com.elkabelaya.playlistmaker.editplaylist.presentation

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.presentation.ComposeStateFullViewModel
import com.elkabelaya.playlistmaker.common.presentation.StateFullViewModel
import com.elkabelaya.playlistmaker.editplaylist.domain.model.EditPlaylistMode
import com.elkabelaya.playlistmaker.editplaylist.domain.model.EditPlaylistState
import kotlinx.coroutines.flow.StateFlow

abstract class EditPlaylistViewModel: ComposeStateFullViewModel<EditPlaylistState>, ViewModel() {
    abstract var mode: StateFlow<EditPlaylistMode>
    abstract var playList: StateFlow<Playlist?>
    abstract var image: StateFlow<String?>
    abstract fun save()
    abstract fun dispose()
    abstract fun addImage(uri: Uri?)
    abstract fun changeName(name: String)
    abstract fun changeDescription(description: String)
}