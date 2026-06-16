package com.elkabelaya.playlistmaker.editplaylist.presentation.preview

import android.net.Uri
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.editplaylist.domain.model.EditPlaylistMode
import com.elkabelaya.playlistmaker.editplaylist.domain.model.EditPlaylistState
import com.elkabelaya.playlistmaker.editplaylist.presentation.EditPlaylistViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class EditPlaylistViewModelMock(state: EditPlaylistState,
                                mode: EditPlaylistMode,
                                playlist: Playlist?,
                                image: String?): EditPlaylistViewModel() {


    override var state: StateFlow<EditPlaylistState> =
        MutableStateFlow(state)
    override var mode: StateFlow<EditPlaylistMode> =
        MutableStateFlow(mode)

    override var playList: StateFlow<Playlist?> =  MutableStateFlow(playlist)

    override var image: StateFlow<String?> =  MutableStateFlow(image)

    override fun save() {}
    override fun dispose() {}

    override fun addImage(uri: Uri?) {}

    override fun changeName(name: String) {}

    override fun changeDescription(description: String) {}
}