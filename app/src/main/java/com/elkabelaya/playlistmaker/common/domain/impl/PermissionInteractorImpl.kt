package com.elkabelaya.playlistmaker.common.domain.impl

import com.elkabelaya.playlistmaker.common.domain.api.PermissionInteractor
import com.elkabelaya.playlistmaker.common.domain.repository.Permission
import com.elkabelaya.playlistmaker.common.domain.repository.PermissionsRepository

class PermissionInteractorImpl(val repository: PermissionsRepository): PermissionInteractor {
    override fun registerNotifications(permitted: Boolean) {
        repository.save(permitted, Permission.NOTIFICATIONS)
    }
}