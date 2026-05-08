package com.elkabelaya.playlistmaker.common.domain.repository
import com.elkabelaya.playlistmaker.common.domain.model.Navigation

interface NavigatorRepository {
    fun navigateTo(navigation: Navigation)
}

