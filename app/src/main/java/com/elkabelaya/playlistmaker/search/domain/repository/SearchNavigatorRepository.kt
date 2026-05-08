package com.elkabelaya.playlistmaker.search.domain.repository

import com.elkabelaya.playlistmaker.common.domain.model.Navigation
import com.elkabelaya.playlistmaker.common.domain.model.Track

interface SearchNavigatorRepository {
    fun getPlayer(item: Track): Navigation
}