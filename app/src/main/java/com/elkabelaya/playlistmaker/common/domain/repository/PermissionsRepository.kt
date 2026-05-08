package com.elkabelaya.playlistmaker.common.domain.repository

import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Playlists
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.model.Tracks
import kotlinx.coroutines.flow.Flow
enum class Permission {
    NOTIFICATIONS
}

interface PermissionsRepository {
    fun save(permitted: Boolean, permission: Permission)
    fun get(permission: Permission): Boolean
}