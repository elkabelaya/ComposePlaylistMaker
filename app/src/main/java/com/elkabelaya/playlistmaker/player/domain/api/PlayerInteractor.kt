package com.elkabelaya.playlistmaker.player.domain.api

import com.elkabelaya.playlistmaker.common.domain.api.StateFullInteractor
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.player.domain.model.PlayerState

interface PlayerInteractor: StateFullInteractor<PlayerState> {
    fun setup(track: Track)
    fun time(): String
    fun togglePlay()
    fun onPause()
    fun onResume()
    fun destroy()
    fun onPrepared()
    fun onComplete()
}