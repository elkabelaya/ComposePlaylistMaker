package com.elkabelaya.playlistmaker.common.data.repository

import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Playlists
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.model.Tracks
import com.elkabelaya.playlistmaker.common.domain.repository.Permission
import com.elkabelaya.playlistmaker.common.domain.repository.PermissionsRepository
import kotlinx.coroutines.flow.Flow

class PermissionsRepositoryImpl: PermissionsRepository {
    private var permissions = mutableMapOf<Permission, Boolean>()
    override fun save(permitted: Boolean, permission: Permission) {
        permissions[permission] = permitted
    }

    override fun get(permission: Permission): Boolean {
        return permissions[permission] ?: false
    }
}