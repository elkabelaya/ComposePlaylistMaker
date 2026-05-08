package com.elkabelaya.playlistmaker.root.presentation

import androidx.lifecycle.ViewModel
import com.elkabelaya.playlistmaker.common.domain.api.PermissionInteractor

abstract class RootViewModel(): ViewModel() {
    abstract fun onNotification(permitted: Boolean)
}