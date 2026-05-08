package com.elkabelaya.playlistmaker.player.domain.repository

import com.elkabelaya.playlistmaker.common.domain.model.Track

interface PlayerRepository {
    fun set(track: Track)
    fun setupPlayer(onPrepared: () -> Unit, onComplete: () -> Unit, onChange:(Boolean) -> Unit)
    fun time(): Int
    fun play()
    fun pause()

    fun onFragmentPause()
    fun onFragmentResume()
    fun destroy()
}