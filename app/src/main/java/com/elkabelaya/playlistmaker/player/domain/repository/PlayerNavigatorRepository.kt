package com.elkabelaya.playlistmaker.player.domain.repository

import com.elkabelaya.playlistmaker.common.domain.model.Navigation

interface PlayerNavigatorRepository {
    fun getNewPlayLst(): Navigation
}