package com.elkabelaya.playlistmaker.search.domain.use_case

import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.model.Tracks

interface HistoryUseCase {
    val elements: Tracks
    fun add(element: Track)
    fun clear()
}