package com.elkabelaya.playlistmaker.editplaylist.domain.model

import com.elkabelaya.playlistmaker.common.domain.model.Playlist

enum class EditPlaylistMode {
    EDIT,
    NEW
}
data class EditPlaylistState(
                             val isSaveEnabled: Boolean,
                             val needDialog: Boolean)

