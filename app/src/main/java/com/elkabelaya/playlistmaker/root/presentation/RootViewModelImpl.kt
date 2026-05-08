package com.elkabelaya.playlistmaker.root.presentation

import androidx.lifecycle.ViewModel
import com.elkabelaya.playlistmaker.common.domain.api.PermissionInteractor

class RootViewModelImpl(val permissionInteractor: PermissionInteractor): RootViewModel() {
    override fun onNotification(permitted: Boolean) {
        permissionInteractor.registerNotifications(permitted)
    }
}